class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        /*for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==target)
                return true;
            }
        }
        return false;*/

        //how to solve this do one thing whenever there is word sorted and its array
        //we have to use binary serach and instead of 2D matrix consider it as 1D
        //think what you would have done and follow. You will get stuck how i will 
        //fetch value from matrix about row and col. pretty easy what you have to
        //do is m is row and n is col so if i need mid value egxample its 11 
        //then how i will get row and col. imagine this matrix col ends at 4 so 
        //we need to divide mid/4 for row and if this would have straight array 
        //its index is 10, 11, 12 right so its just 1 difference that reminder so 
        //we need to use mid%n to find col 
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m*n-1;

        while(start<=end){
            int mid = start+((end-start)/2);
            int val = matrix[mid/n][mid%n];

            if(val==target)
            return true;
            else if(val>target){
                end = mid-1;
            }
            else if(val<target){
                start = mid+1;
            }
        }
        return false;
    }
}
