
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            if (color[i] != 0) continue;

            color[i] = 1;
            q.add(i);

            while (!q.isEmpty()) {
                int node = q.poll();

                for (int adj : graph[node]) {

                    if (color[adj] == 0) {
                        color[adj] = -color[node];
                        q.add(adj);
                    }
                    else if (color[adj] == color[node]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
