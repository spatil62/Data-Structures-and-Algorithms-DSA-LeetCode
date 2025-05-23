class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder st = new StringBuilder();

        for(int i=0;i<s.length();i++)
        if((s.charAt(i)>='a' && s.charAt(i)<='z') || (s.charAt(i)>='A' && s.charAt(i)<='Z') || (s.charAt(i)>='0' && s.charAt(i)<='9'))
        st.append(s.charAt(i));

        s = st.toString();

        int start = 0;
        int end = s.length()-1;

        while(start<end){
            if(Character.toLowerCase(s.charAt(start))!=Character.toLowerCase(s.charAt(end)))
            return false;
            else
            {
                start++;
                end--;
            }
        }

        return true;
    }
}

/*
class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder st = new StringBuilder();

        for(int i=0;i<s.length();i++)
        {
            if((s.charAt(i)>='A' && s.charAt(i)<='Z') || 
            (s.charAt(i)>='a' && s.charAt(i)<='z') ||
            (s.charAt(i)>='0' && s.charAt(i)<='9'))
            {
            st.append(s.charAt(i));
            }
        }

        String original = st.toString();
        String reversed = st.reverse().toString();
 
        if(original.compareToIgnoreCase(reversed)==0)
        return true;
        else
        return false;
    }
}
*/
