import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Map<Integer, Integer> lastRainDay = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();

        for(int day=0; day<n; day++){
            if(rains[day] == 0){
                dryDays.add(day);
                ans[day] = 1;
            } else {
                ans[day] = -1;
                if(lastRainDay.containsKey(rains[day])){  
                    int prevRainDay = lastRainDay.get(rains[day]);
                    Integer dryDay = dryDays.ceiling(prevRainDay); 
                    if(dryDay == null){
                        return new int[0];
                    }
                    ans[dryDay] = rains[day];
                    dryDays.remove(dryDay);
                }
                lastRainDay.put(rains[day], day);
            }
        }
        return ans;
    }
}