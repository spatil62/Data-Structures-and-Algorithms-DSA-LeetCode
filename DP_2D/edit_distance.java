class Solution {
    public int minDistance(String word1, String word2) {
      int m = word1.length(); // Length of word1
        int n = word2.length(); // Length of word2

        // Step 1: Initialize the DP table with size (m+1) x (n+1)
        int[][] dp = new int[m + 1][n + 1];

        // Step 2: Fill the base cases for the last row and column
        // When word1 is empty, we need to add all characters of word2
        for (int j = 0; j <= n; j++) {
            dp[m][j] = n - j;
        }

        // When word2 is empty, we need to delete all characters of word1
        for (int i = 0; i <= m; i++) {
            dp[i][n] = m - i;
        }

        // Step 3: Fill the DP table from bottom-right to top-left
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // If the characters match, no operation is needed
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    // If characters don't match, consider insert, delete, and replace
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], // Delete from word1
                                    Math.min(dp[i][j + 1], // Insert into word1
                                             dp[i + 1][j + 1])); // Replace
                }
            }
        }

        // Step 4: Return the answer stored at dp[0][0]
        return dp[0][0];
    }
}
