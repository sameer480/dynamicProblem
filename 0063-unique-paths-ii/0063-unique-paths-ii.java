class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        int [] [] dp= new int[r][c];
         if(grid[0][0]==1){
            return 0;
         }
         dp[0][0]=1;
         for(int j=1;j<c;j++){
            if(grid[0][j]==0){
            dp[0][j]=dp[0][j-1];
            }
         }
         for(int i=1;i<r;i++){
            if(grid[i][0]==0){
                dp[i][0]=dp[i-1][0];
            }
         }
         for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                if(grid[i][j]==0){
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
         }

        return dp[r-1][c-1];
    }
}