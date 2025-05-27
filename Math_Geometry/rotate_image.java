class Solution {
    public void rotate(int[][] matrix) {
        
    int left = 0, right = matrix.length - 1;

        while (left < right) {
            for (int i = 0; i < right - left; i++) {
                int top = left, bottom = right;

                // Save the top-left value
                int topLeft = matrix[top][left + i];

                // Move bottom-left into top-left
                matrix[top][left + i] = matrix[bottom - i][left];

                // Move bottom-right into bottom-left
                matrix[bottom - i][left] = matrix[bottom][right - i];

                // Move top-right into bottom-right
                matrix[bottom][right - i] = matrix[top + i][right];

                // Move top-left into top-right
                matrix[top + i][right] = topLeft;
            }
            left++;
            right--;
        }
    }
}









        /*int left = 0, right = matrix.length - 1;

        // Loop until left pointer crosses the right pointer
        while (left < right) {
            for (int i = 0; i < right - left; i++) {
                int top = left, bottom = right;

                // Save the top-left value
                int topLeft = matrix[top][left + i];

                // Move bottom-left into top-left
                matrix[top][left + i] = matrix[bottom - i][left];

                // Move bottom-right into bottom-left
                matrix[bottom - i][left] = matrix[bottom][right - i];

                // Move top-right into bottom-right
                matrix[bottom][right - i] = matrix[top + i][right];

                // Move top-left into top-right
                matrix[top + i][right] = topLeft;
            }
            // Narrow the layer
            left++;
            right--;
        }
    }
}*/

