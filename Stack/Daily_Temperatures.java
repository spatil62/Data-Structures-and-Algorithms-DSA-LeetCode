class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        /*int n = temperatures.length;
        int[] result = new int[n];
        
        for(int i=0;i<n;i++)
        {
            int sum = 1;
            for(int j=i+1;j<n;j++)
            {
                if(temperatures[j]>temperatures[i])
                {         
                result[i] = sum; 
                break;
                }
                sum++;
            }
        }

        return result;
    }
}*/

        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>(); // Stack to store indices
        
        for (int i = n - 1; i >= 0; i--) {
            // Maintain a decreasing stack
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }
            
            // If stack is not empty, calculate the number of days
            if (!stack.isEmpty()) {
                answer[i] = stack.peek() - i;
            }
            
            // Push the current index onto the stack
            stack.push(i);
        }
        
        return answer;
    }
}





