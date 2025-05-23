class Solution {
    public int maxArea(int[] height) {
        int max_area = 0;

        int start = 0;
        int end = height.length-1;

        while(start<end){
            int area = 1;
            if(height[start]<height[end]){
                area = height[start] * (end-start);
                start++;
            }
            else if(height[start]>height[end]){
                area = height[end] * (end-start);
                end--;
            }
            else if(height[start]==height[end]){
                area = height[start] * (end-start);
                start++;
                end--;
            }

            max_area = Math.max(max_area,area);
        }

        return max_area;
    }
}


