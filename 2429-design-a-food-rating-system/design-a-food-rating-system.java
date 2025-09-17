import java.util.*;

class FoodRatings {
    private Map<String, Integer> foodRating;
    private Map<String, String> foodCuisine;
    private Map<String, TreeSet<String>> cuisineFoods;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodRating = new HashMap<>();
        foodCuisine = new HashMap<>();
        cuisineFoods = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            foodRating.put(food, rating);
            foodCuisine.put(food, cuisine);

            cuisineFoods.putIfAbsent(cuisine, new TreeSet<>(
                (a, b) -> {
                    if (!foodRating.get(a).equals(foodRating.get(b))) {
                        return foodRating.get(b) - foodRating.get(a);
                    }
                    return a.compareTo(b);
                }
            ));
            cuisineFoods.get(cuisine).add(food);
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodCuisine.get(food);
        TreeSet<String> set = cuisineFoods.get(cuisine);

        set.remove(food);

        foodRating.put(food, newRating);

        set.add(food);
    }

    public String highestRated(String cuisine) {
        return cuisineFoods.get(cuisine).first();
    }
}
