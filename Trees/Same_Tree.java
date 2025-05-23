/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

//How I approch solution 
/*
I checked for pre, post, in order but here doesnt matter so i chose pre order 
Then I checked return boolean i need that only so no requre to create new function
Then bcoz its pre i started writing logic first which checking similar if its 
similar go for left and right check together 
Then i though need return after null so managed null options thats all 
*/

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        // Base case: both nodes are null, which means they are identical at this position
        if (p == null && q == null) return true;

        // If only one of them is null or their values differ, the trees are not the same
        if (p == null || q == null || p.val != q.val) 
        return false;
        
        // Recursively check the left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

        /*Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.add(p);
        q2.add(q);

        while(!q1.isEmpty() && !q2.isEmpty())
        {
            TreeNode q1_node = q1.poll();
            TreeNode q2_node = q2.poll();

            // Null check for current nodes and value comparison
            if (q1_node == null && q2_node != null || q1_node != null && q2_node == null) {
                return false;  // If one is null and the other is not, return false
            }

            if (q1_node != null && q2_node != null && q1_node.val != q2_node.val) {
                return false;  // If values are not equal, return false
            }

            // Add left and right children to respective queues
            if (q1_node != null) {
                q1.add(q1_node.left);
                q1.add(q1_node.right);
            }
            if (q2_node != null) {
                q2.add(q2_node.left);
                q2.add(q2_node.right);
            }
        }

        return q1.isEmpty() && q2.isEmpty();*/

    }
}


