class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int hold = -prices[0]; // Max profit when holding a stock
        int cash = 0;          // Max profit when not holding any stock

        for (int i = 1; i < n; i++) {
            int prevCash = cash;
            cash = Math.max(cash, hold + prices[i] - fee); // Sell today
            hold = Math.max(hold, prevCash - prices[i]);   // Buy today
        }

        return cash; // Max profit is when not holding a stock
    }
}
