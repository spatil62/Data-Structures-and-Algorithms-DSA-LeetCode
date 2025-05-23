class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{')
            st.push(s.charAt(i));
            //The errors you're seeing are because the peek() method of Stack returns an Object type by default.    When you try to compare it directly with a char, Java doesn’t automatically convert the Object to a Character, which is why you're seeing the bad operand types error.
            else if(!st.isEmpty() && st.peek()=='(' && s.charAt(i)==')')
            st.pop();
            else if(!st.isEmpty() && st.peek()=='[' && s.charAt(i)==']')
            st.pop();
            else if(!st.isEmpty() && st.peek()=='{' && s.charAt(i)=='}')
            st.pop();
            else 
            return false;
        }

        if(!st.isEmpty())
        return false;
        else
        return true;       
    }
}

