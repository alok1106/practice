
class Solution {

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        List<String> electronics = new ArrayList<>();
        List<String> grocery = new ArrayList<>();
        List<String> pharmacy = new ArrayList<>();
        List<String> restaurant = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {
            if (!isActive[i]) continue;
            if (!validateCode(code[i])) continue;

            switch (businessLine[i]) {
                case "electronics":
                    electronics.add(code[i]);
                    break;
                case "grocery":
                    grocery.add(code[i]);
                    break;
                case "pharmacy":
                    pharmacy.add(code[i]);
                    break;
                case "restaurant":
                    restaurant.add(code[i]);
                    break;
                default:
                    // invalid business line
            }
        }

        Collections.sort(electronics);
        Collections.sort(grocery);
        Collections.sort(pharmacy);
        Collections.sort(restaurant);

        List<String> result = new ArrayList<>();
        result.addAll(electronics);
        result.addAll(grocery);
        result.addAll(pharmacy);
        result.addAll(restaurant);

        return result;
    }

    private boolean validateCode(String code) {
        return code != null &&
               !code.isEmpty() &&
               code.matches("[a-zA-Z0-9_]+");
    }
}
