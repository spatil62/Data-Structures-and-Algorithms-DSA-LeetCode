class Solution {
    public boolean canPartition(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        int sum = 0, Target = 0;

        for(int num : nums)
        sum = sum + num;

        if (sum % 2 != 0)
            return false;
        
        Target = sum / 2;

        set.add(0);

        for(int i=nums.length-1;i>=0;i--)
        {
            HashSet<Integer> nextDP = new HashSet<>();
            for(int set_value:set)
            {
                nextDP.add(set_value);
                nextDP.add(set_value+nums[i]);
            }
            set = nextDP; 
        }
        return set.contains(Target);
    }
}

