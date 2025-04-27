class Solution {
    int solve(int[] coins, int[] dp, int amount) {
        if (amount == 0) {
            return 0;
        }
        
        if (dp[amount] != -1) {
            return dp[amount];
        }
        
        int ans = Integer.MAX_VALUE;
        
        for (int i = 0; i < coins.length; i++) {
            if (amount - coins[i] >= 0) {
                int subAns = solve(coins, dp, amount - coins[i]);
                
                if (subAns != Integer.MAX_VALUE) {
                    ans = Math.min(ans, subAns + 1);
                }
            }
        }
        
        return dp[amount] = ans;
    }
    
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        
        int ans = solve(coins, dp, amount);
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
