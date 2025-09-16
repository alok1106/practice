class Solution {
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private long lcm(long a, long b) {
        return (a / gcd((int)a, (int)b)) * b;
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        LinkedList<Long> stack = new LinkedList<>();

        for (int num : nums) {
            long curr = num;
            while (!stack.isEmpty()) {
                long top = stack.peekLast();
                long g = gcd((int)top, (int)curr);
                if (g == 1) break;
                curr = lcm(top, curr);
                stack.pollLast();
            }
            stack.add(curr);
        }

        List<Integer> result = new ArrayList<>();
        for (long val : stack) {
            result.add((int)val);
        }
        return result;
    }
}
