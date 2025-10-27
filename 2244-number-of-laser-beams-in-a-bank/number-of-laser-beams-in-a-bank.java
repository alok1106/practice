class Solution {
    public int numberOfBeams(String[] bank) {
        int beams = 0;
        int prevDevices = 0;
        for (String row : bank) {
            int currDevices = 0;
            for (char c : row.toCharArray()) {
                if (c == '1') currDevices++;
            }
            if (currDevices > 0) {
                beams += prevDevices * currDevices;
                prevDevices = currDevices;
            }
        }
        return beams;
    }
}
