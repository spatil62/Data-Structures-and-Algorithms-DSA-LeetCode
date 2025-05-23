class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0; // Variable to store the maximum area
        Stack<int[]> stack = new Stack<>(); // Stack to store pairs of (index, height)

        for (int i = 0; i < heights.length; i++) {
            int start = i; // The start index for the current height

            // If the current height is smaller than the height of the bar at the top of the stack,
            // pop from the stack and calculate the area
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] pair = stack.pop();
                int index = pair[0]; // Start index of the popped bar
                int height = pair[1]; // Height of the popped bar
                maxArea = Math.max(maxArea, height * (i - index)); // Calculate area
                start = index; // Update the start index for the current height
            }

            // Push the current index and height as a pair into the stack
            stack.push(new int[]{start, heights[i]});
        }

        // Process the remaining elements in the stack
        for (int[] pair : stack) {
            int index = pair[0];
            int height = pair[1];
            maxArea = Math.max(maxArea, height * (heights.length - index));
        }

        return maxArea;
    }
}
