class Solution {
    //We need to apply same logic that we learned in last two examples 
    //just make sure here we have duplicates in input array and we dont want
    //duplicate sets so we manage to sort and give this limitation 
    //condition in our for loop ok ? 
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> Output = new ArrayList<>();
        Backtrack(candidates, target, Output, 0, new ArrayList<Integer>(), 0);
        return Output;
    }

    public void Backtrack(int[] candidates, int target, List<List<Integer>> Output, int index, ArrayList<Integer> curr, int sum){
        if(sum>target)
        return;

        if(sum==target){
            Output.add(new ArrayList<>(curr));
            return;
        }

        for(int i=index;i<candidates.length;i++){
            if (i > index && candidates[i] == candidates[i - 1]) 
            continue;

            curr.add(candidates[i]);
            Backtrack(candidates, target, Output, i+1, curr, sum+candidates[i]);   
            curr.remove(curr.size()-1);         
        }
    }
}

/*
Backtracking is really just a way of systematically exploring all the choices you could make at each step—and pruning when a choice can never lead to a valid answer. There are two flavors of “explore all choices” you’ve seen here:

1. Subset‐style (combinationSum2): At each element you decide include or exclude it, then move on to the next index (i+1).
2. Unlimited‐reuse style (combinationSum):At each element you decide include it (and stay at the same index i) or skip it (move to i+1).

How to “see” which pattern to use ?
1. Read the problem statement for repetition
If each candidate can only be used once, you must advance the index after you include it (i+1), so you don’t reuse that slot.
If you may use the same candidate unlimited times, you recurse on i again so that choice remains on the table.

2. Translate that into a tree
CombinationSum2 (no reuse)
Node = “current sum & chosen list so far”
Edges =
Include nums[i], recurse with i+1
Skip nums[i], recurse with i+1

CombinationSum (reuse allowed)
Node = same
Edges =
Include nums[i], recurse with i (so you can pick it again)
Skip nums[i], recurse with i+1

3. Look at your loop index
In Java backtracking we encode “where to move next” by passing the loop start index into the recursive call.
// no reuse → next call starts at i+1
backtrack(..., i+1, sum + candidates[i]);

// reuse allowed → next call starts at i
backtrack(..., i, sum + candidates[i]);




Your intuition vs. the include/skip tree
You were thinking “I’ll just keep adding until the end, checking sums as I go.” That’s fine, but behind the scenes you’re still making two decisions at each element:

Take it
Don’t take it
The only difference between the two problems is how you move your “pointer” after you decide to take it:

Problem	                          After “include” move to…	   After “skip” move to…
Subsets / CombinationSum2	         i + 1	                    i + 1
CombinationSum (reuse allowed)	      i	                        i + 1
That small change in the recursive call index is what changes the shape of your tree, from “binary no‐reuse” to “mixed reuse/no‐reuse.”



Start: []
  include 1 -> [1]
    include 1 -> [1,1]
      include 2 -> [1,1,2]
        include 5 -> [1,1,2,5]  fail (sum=9 > 8)
        skip 5 -> [1,1,2]
          include 6 -> [1,1,2,6]  fail (sum=10 > 8)
          skip 6 -> [1,1,2]
            include 7 -> [1,1,2,7]  fail (sum=11 > 8)
            skip 7 -> [1,1,2]  (backtrack)
      skip 2 -> [1,1]
        include 5 -> [1,1,5]  fail (sum=7 < 8, but no further candidates)
        skip 5 -> [1,1]
          include 6 -> [1,1,6]  success (sum=8) ✅
          skip 6 -> [1,1]
            include 7 -> [1,1,7]  fail (sum=9 > 8)
            skip 7 -> [1,1] (backtrack)
    skip 1 -> [1]
      include 2 -> [1,2]
        include 5 -> [1,2,5]  success (sum=8) ✅
        skip 5 -> [1,2]
          include 6 -> [1,2,6]  fail (sum=9 > 8)
          skip 6 -> [1,2]
            include 7 -> [1,2,7]  fail (sum=10 > 8)
            skip 7 -> [1,2] (backtrack)
      skip 2 -> [1]
        include 5 -> [1,5]  fail (sum=6 < 8, no further candidates)
        skip 5 -> [1]
          include 6 -> [1,6]  fail (sum=7 < 8, no further candidates)
          skip 6 -> [1]
            include 7 -> [1,7]  success (sum=8) ✅
            skip 7 -> [1] (backtrack)
  skip 1 -> []
    include 2 -> [2]
      include 5 -> [2,5]  fail (sum=7 < 8, no further candidates)
      skip 5 -> [2]
        include 6 -> [2,6]  success (sum=8) ✅
        skip 6 -> [2]
          include 7 -> [2,7]  fail (sum=9 > 8)
          skip 7 -> [2] (backtrack)
    skip 2 -> []
      include 5 -> [5]  fail (sum=5 < 8, no further candidates)
      skip 5 -> []
        include 6 -> [6]  fail (sum=6 < 8, no further candidates)
        skip 6 -> []
          include 7 -> [7]  fail (sum=7 < 8, no further candidates)
          skip 7 -> []
            include 10 -> [10] fail (sum=10 > 8)
            skip 10 -> [] (end)

*/
