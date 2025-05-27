class Solution {
    //refer adity verma notes ok
    //remember pattern
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> Output = new ArrayList<>();
        backTrack(Output, 0, nums, new ArrayList<>());
        return Output;
    }

    void backTrack(List<List<Integer>> Output, int index, int[] nums, List<Integer> cur)
    { 
        //before adding we dont need to give limitation bcoz we want all 
        //the Subsets so directly add
        Output.add(new ArrayList<>(cur));

        //we need to start loop from i only bcoz there is no repetative elements 
        //so that we can start from i and go till end of the string as adity verma 
        //we also not require to give limit block any further process bcoz 
        //there is no repetative elements in array as per ques 
        for(int i = index;i<nums.length;i++)
        {
           cur.add(nums[i]);
           //i+1 you know why we used bcoz we need combinations from
           //next of that point till the end as we saw in example of adity verma 
           //permutation of string
           backTrack(Output, i+1, nums, cur);
           //aditya verma video says it all 
           //consider it as a tree so as we need earlier
           //bcoz we did swap by reference we changed core 
           //value and need to set back this core value
           //so it will be like this and then tree will move 
           //forward with that value 
           //consider mapping tree then easy to undestand and 
           //remember as per vermas video
           cur.remove(cur.size() - 1);        
        }
    }  
}

/* VIMP notes
Explanation : Each for loop we have two option either add it or not
look at this example first step thats why we have nothing add in 
then loop first element add 1 then dont add 1 moving forward third
step carry that 1 plus in that i=2 now add 2 or not infront of carried
1. this way for step 4 we consider adding 3 

                                      []
                          ____________/ \____________
                         /                           \
                     [1]                             []
               ______/ \______                 ______/ \______
              /               \               /               \
          [1,2]             [1]             [2]                []
         /     \           /    \         /     \             /   \
  [1,2,3]      [1,2]     [1,3]  [1]    [2,3]     [2]        [3]    []

basically no of nodes 2^n and Time complexity other that recurssive call
o(n) so overall its 2^n * n

btw understand path it goes like [],[1],[1,2],[1,2,3],back to [1,2]......

Type	                       Logic Used	                                         Tree Branching
Subset(Combination)	   Include or Exclude each element	                    2 choices per element → 2ⁿ
Permutation	           Try placing every unused element at every position	n! total permutations


Category	                       Combination	                                    Permutation
Recursion Logic	       At each step: include or not include element	    Try every unused element at each position
Loop Start	           Start from i to avoid duplicates	                Always start from 0, but use visited[] or swap
Duplicates Handling	   Easily avoided by i+1 in recursion	            Need visited array or swap-restore logic

1️⃣ What is a Combination?

Definition: A combination is a selection of items from a larger set where order does not matter.
You are simply choosing a group of elements.

Example: Set = {A, B, C}
Combinations of size 2 are:
{A, B}
{A, C}
{B, C}
Note: {A, B} is the same as {B, A} → only counted once.
Use cases:
Choosing lottery numbers
Picking teams from a group
Selecting toppings on a pizza (no order needed)

2️⃣ What is a Permutation?

Definition: A permutation is an arrangement of items where order does matter.
You are arranging or ordering elements.

Example: Set = {A, B, C}
Permutations of size 2 are:
(A, B)
(B, A)
(A, C)
(C, A)
(B, C)
(C, B)
Each distinct ordering counts separately.
Use cases:
Seating arrangements
Password or code combinations where order is important
Arranging books on a shelf

🔍 How do you know it’s about combinations?
You want subsets — groups of elements chosen from the array.
Order does NOT matter here:
[1, 2] is the same subset as [2, 1].
The problem says unique subsets → so no permutations or different orders of the same elements.
This means you’re choosing which elements to include or exclude, not arranging them.
That’s the definition of combinations.


Backtracking is perfect when:
You want to explore all possible choices step by step.
You want to build partial solutions and explore adding or skipping elements.
You want to avoid duplicates easily by controlling the order you pick elements.
In this problem:
For each element, you can either include or exclude it.
You recursively explore both choices.
When you reach the end, you add the current subset to the result.
Backtracking is a natural fit for generating all subsets because it explores the decision tree of include/exclude for each element.


Visual of subset construction and backtracking:
Observe according to tree easy to understand
Start: []
Choose 1 → [1]
    Choose 2 → [1, 2]
        Choose 3 → [1, 2, 3] → add to output
        Backtrack → remove 3 → [1, 2]
    Backtrack → remove 2 → [1]
    Skip 2 → [1]
        Choose 3 → [1, 3] → add to output
        Backtrack → remove 3 → [1]
Backtrack → remove 1 → []
Skip 1 → []
    Choose 2 → [2]
        Choose 3 → [2, 3] → add to output
        Backtrack → remove 3 → [2]
    Backtrack → remove 2 → []
    Skip 2 → []
        Choose 3 → [3] → add to output
        Backtrack → remove 3 → []
Done    
*/


/*Yes, exactly!

Most classic backtracking problems typically fall into these two main patterns:

Include-Exclude Tree (Subset Style)
You decide at each step whether to include or exclude the current element.
The recursion branches explicitly into two calls: one with the element included, one without.
Or it’s implicitly done by a for loop with index moving forward (no repetitions).
Example problems: subsets, combinations without repetition, permutations without repetition (with some tweaks).

For-Loop-Based Tree (Combination/Partition Style)
You explore possible choices using a for loop, and recurse once per choice.
Whether or not you allow repetition depends on how you update the index:
i+1 → no repetition
i → allow repetition
Example problems: combination sum, partition problems, palindrome partitioning.
*/


/*
xactly! You nailed it — you can solve combinations without repetition using both approaches, and that’s why you often see them implemented with a for loop (for-loop-based tree) but they’re still logically include/exclude at their core.

Here’s the nuance:

1. Explicit Include-Exclude (2 Recursive Calls per Step)
At each index, you explicitly do:

Include current element → recurse on next index
Exclude current element → recurse on next index
This clearly builds a binary tree of decisions.

2. For-Loop-Based (One Recursive Call per Iteration)
You use a for loop from current index i to end:

At each iteration, you include nums[i] once and recurse with i+1 (to avoid repetition).
Skipping the element is implicitly done by the for loop moving to the next index — so you don’t explicitly write an exclude call.
This also covers all subsets/combinations but more compactly.

So...
Both approaches generate the same combinations, but
The explicit include-exclude builds a binary tree (2 calls per index).
The for-loop-based builds a multi-branch tree, where each branch is one element included, and skipping elements is handled by loop iterations.
Why prefer for-loop-based in practice?
It’s usually cleaner and more efficient, especially when no repetition allowed.
Less code, easier to handle constraints (like no duplicates, ordered results, etc.).
Summary:

Yes, you can solve combinations without repetition either by explicit include/exclude or by for-loop + recursion with i+1.
The for-loop method is just a more concise way to implicitly do the exclude part.
*/
