class Solution {
    public int evalRPN(String[] tokens) {
       Stack<Integer> st = new Stack<>();
        
        for (String token : tokens) {
            if (token.equals("+")) {
                int b = st.pop();
                int a = st.pop();
                st.push(a + b);
            } else if (token.equals("-")) {
                int b = st.pop();
                int a = st.pop();
                st.push(a - b);
            } else if (token.equals("*")) {
                int b = st.pop();
                int a = st.pop();
                st.push(a * b);
            } else if (token.equals("/")) {
                int b = st.pop();
                int a = st.pop();
                // Perform integer division that truncates toward zero
                st.push(a / b);
            } else {
                // If it's a number, push it to the stack
                st.push(Integer.parseInt(token));
            }
        }
        
        // The final result is the only element left in the stack
        return st.pop();
    }
}
