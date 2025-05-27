class Solution {
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int sum = 0;

        for(int i=0;i<nums.length;i++)
        {
               if(sum<0)
               sum=0;
            
                sum=sum+nums[i];
                max = Math.max(max, sum);
        }
        return max;



        

        /*int max_sum = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++)
        {
            int sum = 0;
            for(int j=i;j<nums.length;j++)
            {
                sum +=nums[j];
                max_sum = Math.max(max_sum,sum);
            }
        }
        return max_sum;*/

    }
}
