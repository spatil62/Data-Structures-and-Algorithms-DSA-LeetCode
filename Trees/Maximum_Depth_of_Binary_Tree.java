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

 /*depth means height we need to first check with child 
 then we will get height for parents so go ahead postorder 
 thats why first necesoory to travel left and right then 
 root and operation 
 steps to remember :
 1.base case to return 
 2.Recursive calls
 3.work at nodes
 4.return value
 */

class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null)
        return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1+Math.max(left,right);    
    }
}

/*class Solution {

    int count = 0;
    public int maxDepth(TreeNode root) {
        int count=0;

        if(root==null)
        return 0;

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty())
        {
            int level_size = q.size();

            for(int i=0;i<level_size;i++)
            {
                TreeNode temp = q.poll(); 

                if(temp.left!=null)
                q.add(temp.left);

                if(temp.right!=null)
                q.add(temp.right);
            }
            count++;
        }
        return count;
    }
}
*/
