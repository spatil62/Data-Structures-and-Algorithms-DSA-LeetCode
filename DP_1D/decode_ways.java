class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case: an empty string has one way to decode

        // Check first character
        dp[1] = s.charAt(0) != '0' ? 1 : 0;

        for (int i = 2; i <= n; i++) {
            // Check the single-digit number ending at position i-1
            int singleDigit = s.charAt(i - 1) - '0';
            if (singleDigit >= 1 && singleDigit <= 9) {
                dp[i] += dp[i - 1];
                //even i can write it as 
                //dp[i] = dp[i-1];
            }

            // Check the two-digit number ending at position i-1
            int twoDigits = (s.charAt(i - 2) - '0') * 10 + singleDigit;
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}
