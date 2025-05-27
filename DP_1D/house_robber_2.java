class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        // Base cases
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        // Case 1: Rob houses from 0 to n-2 (skip the last house)
        int[] temp1 = Arrays.copyOfRange(nums, 0, n - 1); // Copy of nums[0..n-2]
        int value1 = robHelper(temp1);

        // Case 2: Rob houses from 1 to n-1 (skip the first house)
        int[] temp2 = Arrays.copyOfRange(nums, 1, n); // Copy of nums[1..n-1]
        int value2 = robHelper(temp2);

        // Return the maximum of the two cases
        return Math.max(value1, value2);
    }

    //easy consider same logic as robber 1 and apply it on index 0 to n-2 then
    //same logic apply it on index 1 to n-1 and return max bcoz its ciorcular robb this time 
    // Helper function to compute the maximum amount for a given array
    private int robHelper(int[] nums) {
        int n = nums.length;

        // Base cases
        //if (n == 1) return nums[0];
        //if (n == 2) return Math.max(nums[0], nums[1]);

        // Modify the temporary array to store max robbed amounts
        nums[1] = Math.max(nums[0], nums[1]); // Update for the second house
        for (int i = 2; i < n; i++) {
            nums[i] = Math.max(nums[i - 1], nums[i] + nums[i - 2]);
        }

        // Return the max robbed amount at the last house
        return nums[n - 1];
    }
}
