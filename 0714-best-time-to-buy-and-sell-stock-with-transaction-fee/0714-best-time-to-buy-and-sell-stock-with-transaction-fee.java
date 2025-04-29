class Solution {
    int solve(int i, int[] p, int[][] dp, int bag, int fee) {
        if (i >= p.length) {
            return 0;
        }
        if (dp[i][bag] != -1) {
            return dp[i][bag];
        }

        if (bag == 1) {
            
            int op1 = p[i] - fee + solve(i + 1, p, dp, 0, fee);
            int op2 = solve(i + 1, p, dp, 1, fee);              
            return dp[i][bag] = Math.max(op1, op2);
        } else {
           
            int op1 = -p[i] + solve(i + 1, p, dp, 1, fee); 
            int op2 = solve(i + 1, p, dp, 0, fee);        
            return dp[i][bag] = Math.max(op1, op2);
        }
    }

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(0, prices, dp, 0, fee);
    }
}
