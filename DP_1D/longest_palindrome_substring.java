class Solution {
    public String longestPalindrome(String s) {
        //dynamic programming approach
        int start = 0 ;
        int end = 0;
        int max_len = 0;

        for(int i=0;i<s.length();i++)
        {
            int len1=expandaroundcenter(s,i,i);
            int len2=expandaroundcenter(s,i,i+1);

            int len = Math.max(len1,len2);

            if(len>max_len)
            {
                max_len=len;
                start=i-((len-1)/2);
                end = i+(len/2);
            }
        }
        return s.substring(start,end+1);
    }

    public int expandaroundcenter(String s, int start, int end)
    {
        while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end))
        {
            start--;
            end++;
        }
        return end-start-1;
    }
}

        
    //brute force aproach ...solve using both but remember you played with indexes here
    //instead of storing whole string proud of you !!
    /*int x = 0;
    int y = 0;

    //Brute force approach
    for(int i=0;i<s.length();i++)
    {
        for(int j=i+1;j<s.length();j++)
        {
            Boolean Value = checkPalindrome(s,i,j);
            if(Value == true && y-x < j-i)
            {
                x=i;
                y=j;
            }

        }
    }
        return s.substring(x,y+1);
    }

    public Boolean checkPalindrome(String s, int i, int j)
    {
        while(i<j)
        {
            if(s.charAt(i)==s.charAt(j))
            {
                i++;
                j--;
            }
            else
            return false;
        }
        return true;
    }
}*/

        
