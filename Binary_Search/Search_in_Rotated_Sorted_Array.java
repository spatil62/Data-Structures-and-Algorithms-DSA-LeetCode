class Solution {
    public int search(int[] nums, int target) {
        //Try with brute force first
        int res = -1;
        int n = nums.length;

        int start = 0;
        int end = nums.length-1;

        while(start<=end){
            int mid = start+((end-start)/2);
            int prev = (mid+n-1)%n;
            int next = (mid+1)%n;

            //dont forget about this test case its very imp
            //I write this code by myself knowledge that i learned from youtube video aditya verma
            //If wanna learn see notes 
            if(nums[start] <= nums[end]) 
            {
            //return nums[start];
            res = BinarySearch(nums, target, 0, start-1);
            if (res != -1) return res;
            res = BinarySearch(nums, target, start, nums.length-1);
            return res;
            }

            if(nums[mid]<nums[prev] && nums[mid]<nums[next])
            {
            //return nums[mid];
            res = BinarySearch(nums, target, 0, mid-1);
            if (res != -1) return res;
            res = BinarySearch(nums, target, mid, nums.length-1);
            return res;
            }
            else if(nums[mid]>=nums[start]){
                start = mid+1;
            }
            else if(nums[mid]<nums[start]){
                end = mid-1;
            }
        }
        return -1;
    }

    public int BinarySearch(int[] nums, int target, int start, int end) {
            while(start<=end)
            {
            int mid = start+((end-start)/2);

            if(nums[mid] == target)
            return mid;
            else if(nums[mid]>target)
            end = mid-1;
            else if(nums[mid]<target)
            start = mid+1;
        }

        return -1;
    }
}
