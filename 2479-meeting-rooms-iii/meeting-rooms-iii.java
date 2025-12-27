class Solution {
    public int mostBooked(int n, int[][] meetings) {

        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        // free rooms (by room number)
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) freeRooms.add(i);

        // busy rooms (by end time, then room number)
        PriorityQueue<long[]> busyRooms = new PriorityQueue<>(
            (a, b) -> a[0] == b[0]
                ? Long.compare(a[1], b[1])
                : Long.compare(a[0], b[0])
        );

        int[] count = new int[n];

        for (int[] m : meetings) {
            long start = m[0];
            long end = m[1];
            long duration = end - start;

            // free rooms that are done
            while (!busyRooms.isEmpty() && busyRooms.peek()[0] <= start) {
                freeRooms.add((int) busyRooms.poll()[1]);
            }

            if (!freeRooms.isEmpty()) {
                int room = freeRooms.poll();
                count[room]++;
                busyRooms.add(new long[]{end, room});
            } else {
                long[] earliest = busyRooms.poll();
                long newEnd = earliest[0] + duration;
                int room = (int) earliest[1];
                count[room]++;
                busyRooms.add(new long[]{newEnd, room});
            }
        }

        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[ans]) {
                ans = i;
            }
        }

        return ans;
    }
}
