public class Router {
    private final int memoryLimit;
    private final Deque<int[]> queue;
    private final Set<String> seen;
    private final Map<Integer, ArrayList<Integer>> timesByDest;
    private final Map<Integer, Integer> headByDest;

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.queue = new ArrayDeque<>();
        this.seen = new HashSet<>();
        this.timesByDest = new HashMap<>();
        this.headByDest = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String key = makeKey(source, destination, timestamp);

        if (seen.contains(key)) return false; //duplicate

        if (queue.size() == memoryLimit) { //full size
            int[] oldest = queue.removeFirst();
            String oldKey = makeKey(oldest[0], oldest[1], oldest[2]);
            seen.remove(oldKey);

            int dst = oldest[1];
            headByDest.put(dst, headByDest.getOrDefault(dst, 0) + 1);
        }

        // add new packet
        queue.addLast(new int[]{source, destination, timestamp});
        seen.add(key);

        ArrayList<Integer> list = timesByDest.computeIfAbsent(destination, k -> new ArrayList<>());
        list.add(timestamp);

        return true;
    }

    public int[] forwardPacket() {
        if (queue.isEmpty()) return new int[0];

        int[] pkt = queue.removeFirst();
        String key = makeKey(pkt[0], pkt[1], pkt[2]);
        seen.remove(key);

        int dst = pkt[1];
        headByDest.put(dst, headByDest.getOrDefault(dst, 0) + 1);

        return pkt;
    }

    public int getCount(int destination, int startTime, int endTime) {
        ArrayList<Integer> list = timesByDest.get(destination);
        if (list == null) return 0;

        int head = headByDest.getOrDefault(destination, 0);
        int n = list.size();
        if (head >= n) return 0;

        //binary search
        int left = lowerBound(list, head, n, startTime);
        int rightEx = lowerBound(list, head, n, endTime + 1);

        return Math.max(0, rightEx - left);
    }

    private String makeKey(int s, int d, int t) {
        return s + "#" + d + "#" + t;
    }

    private int lowerBound(ArrayList<Integer> a, int lo, int hi, int target) {
        int l = lo, r = hi;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (a.get(mid) < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
