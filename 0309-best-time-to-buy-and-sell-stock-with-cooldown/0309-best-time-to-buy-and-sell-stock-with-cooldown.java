import java.util.Arrays;

class Solution {
    int solve(int i, int[] p, int[][] dp, int bag) {
        if (i >= p.length) {
            return 0;
        }
        if (dp[i][bag] != -1) {
            return dp[i][bag];
        }

        if (bag == 1) {
            // You can sell
            int op1 = p[i] + solve(i + 2, p, dp, 0); // sell and cooldown
            int op2 = solve(i + 1, p, dp, 1);        // skip
            return dp[i][bag] = Math.max(op1, op2);
        } else {
            // You can buy
            int op1 = -p[i] + solve(i + 1, p, dp, 1); // buy
            int op2 = solve(i + 1, p, dp, 0);         // skip
            return dp[i][bag] = Math.max(op1, op2);
        }
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(0, prices, dp, 0);
    }
}
