class Solution {
    public boolean isMatch(String s, String p) {
     int m = s.length(), n = p.length();
    boolean[][] dp = new boolean[m + 1][n + 1];

    // Base case: empty string matches empty pattern
    dp[m][n] = true;

    // Fill the table bottom-up
    for (int i = m; i >= 0; i--) {
        for (int j = n - 1; j >= 0; j--) {
            // Check if characters match or pattern contains '.'
            boolean match = (i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));
            //System.out.println("    i : " + i + "     j : "  + j + "    match :  "  + match);
            //if(i<m)
            //System.out.println("    s.charAt(i) : " + s.charAt(i) + "     p.charAt(j) : "  + p.charAt(j));
            if (j + 1 < n && p.charAt(j + 1) == '*') {
                // Handle '*'
                dp[i][j] = dp[i][j + 2] || (match && dp[i + 1][j]);
                //System.out.println("   first ---------------- dp[i][j] : " + dp[i][j] );
            } else {
                // Regular match
                dp[i][j] = match && dp[i + 1][j + 1];
                                //System.out.println("   second ---------------- dp[i][j] : " + dp[i][j] );
            }
        }
    }

    // Final answer is in dp[0][0]
    return dp[0][0];
}
}
