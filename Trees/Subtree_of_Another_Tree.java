**
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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null || subRoot==null)
        return 

        if(root.val==subRoot.val){
            if(Check(root, subRoot))
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean Check(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot==null)
        return true;
        else if(root == null || subRoot == null || root.val != subRoot.val)
        return false;

        return Check(root.left,subRoot.left) && Check(root.right,subRoot.right);
    }
}
