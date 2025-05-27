public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] buy_dp = new int[n];
        int[] sell_dp = new int[n];
        int[] cooldown_dp = new int[n];

        buy_dp[0]=-prices[0];
        //sell_dp[0] = 0;
        //cooldown_dp[0] = 0;
        
        for(int i=1;i<n;i++)
        {
            buy_dp[i]=Math.max(buy_dp[i-1], cooldown_dp[i-1]-prices[i]);
            sell_dp[i]=Math.max(sell_dp[i-1], buy_dp[i-1]+prices[i]);
            cooldown_dp[i]=Math.max(cooldown_dp[i-1], sell_dp[i-1]);
        }
        return sell_dp[n-1];








       /* if (prices.length == 0) return 0;

        // Initialize dp arrays for buy, sell, and cooldown
        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];
        int[] cooldown = new int[n];

        // Base case for day 0
        buy[0] = -prices[0];
        sell[0] = 0;
        cooldown[0] = 0;

        // Fill the dp arrays for each day
        for (int i = 1; i < n; i++) {
            buy[i] = Math.max(buy[i-1], cooldown[i-1] - prices[i]);
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);
            cooldown[i] = Math.max(cooldown[i-1], sell[i-1]);
            //System.out.println( "   buy[i] : " +buy[i]+ "   sell[i] : " +sell[i] + "   cooldown[i] : "  +cooldown[i]  );
        }

        // The maximum profit will be in sell[n-1]
        return sell[n-1];*/
    }
}

