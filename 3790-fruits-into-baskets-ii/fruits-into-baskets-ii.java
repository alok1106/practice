class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int unplaced = 0;
        
        boolean[] is_basket_used = new boolean[n];
        Arrays.fill(is_basket_used, false);
        
        for(int i = 0; i<n; i++){
            boolean is_placed = false;
            for(int j = 0; j<n; j++){
                if(is_basket_used[j] == false && fruits[i] <= baskets[j]){
                    is_basket_used[j] = true;
                    is_placed = true;
                    break;
                }
            }
            if(!is_placed){
                unplaced += 1;
            }
        }
        return unplaced;
    }
}