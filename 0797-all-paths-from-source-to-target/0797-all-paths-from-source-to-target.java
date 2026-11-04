class Solution {

    void dfs(int node, int[][] graph,
             List<Integer> path,
             List<List<Integer>> res) {

        // Target reached
        if (node == graph.length - 1) {
            res.add(new ArrayList<>(path));
            return;
        }

        // Explore neighbours
        for (int neighbour : graph[node]) {

            path.add(neighbour);

            dfs(neighbour, graph, path, res);

            // Backtracking
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> res = new ArrayList<>();

        List<Integer> path = new ArrayList<>();

        path.add(0);

        dfs(0, graph, path, res);

        return res;
    }
}