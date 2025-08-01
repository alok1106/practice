class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = Map.of(
            'I',1,
            'V',5,
            'X',10,
            'L',50,
            'C',100,
            'D',500,
            'M',1000
        );

        int total = 0;
        int prev = 0;

        for(int i = s.length()-1; i > -1; i--){
            int current = map.get(s.charAt(i));
            if(current < prev){
                total -=current;
            } else {
                total +=current;
            }

            prev = current;
        }

        return total;
    }
}
