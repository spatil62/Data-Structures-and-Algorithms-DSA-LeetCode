class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // Sort the input array
        Arrays.sort(nums);
        List<List<Integer>> Output = new ArrayList<>();
        backTrack(Output, 0, nums, new ArrayList<>());
        return Output;
    }

    void backTrack(List<List<Integer>> Output, int index, int[] nums, List<Integer> cur)
    {
        Output.add(new ArrayList<>(cur));
        for(int i = index;i<nums.length;i++)
        {
           if (i > index && nums[i] == nums[i - 1])
           continue; // Skip this iteration to avoid duplicates

           cur.add(nums[i]);   
           backTrack(Output, i+1, nums, cur);
           cur.remove(cur.size() - 1);    
        }
    }
    
}
        
        /*// Use a Set to store unique subsets
        Set<List<Integer>> setOfLists = new HashSet<>();
        backTrack(setOfLists, 0, nums, new ArrayList<>());
        
        // Convert the Set to List<List<Integer>>
        return new ArrayList<>(setOfLists);
    }

    void backTrack(Set<List<Integer>> setOfLists, int index, int[] nums, List<Integer> cur) {
        // Add the current subset to the set
        setOfLists.add(new ArrayList<>(cur));

        // Loop through remaining elements starting from 'index'
        for (int i = index; i < nums.length; i++) {
            // Skip duplicates
            if (i > index && nums[i] == nums[i - 1])
                continue; // Skip this iteration to avoid duplicates

            cur.add(nums[i]); // Include nums[i] in the current subset
            backTrack(setOfLists, i + 1, nums, cur); // Recursive call
            cur.remove(cur.size() - 1); // Backtrack: remove the last element added
        }
    }
} */
        /*List<List<Integer>> Output = new ArrayList<>();
        backTrack(Output, 0, nums, new ArrayList<>());
        return Output;
    }

    void backTrack(List<List<Integer>> Output, int index, int[] nums, List<Integer> cur)
    {
    //System.out.println("Current subset (before adding to output): " + cur);
  
        Output.add(new ArrayList<>(cur));
        for(int i = index;i<nums.length;i++)
        {
           cur.add(nums[i]);
            // System.out.println("After adding " + nums[i] + ": " + cur);

             //System.out.println(" i "  + i);         
           backTrack(Output, i+1, nums, cur);


           cur.remove(cur.size() - 1);    
           //System.out.println("After removing " + nums[i] + ": " + cur);       
        }
    }
    
}*/

