class Solution {
    public int[] productExceptSelf(int[] nums) {
        //brute force
        /*int[] res = new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            int prod = 1;
            for(int j=0;j<nums.length;j++)
            {
                if(i!=j)
                prod *= nums[j];
            }
            res[i]=prod;
        }
        return res;
    }
}*/

        int n = nums.length;

        int[] pre = new int[n];  // Prefix product array
        int[] post = new int[n]; // Postfix product array
        int[] res = new int[n];  // Result array

        // Step 1: Compute prefix products
        pre[0] = 1;
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
            //System.out.println("    pre[i] : " + pre[i]);
        }

        // Step 2: Compute postfix products
        post[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            post[i] = post[i + 1] * nums[i + 1];
            //System.out.println("    post[i] : " + post[i]);
        }

        // Step 3: Compute result by multiplying prefix and postfix
        for (int i = 0; i < n; i++) {
            res[i] = pre[i] * post[i];
            //System.out.println("    res[i] : " + res[i]);
        }

        return res;
    }
}
        /*int n=nums.length;
        int[] result = new int[n];
        
        //find out prefix
        int prefix = 1;
        for(int i=0;i<n;i++)
        {
         result[i]=prefix;
         prefix=prefix*nums[i];
         System.out.println(" res[i] pre  : " + result[i]);
        }

        //find postfix
        int postfix=1;
        for(int i=n-1;i>=0;i--)
        {
         result[i]=postfix*result[i];
         postfix=postfix*nums[i];
         System.out.println(" res[i] post : " + result[i]);
        }

        return result;
    }
}*/

    

