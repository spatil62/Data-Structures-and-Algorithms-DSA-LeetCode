class Solution {

    //Remember one important point is your for loop index decide where exactly your tree is gonna add
    //basically subset example we need diffrent set we decided choose/not choose tree. but it went to right 
    //till the end then backtrack. here we allowed repetation so same index pass for loop it will go 
    //till the left end with same no and come back. 
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>(); // To store the result combinations
        backtrack(result, new ArrayList<>(), candidates, target, 0, 0); // Start backtracking with sum = 0
        return result; // Return all unique combinations
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> cur, int[] candidates, int target, int start, int sum) {
        // If the sum equals the target, add the current combination to the result
        if (sum == target) {
            result.add(new ArrayList<>(cur));
            return; // Return to explore other combinations
        }

        // If the sum exceeds the target, stop exploring this path
        if (sum > target) {
            return;
        }

        // Explore further by choosing each candidate starting from 'start'
        for (int i = start; i < candidates.length; i++) {
            cur.add(candidates[i]); // Choose the current candidate
            // Recur with the updated sum and the same 'i' to allow reusing the same candidate
            backtrack(result, cur, candidates, target, i, sum + candidates[i]);
            cur.remove(cur.size() - 1); // Backtrack by removing the last added candidate
        }
    }
}

/*
So what makes this code different that earlier which makes the tree factor change is its 
repetation allowed parts same number we can use it for number of times so there we decided
we want at every step either add same element again or check that element with every other 
options of that array. Once you recognize “repetition is allowed,” your decision tree needs 
two kinds of branches at each node:

“Take” the current candidate again (so you can reuse it)
“Skip” to the next candidate (to explore other values)

How exactly we will apply this to code ?
So what we will do is while calling recursively we will give same i index to start
so it will keep go till the end of the tree by adding adding adding and check. once 
its done it will back track and while backtracking we will keep removing element and
keep adding next elements to it.

            "backtrack(cand, target - cand[i], i, path, ans);"




How to know which tree we can solve ?

Step 1: What kind of result do I want?
Ask: Am I building...

Desired Output	                             Example	                      What kind of logic/tree?
All subsets (no condition)	          [1, 2] → [[], [1], [2], [1,2]]	     Binary tree (include/exclude)
All combinations summing to target	  candidates = [2,3], target = 5	     For loop + reuse logic
All permutations (order matters)	  [1,2,3] → [1,2,3], [2,1,3], ...	     For loop + visited[] or swap
Palindromic partitions	              "aab" → ["a","a","b"], ["aa","b"]	     Try all cuts from i to end

                                []
           ___________|___________|___________|___________
          /            |           |           |         
        [2]           [3]         [6]         [7]✅        
     ___|___       ___|___        |           (done)      
    /       \     /       \       |                     
  [2,2]    [2,3]  [3,3]   [3,6](-1)❌               
  /   \      \      |                          
[2,2,2]  [2,2,3] [3,3,3] (stop)                 
 /   \        \     |                           
[2,2,2,2] [2,2,2,3] (stop)                     
  ❌         ❌                            



*/





