class Solution {
    public double myPow(double x, int n) {
        /*// Handle edge case: x^0 = 1
        if (n == 0) return 1;

        // Handle negative powers
        long N = n; // Convert n to long to handle overflow (e.g., n = Integer.MIN_VALUE)
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1.0;
        for (long i = 0; i < N; i++) {
            result *= x; // Multiply by x in each iteration
        }

        return result;*/

        // Handle edge case: x^0 = 1
        if (n == 0) return 1;

        // Handle negative powers
        long N = n; // Convert n to long to avoid overflow
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1.0;
        while (N > 0) {
            if (N % 2 == 1) { // If N is odd, multiply the result by x
                result *= x;
            }
            x *= x; // Square x
            N /= 2; // Halve the exponent
        }

        return result;
    }
}

