class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
           // Check if the total gas is less than the total cost
        int totalGas = 0, totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if (totalGas < totalCost) {
            return -1; // Not possible to complete the circuit
        }

        // Initialize variables for tracking the current gas and the result
        int total = 0, res = 0;

        // Traverse the gas stations
        for (int i = 0; i < gas.length; i++) {
            total += (gas[i] - cost[i]);
            // If the total becomes negative, reset the starting point
            if (total < 0) {
                total = 0;
                res = i + 1;
            }
        }

        return res; // Return the starting gas station index
    }
}
