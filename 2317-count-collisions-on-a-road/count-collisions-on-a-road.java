class Solution {
    public int countCollisions(String directions) {

        // Remove leading 'L'
        int start = 0;
        while (start < directions.length() && directions.charAt(start) == 'L') {
            start++;
        }

        // Remove trailing 'R'
        int end = directions.length() - 1;
        while (end >= 0 && directions.charAt(end) == 'R') {
            end--;
        }

        // Remaining substring after trim
        String mid = directions.substring(start, end + 1);

        // Remove all 'S'
        String withoutS = mid.replace("S", "");

        return withoutS.length(); // length of remaining L and R
    }
}