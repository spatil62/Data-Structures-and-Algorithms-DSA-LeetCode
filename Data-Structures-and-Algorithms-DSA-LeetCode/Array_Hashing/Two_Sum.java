class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*for(int i=0;i<nums.length;i++)
        for(int j=i+1;j<nums.length;j++)
        if(nums[i]+nums[j]==target)
        return new int[]{i,j};

        return new int[]{};*/

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++)
        {
        if(!map.containsKey(target-nums[i]))
        map.put(nums[i], i);
        else
        return new int[]{i,map.get(target-nums[i])};
        }

        return new int[]{};
    }
}
