
class Solution {

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        int n = code.length;

        ArrayList<String> electronics = new ArrayList<>();
        ArrayList<String> grocery = new ArrayList<>();
        ArrayList<String> pharmacy = new ArrayList<>();
        ArrayList<String> restaurant = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!isActive[i]) continue;

            String c = code[i];
            if (!isValidCode(c)) continue;

            String b = businessLine[i];
            if (b == null) continue;

            switch (b) {
                case "electronics":
                    electronics.add(c);
                    break;
                case "grocery":
                    grocery.add(c);
                    break;
                case "pharmacy":
                    pharmacy.add(c);
                    break;
                case "restaurant":
                    restaurant.add(c);
                    break;
                default:
                    // invalid business line
            }
        }

        Collections.sort(electronics);
        Collections.sort(grocery);
        Collections.sort(pharmacy);
        Collections.sort(restaurant);

        int size =
            electronics.size() +
            grocery.size() +
            pharmacy.size() +
            restaurant.size();

        ArrayList<String> result = new ArrayList<>(size);
        result.addAll(electronics);
        result.addAll(grocery);
        result.addAll(pharmacy);
        result.addAll(restaurant);

        return result;
    }

    // 🚀 Faster than regex
    private boolean isValidCode(String s) {
        if (s == null || s.length() == 0) return false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!(ch >= 'a' && ch <= 'z') &&
                !(ch >= 'A' && ch <= 'Z') &&
                !(ch >= '0' && ch <= '9') &&
                ch != '_') {
                return false;
            }
        }
        return true;
    }
}
