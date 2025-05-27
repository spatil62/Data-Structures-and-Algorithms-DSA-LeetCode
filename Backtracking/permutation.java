class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result) {
        // If the current permutation has all elements, add it to the result
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            // Skip already used numbers
            if (current.contains(nums[i])) {
                continue;
            }
            current.add(nums[i]); // Choose the number
            backtrack(nums, current, result); // Explore further
            current.remove(current.size() - 1); // Undo the choice (backtrack)
        }
    }
}


/*
                                        []
                        _______________/|\_________________
                       /                |                  \
                    [1]               [2]                 [3]
                 ___/ \___          ___/ \___          ___/ \___
                /         \        /         \        /         \
           [1,2]       [1,3]   [2,1]      [2,3]   [3,1]      [3,2]
             |           |       |           |       |           |
         [1,2,3]     [1,3,2]  [2,1,3]    [2,3,1]  [3,1,2]    [3,2,1]


Each path from top to bottom represents a full permutation:

[] → [1] → [1,2] → [1,2,3]
[] → [1] → [1,3] → [1,3,2]
[] → [2] → [2,1] → [2,1,3]
[] → [2] → [2,3] → [2,3,1]
[] → [3] → [3,1] → [3,1,2]
[] → [3] → [3,2] → [3,2,1]
*/
