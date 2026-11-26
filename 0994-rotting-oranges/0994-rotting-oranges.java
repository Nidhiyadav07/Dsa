class Solution {

  int[] x={-1,1,0,0};
  int[] y={0,0,-1,1};

    public boolean validate(int i,int j,int n,int m){
        if(i<0 ||j<0 || i>=n || j>=m)return false;
        return true;
    }
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        int time=0;
        while(!q.isEmpty()&&fresh>0){
            time++;
            int size=q.size();
            for(int k=0;k<size;k++){
                int[] p=q.poll();
                int r=p[0];
                int c=p[1];
                for(int i=0;i<4;i++){
                    int row=r+x[i];
                    int col=c+y[i];
                    if(validate(row,col,grid.length,grid[0].length)&&grid[row][col]==1){
                        q.add(new int[]{row,col});
                        grid[row][col]=2;
                        fresh--;
                    }
                }
            }
            
        } return fresh == 0 ? time : -1;
    }
}
