class FoodRatings {
    private static class Food {
        final String food;
        final int rating;
        Food(String food, int rating) { this.food = food; this.rating = rating; }
    }

    private final Map<String, Integer> foodRating = new HashMap<>();
    private final Map<String, String> foodCuisine = new HashMap<>();
    private final Map<String, PriorityQueue<Food>> cuisineHeap = new HashMap<>();

    private final Comparator<Food> cmp = (a, b) -> {
        int rc = Integer.compare(b.rating, a.rating);
        if (rc != 0) return rc;
        return a.food.compareTo(b.food);
    };

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            String f = foods[i], c = cuisines[i];
            int r = ratings[i];
            foodRating.put(f, r);
            foodCuisine.put(f, c);
            cuisineHeap.computeIfAbsent(c, k -> new PriorityQueue<>(cmp)).add(new Food(f, r));
        }
    }

    public void changeRating(String food, int newRating) {
        foodRating.put(food, newRating);
        String cuisine = foodCuisine.get(food);
        cuisineHeap.get(cuisine).add(new Food(food, newRating));
    }

    public String highestRated(String cuisine) {
        PriorityQueue<Food> heap = cuisineHeap.get(cuisine);
        while (!heap.isEmpty()) {
            Food top = heap.peek();
            int current = foodRating.getOrDefault(top.food, Integer.MIN_VALUE);
            if (top.rating != current) {
                heap.poll();
            } else {
                return top.food;
            }
        }
        return "";
    }
}