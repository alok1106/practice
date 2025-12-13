class Solution {

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        Map<String, Integer> priority = Map.of(
            "electronics", 0,
            "grocery", 1,
            "pharmacy", 2,
            "restaurant", 3
        );

        return IntStream.range(0, code.length)
            .boxed()
            .filter(i ->
                isActive[i] &&
                validateCode(code[i]) &&
                validateBusinessLine(businessLine[i])
            )
            .sorted((i, j) -> {
                int p1 = priority.get(businessLine[i]);
                int p2 = priority.get(businessLine[j]);
                if (p1 != p2) return p1 - p2;
                return code[i].compareTo(code[j]);
            })
            .map(i -> code[i])
            .collect(Collectors.toList());
    }

    private static boolean validateCode(String code) {
        return code != null &&
               !code.isEmpty() &&
               code.matches("[a-zA-Z0-9_]+");
    }

    private static boolean validateBusinessLine(String line) {
        return line != null && (
            line.equals("electronics") ||
            line.equals("grocery") ||
            line.equals("pharmacy") ||
            line.equals("restaurant")
        );
    }
}
