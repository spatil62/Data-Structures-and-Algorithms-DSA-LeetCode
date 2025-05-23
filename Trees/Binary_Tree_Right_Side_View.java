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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if(root==null)
        return list;

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty())
        {
         int q_size = q.size();
         for(int i=0;i<q_size;i++)
            {
            TreeNode q_value = q.poll();
            if (i == q_size - 1) 
                list.add(q_value.val);
        
            // Add left and right children to the queue
            if (q_value.left != null) 
                q.add(q_value.left);

            if (q_value.right != null) 
                q.add(q_value.right);
            }
        }
        return list;
    }
}
