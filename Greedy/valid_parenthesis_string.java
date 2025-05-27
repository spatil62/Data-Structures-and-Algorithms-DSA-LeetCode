class Solution {
    public boolean checkValidString(String s) {

        int leftmax = 0;
        int leftmin = 0;

        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                leftmax++;
                leftmin++;
            }
            else if(s.charAt(i)==')')
            {
                leftmax--;
                leftmin--;
            }
            else if(s.charAt(i)=='*')
            {
                leftmax++;
                leftmin--;
            }

            if(leftmin<0)
            leftmin=0;

            if(leftmax<0)
            return false;
        }
        
        return leftmin==0;
    }
}
