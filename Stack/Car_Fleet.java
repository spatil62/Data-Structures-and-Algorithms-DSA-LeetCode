class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
   // Create a list of pairs (position, speed)
        int n = position.length;
        double[][] pair = new double[n][2];
        
        for (int i = 0; i < n; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        
        // Sort the pairs in descending order based on positions
        Arrays.sort(pair, (a, b) -> Double.compare(b[0], a[0]));
        
        // Use a stack to store the times to reach the target
        Stack<Double> stack = new Stack<>();
        
        // Traverse the sorted pairs
        for (int i = 0; i < n; i++) {
            double time = (target - pair[i][0]) / pair[i][1];
            //System.out.println("time : " + time);
           // System.out.println("pair[i][0] : " + pair[i][0]);
            
            // If the stack is not empty and the top of the stack is greater than the current time,
            // it means the current car will catch up to the car in front
            if (!stack.isEmpty() && stack.peek() >= time) {
                continue; // Current car will join the fleet in front
            }
            
            stack.push(time);
            //System.out.println("stack : " + stack.peek());
            //System.out.println(" ");
        }
        
        // The number of fleets will be the number of times in the stack
        return stack.size();
    }
}


