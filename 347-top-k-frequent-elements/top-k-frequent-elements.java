class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> freq = new HashMap<>();
        for(int n : nums){
            freq.put(n, freq.getOrDefault(n,0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        for(int i=0; i<bucket.length; i++) bucket[i] = new ArrayList();

        for(int key: freq.keySet()){
            bucket[freq.get(key)].add(key);
        }
        
        List<Integer> result = new ArrayList<>();
        for(int i = bucket.length - 1; i>=0; i--){
            result.addAll(bucket[i]);
            if(result.size() >= k) break;
        }

        int[] res = new int[k];
        for(int i = 0; i< k; i++){
            res[i] = result.get(i);
        } 
        return res;
    }
}