class Solution {
    public int missingNumber(int[] nums) {
        
        int n = nums.length;
        int sum = 0;
        int sum1 = 0;

        for(int num : nums)
        sum += num;

        for(int i=1;i<=n;i++)
        sum1 += i;

        return sum1-sum;

        /*int n = nums.length;
        int xorArray = 0;
        int xorRange = 0;

        // XOR all elements in the array
        for (int num : nums) {
            xorArray ^= num;
        }

        // XOR all numbers from 0 to n
        for (int i = 0; i <= n; i++) {
            xorRange ^= i;
        }

        // The missing number will be the result of XOR of both
        return xorArray ^ xorRange;*/
    }
}

