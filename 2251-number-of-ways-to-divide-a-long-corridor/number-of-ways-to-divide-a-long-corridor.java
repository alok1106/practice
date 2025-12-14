class Solution {
    public int numberOfWays(String corridor) {
        final int MOD = 1_000_000_007;

        int totalSeats = 0;
        for (char c : corridor.toCharArray()) {
            if (c == 'S') totalSeats++;
        }

        if (totalSeats == 0 || totalSeats % 2 == 1) return 0;

        long ways = 1;
        int seatCount = 0;
        int plantsBetween = 0;
        boolean countingPlants = false;

        for (char c : corridor.toCharArray()) {
            if (c == 'S') {
                seatCount++;

                if (seatCount % 2 == 0) {
                    countingPlants = true;
                    plantsBetween = 0;
                } 
                else if (seatCount > 2) {
                    ways = (ways * (plantsBetween + 1)) % MOD;
                    plantsBetween = 0;
                }
            } 
            else if (countingPlants) {
                plantsBetween++;
            }
        }

        return (int) ways;
    }
}
