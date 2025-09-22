class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        int maxFreq = 0;
        int countMaxFreqElements = 0;

        for (int num : nums) {
            freq[num]++;

            if (freq[num] > maxFreq) {
                maxFreq = freq[num];
                countMaxFreqElements = freq[num];
            } else if (freq[num] == maxFreq) {
                countMaxFreqElements += freq[num];
            }
        }
        return countMaxFreqElements;
    }
}