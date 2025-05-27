public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
     int res = 0;
        for (int i = 0; i < 32; i++) {
            // Get the current bit
            int bit = (n >> i) & 1;
            // Shift the result to the left and add the current bit
            res = (res << 1) | bit;
        }
        return res;
    }
}
