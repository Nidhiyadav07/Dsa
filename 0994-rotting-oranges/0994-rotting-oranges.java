class Solution {

    int[] x={1,-1,0,0};
    int[] y={0,0,1,-1};

    public boolean valid(int rows, int cols, int i, int j) {
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if(fresh == 0)
            return 0;

        int minutes = 0;

        while(!q.isEmpty()) {

            int size = q.size();

            while(size-- > 0) {
                
                int[] curr=q.poll();
                int r = curr[0];
                int c = curr[1];

                for(int k = 0; k < 4; k++) {

                    int nr = r + x[k];
                    int nc = c + y[k];

                    if(valid(m, n, nr, nc) && grid[nr][nc] == 1) {

                        grid[nr][nc] = 2;
                        fresh--;

                        q.offer(new int[]{nr, nc});
                    }
                }
            }
        if(!q.isEmpty())
                minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}
