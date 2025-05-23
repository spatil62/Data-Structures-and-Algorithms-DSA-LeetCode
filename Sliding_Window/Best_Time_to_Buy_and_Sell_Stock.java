class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int max_profit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<buy){
            buy = prices[i];
            }
            else if(prices[i]>buy){
            max_profit = Math.max(max_profit, prices[i]-buy);
            }
        }
        return max_profit;
    }
}

/*
class Solution {
    public int maxProfit(int[] prices) {
       /*int left = 0;
        int right = 1;
        int profit = 0;
        int max_profit = 0;

        for(int i=0;i<prices.length;i++)
        {    
            if(right<prices.length && prices[left]>prices[right])
            {
                left++;
                right++;
            }
            else if(right<prices.length && prices[left]<prices[right])
            {
                 profit = prices[right]-prices[left];
                 right++;
            }
            else if(right<prices.length && prices[left]==prices[right])
            right++;

            max_profit = Math.max(profit, max_profit);
        }    

        return max_profit;
    }
}*/

        /*int left = 0; // Pointer for buying price
        int max_profit = 0; // To keep track of the maximum profit

        for (int right = 1; right < prices.length; right++) {
            // If the current price at 'right' is less than the price at 'left', 
            // update 'left' to 'right' to consider the new buying price
            if (prices[right] < prices[left]) {
                left = right; // Update left to the current position
            } else {
                // Calculate profit if current price is higher than price at 'left'
                int profit = prices[right] - prices[left];
                max_profit = Math.max(max_profit, profit);
            }
        }

        return max_profit;
    }
}*/

    /*int profit = 0;
    int min = 0;

    int buy = prices[0];

    if(prices.length==1)
    return 0;

    for(int i=1;i<prices.length;i++)
    {
        if(prices[i]<buy)
        buy=prices[i];
            else if(prices[i]>buy)
        profit = Math.max(profit,prices[i]-buy);
    }
    return profit;
    }
}*/


