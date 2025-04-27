class Solution {
    int solve(int low, int high, int zero, int one, int i, long[] dp) {
       long mod = 1000000007L;
        
        if (i > high) {
            return 0;
        }
        
        if (dp[i] != -1) {
            return (int) dp[i];
        }
        
        dp[i] = i >= low ? 1 : 0;
        dp[i] = (dp[i] + solve(low, high, zero, one, i + zero, dp)) % mod;
        dp[i] = (dp[i] + solve(low, high, zero, one, i + one, dp)) % mod;
        
        return (int) dp[i];
    }
    
    public int countGoodStrings(int low, int high, int zero, int one) {
        long[] dp = new long[high + 1];
        Arrays.fill(dp, -1L);
        return solve(low, high, zero, one, 0, dp);
    }
}
