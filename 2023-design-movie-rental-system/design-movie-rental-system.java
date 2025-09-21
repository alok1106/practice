class MovieRentingSystem {

    private record Key(int shop, int movie) {}

    private record MovieEntry(int price, int shop, int movie) {}

    private final Map<Key, Integer> priceMap;
    private final Map<Integer, TreeSet<MovieEntry>> available;
    private final TreeSet<MovieEntry> rented;

    public MovieRentingSystem(int n, int[][] entries) {
        priceMap = new HashMap<>();
        available = new HashMap<>();

        Comparator<MovieEntry> cmpAvail = Comparator
                .comparingInt(MovieEntry::price)
                .thenComparingInt(MovieEntry::shop);

        Comparator<MovieEntry> cmpRented = Comparator
                .comparingInt(MovieEntry::price)
                .thenComparingInt(MovieEntry::shop)
                .thenComparingInt(MovieEntry::movie);

        rented = new TreeSet<>(cmpRented);

        // Initialize available movies
        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            priceMap.put(new Key(shop, movie), price);

            available.putIfAbsent(movie, new TreeSet<>(cmpAvail));
            available.get(movie).add(new MovieEntry(price, shop, movie));
        }
    }

    public List<Integer> search(int movie) {
    TreeSet<MovieEntry> emptySet = new TreeSet<>(
        Comparator.comparingInt(MovieEntry::price)
                  .thenComparingInt(MovieEntry::shop)
    );

    return available.getOrDefault(movie, emptySet)
            .stream()
            .limit(5)
            .map(MovieEntry::shop)
            .toList();
    }

    public void rent(int shop, int movie) {
        int price = priceMap.get(new Key(shop, movie));
        MovieEntry entry = new MovieEntry(price, shop, movie);

        available.get(movie).remove(entry);
        rented.add(entry);
    }

    public void drop(int shop, int movie) {
        int price = priceMap.get(new Key(shop, movie));
        MovieEntry entry = new MovieEntry(price, shop, movie);

        rented.remove(entry);
        available.get(movie).add(entry);
    }

    public List<List<Integer>> report() {
        return rented.stream()
                .limit(5)
                .map(entry -> Arrays.asList(entry.shop(), entry.movie()))
                .toList();
    }
}
