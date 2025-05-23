class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] arr = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;

        // Merge the arrays
        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) {
                arr[k++] = nums1[i++];
            } else {
                arr[k++] = nums2[j++];
            }
        }

        while (i < n1) {
            arr[k++] = nums1[i++];
        }

        while (j < n2) {  // Fixed this line
            arr[k++] = nums2[j++];
        }

        // Find the median
        int len = arr.length;
        if (len % 2 == 0) {
            return (arr[len / 2 - 1] + arr[len / 2]) / 2.0;  // Median for even length
        } else {
            return arr[len / 2];  // Median for odd length
        }
    }
}

