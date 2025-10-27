class Solution {
    public int numberOfBeams(String[] bank) {
        int beams = 0;
        int devices_in_prev_row = 0;
        for(int i = 0; i < bank.length; i++){
            String temp = bank[i];
            int devices_in_current_row = 0;
            for(int j = 0; j< temp.length(); j++){
                if (temp.charAt(j) == '1'){
                    devices_in_current_row++;
                }
            }
            if(devices_in_current_row > 0){
                beams += devices_in_prev_row * devices_in_current_row;
                devices_in_prev_row = devices_in_current_row;
            }
        }
        return beams;
    }
}