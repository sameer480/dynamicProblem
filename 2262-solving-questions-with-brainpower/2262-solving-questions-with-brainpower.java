class Solution {
    public long solve(int i,int n,int [] [] u,long[] dp){
        if(i>=n){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        long take= u[i][0]+solve(i+u[i][1]+1,n,u,dp);
        long ntake=solve(i+1,n,u,dp);
        return dp[i]=Math.max(take,ntake);
    }
    public long mostPoints(int[][] u) {
        int n= u.length;
        long [] dp= new long[n+1];
        Arrays.fill(dp,-1);
        return solve(0,n,u,dp);
        
    }
}