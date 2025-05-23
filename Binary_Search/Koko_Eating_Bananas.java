class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //This logic created by me what i do is to check hours make sure outer loop
        //runs from 1 to max so over there we used binary search and then 
        //for inner loop what we did was we been through everything and checked 
        //where exact hours we used 

        // Find the maximum pile to set the upper bound for k
        int maxPile = 0;
        for (int pile : piles) {
            maxPile = Math.max(maxPile, pile);
        }

        // Binary search over possible speeds k
        int left = 1, right = maxPile;

        // Binary search loop: continue until left pointer is less than or equal to right pointer
        while (left <= right) {
            int mid = left + (right - left) / 2;  // Find the middle point
            
            // Calculate the total number of hours needed to eat all piles at speed mid
            int remainingHours = h;  // Set the total hours available for eating
            for (int pile : piles) {
                // Calculate the hours needed to eat the pile at speed k
                //remember these two last time you were looking for substraction and went wrong 
                int hoursForPile = pile / mid;
                
                // If there are leftover bananas, we need an extra hour
                if (pile % mid != 0) {
                    hoursForPile++;
                }
                
                remainingHours -= hoursForPile;  // Reduce the remaining hours for the pile

                // If at any point, we run out of hours, break early (no need to check further)
                if (remainingHours < 0) {
                    break;
                }
            }

            // If remainingHours is non-negative, try to reduce the speed (right pointer)
            if (remainingHours >= 0) 
                right = mid - 1;
            else 
                left = mid + 1;
        }

        // The answer will be at the left pointer after the binary search loop ends
        return left;
    }
}

