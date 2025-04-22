class Solution {
    int m, n;
    int[][] dp = new int[1001][1001];

    public int solve(int i, int j, String s1, String s2) {
        if (i >= m && j >= n) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (i >= m) {
            return dp[i][j] = s2.charAt(j) + solve(i, j + 1, s1, s2);
        }
        if (j >= n) {
            return dp[i][j] = s1.charAt(i) + solve(i + 1, j, s1, s2);
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = solve(i + 1, j + 1, s1, s2);
        }

        int delete1 = s1.charAt(i) + solve(i + 1, j, s1, s2);
        int delete2 = s2.charAt(j) + solve(i, j + 1, s1, s2);

        return dp[i][j] = Math.min(delete1, delete2);
    }

    public int minimumDeleteSum(String s1, String s2) {
        m = s1.length();
        n = s2.length();

    
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, 0, s1, s2);
    }
}
