import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Map<Integer, Integer> fullDays = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();

        for(int i=0; i<n; i++){
            if(rains[i] == 0){
                dryDays.add(i);
                ans[i] = 1;
            } else {
                ans[i] = -1;
                if(fullDays.containsKey(rains[i])){                
                    Integer dryDay = dryDays.higher(fullDays.get(rains[i])); 
                    if(dryDay == null){
                        return new int[0];
                    }
                    ans[dryDay] = rains[i];
                    dryDays.remove(dryDay);
                }
                fullDays.put(rains[i], i);
            }
        }
        return ans;
    }
}