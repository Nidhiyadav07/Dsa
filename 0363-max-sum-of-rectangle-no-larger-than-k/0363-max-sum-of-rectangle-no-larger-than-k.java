
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int ans = Integer.MIN_VALUE;
        int[][] prefix = new int[rows + 1][cols + 1];

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {

                prefix[i][j] =
                    matrix[i - 1][j - 1]
                    + prefix[i - 1][j]
                    + prefix[i][j - 1]
                    - prefix[i - 1][j - 1];
            }
        }

        
        for (int r1 = 0; r1 < rows; r1++) {

           
            for (int r2 = r1; r2 < rows; r2++) {

                
                for (int c1 = 0; c1 < cols; c1++) {

                    
                    for (int c2 = c1; c2 < cols; c2++) {

                        int sum = prefix[r2 + 1][c2 + 1]
                                - prefix[r1][c2 + 1]
                                - prefix[r2 + 1][c1]
                                + prefix[r1][c1];

                        if (sum <= k) {
                            ans = Math.max(ans, sum);
                        }
                    }
                }
            }
        }

        return ans;
    }
    }
