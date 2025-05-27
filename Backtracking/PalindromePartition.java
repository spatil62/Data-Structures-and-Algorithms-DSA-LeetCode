class Solution {
    //I follow strivers logic for this its just pretty and straight forward 
    public List<List<String>> partition(String s) {
        List<List<String>> Output = new ArrayList<>();
        partitionCheck(s,0,Output,new ArrayList<>());
        return Output;
    }

    void partitionCheck(String s, int index, List<List<String>> Output, List<String> cur)
    {
        if (index == s.length()) {
            Output.add(new ArrayList <> (cur));
            //System.out.println(" cur while adding : " + cur);
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (palindrome(s, index, i)) {
                cur.add(s.substring(index, i + 1));
               // System.out.println(" cur before recurssive call : " + cur);
                partitionCheck(s, i + 1, Output, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }

    boolean palindrome(String s, int start, int end)
    {
        while(start<=end)
        {
         if(s.charAt(start)==s.charAt(end))
         {
          start++;
          end--;
         }
         else 
         return false;
        }
        return true;
        /*
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;*/
    }
}


/*
                                                    [aabb]
                     ______________________________/ \____________________________________
                   /                                                                       \
                ["a"]                                                                      ["aa"]
__________________|__________________                                            ____________|____________
/                                 \                                          /                           \
["a","a"]                    ["a","a","bb"]                           ["aa","b"]                     ["aa","bb"]
 /              \                       (leaf)                               |
["a","a","b"]    (leaf)                                                  ["aa","b","b"]
                                                                            (leaf)
      |
    ["a","a","b","b"]  
     (leaf)

[] → ["a"] → ["a","a"] → ["a","a","b"] → ["a","a","b","b"]
[] → ["a"] → ["a","a"] → ["a","a","bb"]
[] → ["aa"] → ["aa","b"] → ["aa","b","b"]
[] → ["aa"] → ["aa","bb"]
*/

/*o write backtracking logic, the key is:
Visualizing the recursive tree — how your choices branch out — is exactly how you build the solution.

🌲 There are generally two main patterns of backtracking recursion trees:

1. Decision Tree: Include or Exclude (Binary Choice Tree)
This is usually used in combinatorial problems like subsets, knapsack, or "pick/don't pick" decisions.
🔹 Example: Subsets of [1, 2]

        []
       /  \
     [1]  []
     /      \
 [1,2]    [2]
You make binary decisions at each step:

Include nums[i]
Or skip nums[i]

2. For-Loop Based Tree (Permutation/Partition Style)
You loop through options and choose one at a time.
Used when order matters, or multiple picks are allowed.
Examples: permutations, palindrome partitioning, N-queens, sudoku, etc.
🔹 Example: Permutations of [1,2,3]

[]
 ├── [1]
 │    ├── [1,2]
 │    │    └── [1,2,3]
 │    └── [1,3]
 │         └── [1,3,2]
 ├── [2]
 │    └── ...
 └── [3]
      └── ...
Each level of the tree is built by:

Looping over all options that haven’t been picked yet.

🧠 So how do you decide which tree pattern to use?

Problem Type	             Tree Type	          Structure
Subset, Knapsack	        Include/Exclude	      Two branches at each step
Permutations, Partitions	Loop-based	          For-loop at each level with pruning
Combinations (k elements)	Loop-based	          For-loop + control index (to avoid repeat)
Sudoku, N-Queens	        Loop-based	          Try each valid option at each cell/row

✅ So yes, the tree defines the logic.

Once you understand what each level in your tree represents,
And how branches form (choices),
Backtracking becomes systematic, not guesswork.

IMP:
Exactly! You nailed it.

The for loop combined with how you change the index (or start) parameter is the main factor that shapes the structure and behavior of the recursion tree.

To summarize simply:
How you update the index in recursive calls decides the tree type and logic:
Index Update in Recursive Call	               Behavior / Tree Type	               Example
i + 1 (move forward)	                       No repetitions, mimics              subsets() — choosing/not 
                                               include/exclude decisions           choosing elements once
                                               (subset style)	                   
                                                   
i (same index)	                                Allow repetitions, exploring        combinationSum() — reuse 
                                                partitions/combinations with 
                                                repeats	

*/
