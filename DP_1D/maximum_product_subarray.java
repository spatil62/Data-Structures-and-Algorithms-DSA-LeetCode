class Solution {
    public int maxProduct(int[] nums) {
        /*Why Swap max_prod and min_prod?

        When you encounter a negative number (nums[i] < 0), multiplying it with the 
        current max_prod or min_prod has the following effects:

        Multiplying with max_prod:
        If max_prod is positive, multiplying it with a negative number (nums[i]) 
        will make the product negative.
        This negative product could now become the new min_prod 
        (smallest product so far).
        
        Multiplying with min_prod:
        If min_prod is negative, multiplying it with a negative number (nums[i]) 
        will make the product positive.
        This positive product could now become the new max_prod 
        (largest product so far).By swapping max_prod and min_prod when nums[i] 
        is negative, you ensure that:

        The new max_prod is calculated using the previous min_prod 
        (which could turn into a large positive product).
        The new min_prod is calculated using the previous max_prod 
        (which could turn into a small negative product).
        This way, you’re always prepared to handle the case where two 
        negatives multiply to form a positive, which could be the new maximum product.*/  



        /*
        Why Not Just Use the Multiplied Value?

        If we only used the multiplied value (nums[i] * max_prod or nums[i] * min_prod), 
        we would miss two important cases:

        Starting Fresh:
        If the current number (nums[i]) is better than the product so far, 
        we should start fresh. For example:
        If nums[i] = 5 and max_prod = 0, then 5 is better than 0 * 5 = 0.
        If nums[i] = -2 and min_prod = 3, then -2 is better than 3 * -2 = -6.

        Handling Zeros:
        If nums[i] = 0, the product resets to 0. Without Math.max and Math.min, 
        we might incorrectly carry forward a non-zero product.
        By using Math.max and Math.min, we ensure that we’re always choosing the 
        best option at each step.*/ 

        //we are getting maxprod through result at every index so we will get max till end
        int max_prod = nums[0];
        int min_prod = nums[0];
        int result = nums[0];

        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]<0)
            {
                int temp=max_prod;
                max_prod=min_prod;
                min_prod=temp;     
            }
            max_prod = Math.max(nums[i],nums[i]*max_prod);
            min_prod = Math.min(nums[i],nums[i]*min_prod);
            result = Math.max(result,max_prod);
        }
        return result;

       /*int max_product = Integer.MIN_VALUE; // Start with the first element as the max product.

        // Iterate over all starting points of subarrays
        for (int i = 0; i < nums.length; i++) {
            int product = 1; // Initialize product for each starting point
            // Compute product for subarrays starting at index `i`
            for (int j = i; j < nums.length; j++) {
                product *= nums[j]; // Multiply elements in the subarray
                max_product = Math.max(max_product, product); // Update the max product
            }
        }
        return max_product;*/
    }
}
