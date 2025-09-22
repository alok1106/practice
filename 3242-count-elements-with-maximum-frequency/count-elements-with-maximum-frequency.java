class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int maxFreq = 0;
        for (int num : nums) {
            int freq = frequencyMap.getOrDefault(num, 0) + 1;
            frequencyMap.put(num, freq);
            maxFreq = Math.max(maxFreq, freq);
        }

        int maxFreqElements = 0;
        for (int freq : frequencyMap.values()) {
            if (freq == maxFreq) maxFreqElements += freq;
        }
        return maxFreqElements;
    }
}