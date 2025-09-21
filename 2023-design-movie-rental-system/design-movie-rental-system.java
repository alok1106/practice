class MovieRentingSystem {

    private Map<String, Integer> priceMap;

    private Map<Integer, TreeSet<int[]>> available;

    private TreeSet<int[]> rented;

    public MovieRentingSystem(int n, int[][] entries) {
        priceMap = new HashMap<>();
        available = new HashMap<>();

        Comparator<int[]> cmpAvail = (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        };

        Comparator<int[]> cmpRented = (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        };

        rented = new TreeSet<>(cmpRented);

        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            String key = shop + "#" + movie;
            priceMap.put(key, price);

            available.putIfAbsent(movie, new TreeSet<>(cmpAvail));
            available.get(movie).add(new int[]{price, shop, movie});
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> res = new ArrayList<>();
        if (!available.containsKey(movie)) return res;

        int count = 0;
        for (int[] x : available.get(movie)) {
            res.add(x[1]); // shopId
            if (++count == 5) break;
        }
        return res;
    }

    public void rent(int shop, int movie) {
        String key = shop + "#" + movie;
        int price = priceMap.get(key);

        available.get(movie).remove(new int[]{price, shop, movie});
        rented.add(new int[]{price, shop, movie});
    }

    public void drop(int shop, int movie) {
        String key = shop + "#" + movie;
        int price = priceMap.get(key);

        rented.remove(new int[]{price, shop, movie});
        available.get(movie).add(new int[]{price, shop, movie});
    }

    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>();
        int count = 0;
        for (int[] x : rented) {
            res.add(Arrays.asList(x[1], x[2]));
            if (++count == 5) break;
        }
        return res;
    }
}
