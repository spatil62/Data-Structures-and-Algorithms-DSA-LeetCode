class Solution {
    public int[] countBits(int n) {
        int count = 0;
        int[] count_store = new int[n+1];

        for(int i=0;i<=n;i++)
        {
            int m=i;
            while(m!=0)
            {
                if((m&1)==1)
                {
                    count++;
                }
                m=m>>1;
            }
            count_store[i]=count;
            count=0;
        }
        return count_store;
    }
}


/*
// Array to store the number of 1's in the binary representation of each number
        int[] dp = new int[n + 1];
        
        // Initial offset
        int offset = 1;
        
        // Iterate over the range [1, n]
        for (int i = 1; i <= n; i++) {
            // Chec`k if we need to update the offset
            if (offset * 2 == i) {
                offset = i;
            }
            
            // Calculate the number of 1's in the binary representation
            dp[i] = 1 + dp[i - offset];
        }
        
        // Return the result array
        return dp;
    }
}*/
