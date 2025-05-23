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
 
class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        checksum(root);
        return max;
    }

    public int checksum(TreeNode root){

        if(root==null)
        return 0;

        // Calculate the maximum path sum for left and right children
        int left = Math.max(0, checksum(root.left));  // Only take positive contributions
        int right = Math.max(0, checksum(root.right));  // Only take positive contributions


        int sum = left+right+root.val;

        max=Math.max(max,sum);

        //bcoz we need path so that 
        return Math.max(left, right) + root.val;
    }
}












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
 
class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        checksum(root);
        return max;
    }

    public int checksum(TreeNode root){

        if(root==null)
        return 0;

        // Calculate the maximum path sum for left and right children
        int left = Math.max(0, checksum(root.left));  // Only take positive contributions
        int right = Math.max(0, checksum(root.right));  // Only take positive contributions


        int sum = left+right+root.val;

        max=Math.max(max,sum);

        //bcoz we need path so that 
        return Math.max(left, right) + root.val;
    }
}













