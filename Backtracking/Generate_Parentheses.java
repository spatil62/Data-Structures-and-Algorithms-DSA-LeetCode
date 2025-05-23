class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }
    
    private void backtrack(List<String> result, String current, int open, int close, int n) {
        // If the current string length is 2*n, add it to the result
        if (current.length() == n * 2) {
            result.add(current);
            return;
        }
        
        // Add an open parenthesis if we haven't reached the limit
        if (open < n) {
            backtrack(result, current + "(", open + 1, close, n);
        }
        
        // Add a close parenthesis if it can form a valid pair
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, n);
        }
    }
}



        /*List<String> result = new ArrayList<>();
        Queue<Object[]> queue = new LinkedList<>();
        
        // Add initial state: empty string, 0 open, 0 close
        queue.add(new Object[]{"", 0, 0});
        
        while (!queue.isEmpty()) {
            Object[] state = queue.poll();
            String current = (String) state[0];
            int open = (int) state[1];
            int close = (int) state[2];
            
            // If the current string is complete, add it to the result
            if (current.length() == n * 2) {
                result.add(current);
                continue;
            }
            
            // Add an open parenthesis if possible
            if (open < n) {
                queue.add(new Object[]{current + "(", open + 1, close});
            }
            
            // Add a close parenthesis if it can form a valid pair
            if (close < open) {
                queue.add(new Object[]{current + ")", open, close + 1});
            }
        }
        
        return result;
    }
}*/

