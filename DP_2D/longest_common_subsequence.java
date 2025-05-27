class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m+1][n+1];

        for(int i=m-1;i>=0;i--)
        for(int j=n-1;j>=0;j--)
        {
            if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    // Otherwise, take the max between skipping a character from text1 or text2
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
        }
        

        // The answer is stored at the top-left corner of the DP table
        return dp[0][0];
    }
}

