class Solution {
    int[] dp = new int[1001];

    public boolean solve(int i, String s, Set<String> s1) {
        if (i == s.length()) {
            return true;
        }

        if (dp[i] != 0) {
            return dp[i] == 1;
        }

        String temp = "";
        for (int j = i; j < s.length(); j++) {
            temp += s.charAt(j);
            if (s1.contains(temp)) {
                if (solve(j + 1, s, s1)) {
                    dp[i] = 1;
                    return true;
                }
            }
        }

        dp[i] = -1;
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Arrays.fill(dp, 0);
        Set<String> s1 = new HashSet<>(wordDict);
        return solve(0, s, s1);
    }
}
