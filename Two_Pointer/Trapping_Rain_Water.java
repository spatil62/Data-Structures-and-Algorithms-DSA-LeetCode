class Solution {
    public int trap(int[] height) {

        //do follow logic from strivers list take you forward its easy and this way 
        //logic using extra space 
        //basically we need at every points whats left
        //and right max and min bcoz offcouse min of that we can store but depends 
        //is there any bar standing or not
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] min = new int[n];
        int[] result = new int[n];

        //from left
        //left[0]=0;
        int leftMax = 0;
        for(int i=0;i<n;i++)
        {
            left[i] = leftMax;
            if(height[i]>leftMax)
            leftMax = height[i];
        }

        //so from right dont forget
        //from right
        //right[n-1]=0;
        int rightMax = 0;
        for(int i=n-1;i>=0;i--)
        {
            right[i] = rightMax;
            if(height[i]>rightMax)
            rightMax = height[i];
        }

        //min of both 
        for(int i=0;i<n;i++)
        min[i]=Math.min(left[i],right[i]);

        //now offcourse check is there any bar so that how much
        //water we can store 
        for(int i=0;i<n;i++)
        if(min[i]-height[i]>0)
        result[i]=min[i]-height[i];
        else
        result[i]=0;

        //Total Sum
        int sum=0;
        for(int i=0;i<n;i++)
        sum=sum+result[i];

        return sum;





        /*if (height == null || height.length == 0) {
            return 0;
        }
        
        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];
        int res = 0;
        
        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                res += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                res += rightMax - height[right];
            }
        }
        
        return res;*/
    }
}
