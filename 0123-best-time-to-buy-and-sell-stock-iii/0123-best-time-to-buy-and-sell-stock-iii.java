import java.util.*;

class Solution {
    public int solve(int i, int[] p, int bag, int[][][] dp, int limit) {
        if (i >= p.length) {
            return 0;
        }
        if (limit == 0) {
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

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3]; // [day][buy/sell][limit]
        for (int[][] twoD : dp) {
            for (int[] row : twoD) {
                Arrays.fill(row, -1);
            }
        }
        return solve(0, prices, 0, dp, 2);
    }
}
