class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count=0;
        for(int city=0;city<n;city++){
                if(!visited[city]){
                    count++;
                    dfs(isConnected,visited,city);
                } 
        }return count;

    }
    public void dfs(int[][] isConnected,boolean[] visited,int city){
        visited[city]=true;

        for(int neigh=0;neigh<isConnected.length;neigh++){
            if(isConnected[city][neigh]==1& !visited[neigh]){
                dfs(isConnected,visited,neigh);
            }
        }

    }
}