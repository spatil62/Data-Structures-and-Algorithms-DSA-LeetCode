class Solution {
    public boolean containsDuplicate(int[] nums) {
        /*
        Brute force 
        for(int i=0;i<nums.length;i++)
        for(int j=i+1;j<nums.length;j++)
        if(nums[i]==nums[j])
        return true;

        return false;*/

        HashSet<Integer> set = new HashSet<>();

        for(int num : nums)
        if(set.contains(num))
        return true;
        else
        set.add(num);

        return false;
    }
}
