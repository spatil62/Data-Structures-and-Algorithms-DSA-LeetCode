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

 /*
 For explaination I used neetcode video but majorly my own logic 
 Diameter means now we know the thing is diameter cant be always root nodes
 height right? so we need height of child to find diameter for root.
 So every step we need to maintain that.

 and also postorder traversal so work will be after left, right call 
 and follow basic steps as discuss earlier 
 */
 
 //You cant use integer for max store bcoz its pass by value
 //array is pass by reference 
 
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
       int[] res = new int[1];
        dfs(root, res);
        return res[0];
    }

    private int dfs(TreeNode root, int[] res) {
        //remember -1 bcoz if child no children 0 but root 
        //dont have one child then -1. thats why we returned -1.
        //easy we need to return height and maintain max diameter 
        if (root == null) {
            return -1;
        }

        int left = dfs(root.left, res);
        int right = dfs(root.right, res);
        res[0] = Math.max(res[0], 2 + left + right);
        return 1 + Math.max(left, right);
    }
}
