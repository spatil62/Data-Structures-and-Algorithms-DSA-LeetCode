class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] LIS = new int[nums.length];
        
        // Initialize LIS array with 1s, as the smallest LIS for each element is itself
        for (int i = 0; i < nums.length; i++) {
            LIS[i] = 1;
        }

        // Process the array in reverse order to calculate LIS
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    LIS[i] = Math.max(LIS[i], 1 + LIS[j]);
                }
            }
        }

        // Find the maximum length of LIS
        int maxLength = 0;
        for (int len : LIS) {
            maxLength = Math.max(maxLength, len);
        }

        return maxLength;
    }
}
