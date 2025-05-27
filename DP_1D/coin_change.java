class Solution {
    public int coinChange(int[] coins, int amount) {
        //backtrack with memoization
        /* // Create a memoization map to store the results of subproblems
        Map<Integer, Integer> memo = new HashMap<>();
        
        // Start backtracking
        int result = backtrack(coins, amount, memo);
        
        // If the result is still Integer.MAX_VALUE, it means no solution was found
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int backtrack(int[] coins, int amount, Map<Integer, Integer> memo) {
        // Base case: if amount is 0, return 0 (no coins needed)
        if (amount == 0) {
            return 0;
        }

        // Base case: if amount is negative, return invalid
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }

        // Check if the result for this amount is already in the memo
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }

        int minCoins = Integer.MAX_VALUE;

        // Try all coins
        for (int coin : coins) {
            int result = backtrack(coins, amount - coin, memo);
            
            // If the result is valid, update minCoins
            if (result != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, result + 1);
            }
        }

        // Store the result in the memo before returning
        memo.put(amount, minCoins);

        return minCoins;
    }
}*/



        /*// Start backtracking
        int result = backtrack(coins, amount, 0);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int backtrack(int[] coins, int amount, int count) {
        // Base case: if amount is 0, return the count
        if (amount == 0) {
            return count;
        }

        // Base case: if amount is negative, return invalid
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }

        int minCoins = Integer.MAX_VALUE;

        // Try all coins
        for (int coin : coins) {
            int result = backtrack(coins, amount - coin, count + 1);
            minCoins = Math.min(minCoins, result);
        }

        return minCoins;
    }
}*/

        //using dynamic programming 
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount + 1);
        dp[0]=0;
        
        for(int i=1;i<=amount;i++)
        {
            for(int coin : coins)
            {
                if (i - coin >= 0)
                {
                    dp[i] = Math.min(dp[i], 1+dp[i-coin]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}




        /*int[] dp = new int[amount + 1];
        // Initialize all values to a large number (amount + 1 is used as "infinity")
        Arrays.fill(dp, amount + 1);
        // Base case: 0 coins are needed to make an amount of 0
        dp[0] = 0;

        // Iterate over each amount from 1 to the target amount
        for (int a = 1; a <= amount; a++) {
            // Check each coin
            for (int coin : coins) {
                // If the current amount is greater than or equal to the coin value
                if (a - coin >= 0) {
                    // Update dp[a] with the minimum value
                    dp[a] = Math.min(dp[a], 1 + dp[a - coin]);
                }
            }
        }

        // If the value for dp[amount] is still amount + 1, it means it's not possible to make the amount
        return dp[amount] > amount ? -1 : dp[amount];
    }
}*/
