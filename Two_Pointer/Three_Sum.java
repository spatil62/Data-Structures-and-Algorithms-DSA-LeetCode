class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1])
            continue;

            int start = i+1;
            int end = nums.length-1;

            while(start<end){
                int sum = nums[start]+nums[end]+nums[i];
                if(sum == 0){
                    list.add(new ArrayList<>(Arrays.asList(nums[start],nums[end],nums[i])));

                    // Skip duplicates
                    while (start < end && nums[start] == nums[start + 1]) 
                    start++;
                    
                    while (start < end && nums[end] == nums[end - 1]) 
                    end--;

                    start++;
                    end--;
                }
                else if(sum>0){
                    end--;
                }
                else if(sum<0){
                    start++;
                }
            }
        }

        return list;
    }
}
