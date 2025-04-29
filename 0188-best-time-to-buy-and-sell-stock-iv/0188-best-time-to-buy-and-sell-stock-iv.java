import java.util.*;

class Solution {
    public int solve(int i, int[] p, int bag, int[][][] dp, int limit) {
        if (i >= p.length || limit == 0) {
            return 0;
        }
        if (dp[i][bag][limit] != -1) {
            return dp[i][bag][limit];
        }

        if (bag == 1) {
            // We can sell
            int sell = p[i] + solve(i + 1, p, 0, dp, limit - 1);
            int skip = solve(i + 1, p, 1, dp, limit);
            dp[i][bag][limit] = Math.max(sell, skip);
        } else {
            // We can buy
            int buy = -p[i] + solve(i + 1, p, 1, dp, limit);
            int skip = solve(i + 1, p, 0, dp, limit);
            dp[i][bag][limit] = Math.max(buy, skip);
        }

        return dp[i][bag][limit];
    }

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0 || k == 0) return 0;

        // Optimization: if k >= n/2, it's effectively unlimited transactions
        if (k >= n / 2) {
            int profit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }

        int[][][] dp = new int[n][2][k + 1];
        for (int[][] twoD : dp) {
            for (int[] row : twoD) {
                Arrays.fill(row, -1);
            }
        }
        return solve(0, prices, 0, dp, k);
    }
}
