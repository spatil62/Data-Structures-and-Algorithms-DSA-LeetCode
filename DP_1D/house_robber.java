class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        // Base cases
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        // Modify nums array to store max robbed amounts
        nums[1] = Math.max(nums[0], nums[1]); // Update for the second house
        for (int i = 2; i < n; i++) 
            nums[i] = Math.max(nums[i - 1], nums[i] + nums[i - 2]);

        // Return the max robbed amount at the last house
        return nums[n - 1];
    }
}
