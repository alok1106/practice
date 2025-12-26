class Solution {
    public int bestClosingTime(String customers) {
        int penalty = 0;

        for (char c : customers.toCharArray()) {
            if (c == 'N') penalty++;
        }

        int minPenalty = penalty;
        int bestTime = 0;

        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') {
                penalty--;
            } else {
                penalty++;
            }

            if (penalty < minPenalty) {
                minPenalty = penalty;
                bestTime = i + 1;
            }
        }

        return bestTime;
    }
}