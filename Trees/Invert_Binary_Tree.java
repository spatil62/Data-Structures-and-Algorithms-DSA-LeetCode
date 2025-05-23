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
space complexity : 
So for your recursion stack:
Balanced tree recursion uses space proportional to tree height ≈ log n → much less memory
Skewed tree recursion uses space proportional to n → more memory
*/

class Solution {
    public TreeNode invertTree(TreeNode root) {
        //we have to swap first means work on root node first then child 
        //so preorder and offcourse we are on root so logic comes first and 
        //then traverse through all tree
        if (root == null) 
        return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}

   /*if(root==null)
        return null;

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty())
        {
            TreeNode CurrentNode = q.poll();

            TreeNode temp = CurrentNode.left;
            CurrentNode.left = CurrentNode.right;
            CurrentNode.right = temp;

            if(CurrentNode.left != null)
            q.add(CurrentNode.left);

            if(CurrentNode.right != null)
            q.add(CurrentNode.right);
        }

        return root;
        
    }
}*/

