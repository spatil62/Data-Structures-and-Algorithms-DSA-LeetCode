class Solution {
    public int maxCoins(int[] nums) {
         // Step 1: Add padding (1 at the beginning and end of nums)
        int n = nums.length;
        int[] paddedNums = new int[n + 2];
        paddedNums[0] = 1;
        paddedNums[n + 1] = 1;
        for (int i = 0; i < n; i++) {
        paddedNums[i + 1] = nums[i];
        }

        // Step 2: Create DP table
        int[][] dpMatrix = new int[n + 2][n + 2];

        // Step 3: Fill DP table for all possible subarray lengths
        for (int len = 1; len <= n; len++) { // len is the length of the subarray
            for (int i = 1; i <= n - len + 1; i++) { // i is the starting index
                int j = i + len - 1; // j is the ending index of the subarray

                // Step 4: Burst all balloons in the subarray [i, j]
                for (int k = i; k <= j; k++) { // k is the last balloon to burst in [i, j]
                    int leftValue = paddedNums[i - 1]; // Value to the left of the subarray
                    int rightValue = paddedNums[j + 1]; // Value to the right of the subarray

                    int before = dpMatrix[i][k - 1]; // Coins from bursting balloons in [i, k-1]
                    int after = dpMatrix[k + 1][j];  // Coins from bursting balloons in [k+1, j]

                    // Calculate max coins for bursting balloon k last
                dpMatrix[i][j] = Math.max(dpMatrix[i][j], (leftValue * paddedNums[k] * rightValue) + before + after);
            }
        }
    }

    // Step 5: Return the result for the entire range [1, n]
    return dpMatrix[1][n];
    }
}
