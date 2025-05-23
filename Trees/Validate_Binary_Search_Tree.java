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
    public boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean check(TreeNode root, long min, long max)
    {
        if(root==null)
        return true;

        if(min>=root.val || max<=root.val)
        return false;

        boolean left = check(root.left, min, root.val);
        boolean right = check(root.right, root.val, max);

        return left && right;
    }
}
        
        
        
        
        
        
        
        
        
        
        /*if (root == null) return true; // An empty tree is a valid BST

        // Queue for BFS traversal
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<long[]> rangeQueue = new LinkedList<>();

        // Add the root node with its initial range (unbounded)
        nodeQueue.add(root);
        rangeQueue.add(new long[]{Long.MIN_VALUE, Long.MAX_VALUE});

        while (!nodeQueue.isEmpty()) {
            TreeNode currentNode = nodeQueue.poll();
            long[] currentRange = rangeQueue.poll();

            // Check if the current node's value is within the valid range
            if (currentNode.val <= currentRange[0] || currentNode.val >= currentRange[1]) {
                return false;
            }

            // Add the left child to the queue with an updated range
            if (currentNode.left != null) {
                nodeQueue.add(currentNode.left);
                rangeQueue.add(new long[]{currentRange[0], currentNode.val}); // Update max for left child
            }

            // Add the right child to the queue with an updated range
            if (currentNode.right != null) {
                nodeQueue.add(currentNode.right);
                rangeQueue.add(new long[]{currentNode.val, currentRange[1]}); // Update min for right child
            }
        }

        return true; // The tree satisfies all BST properties
    }
}*
