class Solution {
    public int maxSumDivThree(int[] nums) {
        int totalSum = 0;

        int smallest1 = Integer.MAX_VALUE, secondSmallest1 = Integer.MAX_VALUE;
        int smallest2 = Integer.MAX_VALUE, secondSmallest2 = Integer.MAX_VALUE;

        for (int num : nums) {
            totalSum += num;

            if (num % 3 == 1) {
                if (num < smallest1) {
                    secondSmallest1 = smallest1;
                    smallest1 = num;
                } else if (num < secondSmallest1) {
                    secondSmallest1 = num;
                }
            } else if (num % 3 == 2) {
                if (num < smallest2) {
                    secondSmallest2 = smallest2;
                    smallest2 = num;
                } else if (num < secondSmallest2) {
                    secondSmallest2 = num;
                }
            }
        }

        if (totalSum % 3 == 0) return totalSum;

        int remainder = totalSum % 3;
        int remove = Integer.MAX_VALUE;

        if (remainder == 1) {
            // option 1: remove 1 smallest num % 3 == 1
            if (smallest1 != Integer.MAX_VALUE)
                remove = Math.min(remove, smallest1);

            // option 2: remove 2 smallest nums % 3 == 2
            if (smallest2 != Integer.MAX_VALUE && secondSmallest2 != Integer.MAX_VALUE)
                remove = Math.min(remove, smallest2 + secondSmallest2);
        } else { // remainder == 2
            if (smallest2 != Integer.MAX_VALUE)
                remove = Math.min(remove, smallest2);

            if (smallest1 != Integer.MAX_VALUE && secondSmallest1 != Integer.MAX_VALUE)
                remove = Math.min(remove, smallest1 + secondSmallest1);
        }

        return totalSum - remove;
    }
}
