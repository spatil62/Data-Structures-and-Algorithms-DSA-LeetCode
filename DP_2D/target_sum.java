class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int sum = 0;

        for(int num:nums)
        sum+=num;

        int P = (sum+target)/2;


        if ((sum + target) % 2 != 0 || target < -sum || target > sum) {
            return 0; // Target is not achievable
        }

        int[] dp=new int[P+1];

        dp[0]=1;

        for(int num:nums)
        for(int i=P;i>=num;i--)
        dp[i]+=dp[i-num];

        return dp[P];
    











        /*// Step 1: Calculate the sum of all elements in the nums array
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // Step 2: Check if the target is achievable
        // We need (sum + target) to be even and (sum + target) / 2 should be a valid subset sum
        if ((sum + target) % 2 != 0 || target < -sum || target > sum) {
            return 0; // Target is not achievable
        }

        // Step 3: Calculate the positive sum (subset sum we need to find)
        int positiveSum = (sum + target) / 2;

        // Step 4: Create a DP array to count ways to achieve each subset sum up to positiveSum
        int[] dp = new int[positiveSum + 1];
        dp[0] = 1; // There's one way to achieve sum 0: by selecting no elements.

        // Step 5: Iterate over the elements of nums and update the dp array
        for (int num : nums) {
            // We iterate backward to avoid overwriting the results of the current iteration
            for (int j = positiveSum; j >= num; j--) {
                dp[j] += dp[j - num];  // If we can make sum (j - num), then we can make sum j by adding num
            }
        }

        // Step 6: The result is the number of ways to achieve the sum 'positiveSum'
        return dp[positiveSum];*/
    }
}
