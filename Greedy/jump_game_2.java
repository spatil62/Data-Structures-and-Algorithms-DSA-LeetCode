class Solution {
    public int jump(int[] nums) {
        int res = 0; // Result to store the number of jumps
        int l = 0; // Left pointer of the current range
        int r = 0; // Right pointer of the current range

        while (r < nums.length - 1) {
            int farthest = 0;

            // Find the farthest point we can reach within the current range
            for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }

            l = r + 1; // Move the left pointer to the next range
            r = farthest; // Update the right pointer to the farthest point
            res++; // Increment the jump count
        }

        return res; // Return the minimum number of jumps
    }
}
