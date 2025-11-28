class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {

        // adjacency list for tree
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        int[] count = new int[1]; // this will store answer

        dfs(0, -1, graph, values, k, count);
        return count[0];
    }

    private int dfs(int node, int parent,
                    List<List<Integer>> graph,
                    int[] values, int k, int[] count) {

        long sum = values[node];

        for (int neigh : graph.get(node)) {
            if (neigh == parent) continue;

            sum += dfs(neigh, node, graph, values, k, count);
        }

        // if divisible by k, one component is formed
        if (sum % k == 0) {
            count[0]++;
            return 0; // cut this subtree, do not pass upward
        }

        return (int)(sum % k); // pass remaining sum upward
    }
}