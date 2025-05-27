class Solution {

    int count = 0 ;
    public int countSubstrings(String s) {
        
        for(int i=0;i<s.length();i++)
        {
            expandaroundcenter(s,i,i);
            expandaroundcenter(s,i,i+1);
        }
        return count;
    }

    public void expandaroundcenter(String s, int start, int end)
    {
        while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end))
        {
            count++;
            start--;
            end++;
        }
    }
}

