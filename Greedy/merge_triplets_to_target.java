class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
      // Set to keep track of the indices that match the target
        Set<Integer> good = new HashSet<>();

        for (int[] t : triplets) {
            // Skip triplets that exceed the target values
            if (t[0] > target[0] || t[1] > target[1] || t[2] > target[2]) {
                continue;
            }

            // Check which values match the target and add the index to the set
            for (int i = 0; i < t.length; i++) {
                if (t[i] == target[i]) {
                    good.add(i);
                }
            }
        }

        // Return true if all three indices (0, 1, 2) are in the set
        return good.size() == 3;
    }
}
