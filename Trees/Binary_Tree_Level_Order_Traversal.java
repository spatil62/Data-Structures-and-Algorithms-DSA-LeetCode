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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> array = new ArrayList<>();

        if (root == null) {
            return array;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty())
        {
          int levelSize = q.size();
          List<Integer> level = new ArrayList<>(); 
          for(int i=0;i<levelSize;i++)
          {
            TreeNode temp = q.poll();
            level.add(temp.val); 

            if(temp.left!=null)
            q.add(temp.left);

            if(temp.right!=null)
            q.add(temp.right);
          }  
          array.add(level);
        }
        return array;
    }
}
