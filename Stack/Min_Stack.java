
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */



 class MinStack {
    Stack<Integer> st;
    Stack<Integer> minSt;

    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }

    public void push(int val) {
        st.push(val);
        // If the min stack is empty or val is smaller than the current minimum, push val onto the min stack
        if (minSt.isEmpty() || val <= minSt.peek()) {
            minSt.push(val);
        } else {
            // Push the current minimum onto the min stack
            minSt.push(minSt.peek());
        }
    }

    public void pop() {
        // Pop the top elements from both stacks
        st.pop();
        minSt.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return minSt.peek();
    }
}
