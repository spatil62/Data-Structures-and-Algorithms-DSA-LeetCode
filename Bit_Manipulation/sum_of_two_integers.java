class Solution {
    public int getSum(int a, int b) {
        
        while (b != 0) {
            // Compute the sum without carry
            int sum = a ^ b;
            
            // Compute the carry
            int carry = (a & b) << 1;
            
            // Update a and b for the next iteration
            a = sum;
            b = carry;
        }
        return a;
    }
}
