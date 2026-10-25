class Solution {
    int[] x={-1,1,0,0};
    int[] y={0,0,-1,1};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original=image[sr][sc];
        if(original==color)return image;

        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{sr,sc});

        image[sr][sc]=color;

        while(!q.isEmpty()){
            int[] curr=q.poll();
            int r=curr[0];
            int c=curr[1];

            for(int k=0;k<4;k++){
                int nr=r+x[k];
                int nc=c+y[k];
                if(nr>=0 && nr<image.length && 
                nc>=0 && nc<image[0].length && image[nr][nc]==original){
                    image[nr][nc]=color;
                    q.add(new int[]{nr,nc});
                }
                
            }
        }
        return image;

    }
   
}