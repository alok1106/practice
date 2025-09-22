class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int maxFreq = 0;
        int countMaxFreqElements = 0;

        for (int num : nums) {
            int freq = frequencyMap.getOrDefault(num, 0) + 1;
            frequencyMap.put(num, freq);

            if (freq > maxFreq) {
                maxFreq = freq;
                countMaxFreqElements = freq;
            } else if (freq == maxFreq) {
                countMaxFreqElements += freq;
            }
        }
        return countMaxFreqElements;
    }
}