class Solution {
    public int numDistinct(String s, String t) {
    int m = s.length();
        int n = t.length();
        
        // Step 1: Create a DP table
        int[][] dp = new int[m + 1][n + 1];
        
        // Step 2: Initialize the base cases
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1; // There's 1 way to match an empty t
        }
        
        /*for (int j = 1; j <= n; j++) {
            dp[0][j] = 0; // No way to match a non-empty t with an empty s
        }*/
        
        // Step 3: Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        // Step 4: Return the result
        return dp[m][n];
    }
}
