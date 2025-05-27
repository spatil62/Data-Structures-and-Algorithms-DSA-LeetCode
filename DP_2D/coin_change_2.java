class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1; // Base case: One way to make amount 0 (using no coins)

        for (int coin : coins) { // For each coin
            for (int i = coin; i <= amount; i++) { // Update dp for amounts >= coin
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount]; // Result is the number of ways to make 'amount'
    }
}
