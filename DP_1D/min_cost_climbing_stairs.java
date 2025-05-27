class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        for(int i=2;i<cost.length;i++)
        cost[i]+= Math.min(cost[i-1],cost[i-2]);

        return Math.min(cost[cost.length-1], cost[cost.length-2]);


        /*int n = cost.length;

        // Start from the second-to-last step and work backwards
        for (int i = n - 3; i >= 0; i--) {
            cost[i] += Math.min(cost[i + 1], cost[i + 2]);
        }

        // Return the minimum cost to start from either step 0 or step 1
        return Math.min(cost[0], cost[1]);*/
    }
}
