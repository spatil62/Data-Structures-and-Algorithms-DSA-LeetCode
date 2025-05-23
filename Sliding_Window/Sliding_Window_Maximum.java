class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];  // Store max values for each window
        Deque<Integer> deque = new LinkedList<>();  // Stores indices, not values
        int left = 0;

        for (int i = 0; i < n; i++) {
            // Remove elements out of bounds for the current window
            if (!deque.isEmpty() && deque.peekFirst() < left) {
                deque.pollFirst();
            }

            // Maintain decreasing order: remove smaller elements from the back
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add the current element at the back of deque
            deque.addLast(i);

            // Slide the window when we reach the size k
            if (i >= k - 1) {
                result[left] = nums[deque.peekFirst()];  // The front is the max
                left++;  // Slide the window by moving the left pointer
            }
        }
        return result;
    }
}

        /*// Array to store the maximum values for each window
        int n = nums.length;
        int[] result = new int[n - k + 1];

        // Iterate over the array to find the maximum for each window
        for (int i = 0; i <= n - k; i++) {
            int max = Integer.MIN_VALUE;

            // Iterate within the window to find the maximum
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }

            // Store the maximum in the result array
            result[i] = max;
        }

        return result;
    }
}*/

        //if (nums == null || k <= 0) return new int[0];
        
        /*int n = nums.length;
        int[] output = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>(); // stores indices
        
        int left = 0, right = 0;
        while (right < n) {
            // Remove smaller values from the deque
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[right]) {
                deque.pollLast();
            }
            
            deque.offerLast(right);
            
            // Remove left value from the window if it goes out of bounds
            if (deque.peekFirst() < left) {
                deque.pollFirst();
            }
            
            // Add the maximum to the output once the window size is reached
            if (right + 1 >= k) {
                output[left] = nums[deque.peekFirst()];
                left++;
            }
            
            right++;
        }
        
        return output;
    }
}*/
