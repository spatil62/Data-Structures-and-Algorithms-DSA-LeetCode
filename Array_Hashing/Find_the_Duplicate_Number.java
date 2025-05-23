class Solution {
    public int findDuplicate(int[] nums) {

        /*HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<nums.length;i++)
        {
            if(set.contains(nums[i]))
            return nums[i];

            set.add(nums[i]);
        }
        return 0;*/

      // Step 1: Finding the intersection point inside the cycle
        int tortoise = nums[0];
        int hare = nums[0];
        
        while (true) {
            tortoise = nums[tortoise];        // move tortoise by 1 step
            hare = nums[nums[hare]];          // move hare by 2 steps
            if (tortoise == hare) break;      // they meet inside the cycle
        }

        // Step 2: Find the entrance to the cycle (duplicate number)
        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];        // move tortoise by 1 step
            hare = nums[hare];                // move hare by 1 step
        }
        
        return hare;  // Both tortoise and hare are now at the start of the cycle (duplicate number)*/
    }
}
