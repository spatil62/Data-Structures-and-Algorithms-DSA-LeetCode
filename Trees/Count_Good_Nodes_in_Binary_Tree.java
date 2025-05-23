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
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

private int dfs(TreeNode node, int maxVal) {
        if (node == null) {
            return 0;
        }

    int res = 0;
    if (node.val >= maxVal) {
        res = 1; // The current node is a "good" node
        maxVal = node.val;
    }

    // Recursively check the left and right subtrees and add the result
    res += dfs(node.left, maxVal);
    res += dfs(node.right, maxVal);

    return res;
    }
}
