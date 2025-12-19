class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        // Sort meetings by time
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[2], b[2]));

        Set<Integer> knows = new HashSet<>();
        knows.add(0);
        knows.add(firstPerson);

        int i = 0;
        while (i < meetings.length) {
            int time = meetings[i][2];

            // Graph for this time only
            Map<Integer, List<Integer>> graph = new HashMap<>();
            Set<Integer> peopleInThisTime = new HashSet<>();

            // Collect all meetings at same time
            while (i < meetings.length && meetings[i][2] == time) {
                int x = meetings[i][0];
                int y = meetings[i][1];

                graph.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
                graph.computeIfAbsent(y, k -> new ArrayList<>()).add(x);

                peopleInThisTime.add(x);
                peopleInThisTime.add(y);
                i++;
            }

            // BFS only from people who already know the secret
            Queue<Integer> q = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();

            for (int p : peopleInThisTime) {
                if (knows.contains(p)) {
                    q.offer(p);
                    visited.add(p);
                }
            }

            // Spread within this time
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int nei : graph.getOrDefault(cur, new ArrayList<>())) {
                    if (!visited.contains(nei)) {
                        visited.add(nei);
                        q.offer(nei);
                    }
                }
            }

            // Everyone visited gets the secret
            knows.addAll(visited);
        }

        return new ArrayList<>(knows);
    }
}
