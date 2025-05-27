class Solution {
    public int singleNumber(int[] nums) {
        //java allows to store bitwise operation in int format by again converting to int 
        //once its done with operation 
        int result = 0;

        for (int num : nums) 
            result = result ^ num; // XOR each number

        return result;
        
    }
}
