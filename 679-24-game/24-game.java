class Solution {

    // Epsilon for floating point comparison to handle precision issues.
    private static final double EPSILON = 1e-6;

    public boolean judgePoint24(int[] nums) {
        // Convert the input int array to a list of doubles.
        List<Double> list = new ArrayList<>();
        for (int num : nums) {
            list.add((double) num);
        }
        // Start the recursive backtracking process.
        return solve(list);
    }

    private boolean solve(List<Double> nums) {
        // Base Case 1: If we are down to a single number, check if it's 24.
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24.0) < EPSILON;
        }

        // Base Case 2: If we have no numbers, no solution.
        if (nums.isEmpty()) {
            return false;
        }

        // Recursive Step: Try all pairs and all operations.
        // Use nested loops to pick two numbers (i and j).
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                // Create a new list with the remaining numbers.
                List<Double> nextNums = new ArrayList<>();
                for (int k = 0; k < nums.size(); k++) {
                    if (k != i && k != j) {
                        nextNums.add(nums.get(k));
                    }
                }

                double num1 = nums.get(i);
                double num2 = nums.get(j);

                // Try all 6 possible operations (+, -, *, /) and their permutations.
                // 1. Addition
                nextNums.add(num1 + num2);
                if (solve(nextNums)) return true;
                nextNums.remove(nextNums.size() - 1);

                // 2. Subtraction (num1 - num2)
                nextNums.add(num1 - num2);
                if (solve(nextNums)) return true;
                nextNums.remove(nextNums.size() - 1);
                
                // 3. Subtraction (num2 - num1)
                nextNums.add(num2 - num1);
                if (solve(nextNums)) return true;
                nextNums.remove(nextNums.size() - 1);

                // 4. Multiplication
                nextNums.add(num1 * num2);
                if (solve(nextNums)) return true;
                nextNums.remove(nextNums.size() - 1);

                // 5. Division (num1 / num2)
                if (Math.abs(num2) > EPSILON) { // Avoid division by zero
                    nextNums.add(num1 / num2);
                    if (solve(nextNums)) return true;
                    nextNums.remove(nextNums.size() - 1);
                }

                // 6. Division (num2 / num1)
                if (Math.abs(num1) > EPSILON) { // Avoid division by zero
                    nextNums.add(num2 / num1);
                    if (solve(nextNums)) return true;
                    nextNums.remove(nextNums.size() - 1);
                }
            }
        }
        
        return false;
    }
}