class Solution {
    public int reverse(int x) {
      // Define integer limits
        int MIN = Integer.MIN_VALUE; // -2^31
        int MAX = Integer.MAX_VALUE; // 2^31 - 1
        
        int res = 0; // Result variable to store the reversed number
        
        while (x != 0) {
            // Extract the last digit using modulo
            int digit = x % 10;
            
            // Update x to remove the last digit
            x = x / 10;
            
            /*// Check for overflow (positive range)
            if (res > MAX / 10 || (res == MAX / 10 && digit > MAX % 10)) {
                return 0; // Overflow occurred
            }
            
            // Check for underflow (negative range)
            if (res < MIN / 10 || (res == MIN / 10 && digit < MIN % 10)) {
                return 0; // Underflow occurred
            }*/

            if (res > 214748364 || (res == 214748364 && digit > 7)) {
                return 0; // Positive overflow
            }
            
            if (res < -214748364 || (res == -214748364 && digit < -8)) {
                return 0; // Negative underflow
            }   

            
            // Update the result by adding the digit
            res = (res * 10) + digit;
        }
        
        return res; // Return the reversed number
    }
}
