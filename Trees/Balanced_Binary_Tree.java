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
 So basically we need height in recursion at every node to determine at every step and if we need 
 height then how can given function return boolean. which means we need other function. This will 
 not done using same function as ques 1.
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(balancedcheckdfs(root)==-1)
        return false;
        else
        return true;
    }

    public int balancedcheckdfs(TreeNode root)
    {
        if(root==null)
        return 0;

        int left = balancedcheckdfs(root.left);
        if(left == -1)
        return -1;

        int right = balancedcheckdfs(root.right);
        if(right == -1)
        return -1;

        if(Math.abs(left-right) > 1)
        return -1;

        return 1+Math.max(left,right);
    }
}

/*





        /*int[] result = dfs(root); // Perform DFS to get the balance status and height of the tree
        boolean isTreeBalanced = (result[0] == 1); // Check if the tree is balanced
        return isTreeBalanced; // Return the result
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            // If the node is null, it is balanced, and its height is 0
            return new int[] {1, 0};
        }

        // Recursively check the left and right subtrees
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        // Determine if the current node is balanced
        boolean balanced = (left[0] == 1 && right[0] == 1 && Math.abs(left[1] - right[1]) <= 1);

        // Return whether the subtree is balanced and its height
        return new int[] {balanced ? 1 : 0, 1 + Math.max(left[1], right[1])};*/



/*



        return checkHeight(root) != -1;
    }
    
    private int checkHeight(TreeNode node) {
        if (node == null) {
            return 0; // Base case: height of an empty tree is 0
        }
        
        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) {
            return -1; // Left subtree is not balanced
        }
        
        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) {
            return -1; // Right subtree is not balanced
        }
        
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Current node is not balanced
        }
        
        return Math.max(leftHeight, rightHeight) + 1; // Height of the current node
    }
}


*/
