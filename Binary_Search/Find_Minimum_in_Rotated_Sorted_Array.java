class Solution {
    public int findMin(int[] nums) {
        //try with brute force first 
        //for this I have new notes and completely followed aditya verma
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            // If the array is already sorted
            if (nums[start] <= nums[end]) {
                return nums[start];
            }

            int mid = start + (end - start) / 2;
            int next = (mid + 1) % nums.length;
            int prev = (mid + nums.length - 1) % nums.length;

            // Check if mid is the minimum
            if (nums[mid] < nums[prev] && nums[mid] < nums[next]) {
                return nums[mid];
            }

            // Decide which half to choose
            if (nums[start] <= nums[mid]) {
                // Left part is sorted, go right
                start = mid + 1;
            } else if(nums[start] >= nums[mid]){
                // Right part is sorted, go left
                end = mid - 1;
            }
        }

        return -1; // Should not reach here if input is valid
    }
}


/*class Solution {
    public int findMin(int[] nums) {
        int res = nums[0];
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            if (nums[left] < nums[right]) {
                res = Math.min(res, nums[left]);
                break;
            }

            int mid = left + (right - left) / 2;
            res = Math.min(res, nums[mid]);

            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return res;
    }
}*/

/*class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // If the array is not rotated (sorted in ascending order), the first element is the minimum
        if (nums[left] < nums[right]) {
            return nums[left];
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If the mid element is greater than the element at right, the minimum is in the right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } 
            // If the mid element is less than or equal to the element at right, the minimum is in the left half (including mid)
            else {
                right = mid;
            }
        }

        // At the end of the loop, left == right and pointing to the smallest element
        return nums[left];
    }
}
*/
