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

//preoder and inorder 
class Solution {

    public Map<Integer, Integer> map;
    public int preorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Create a map to store the index of each value in the inorder array
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) 
            map.put(inorder[i], i);

        return arrayToTree(preorder, 0, inorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        // Base case: if there are no elements to construct the subtree
        if (left > right) {
            return null;
        }

        // Select the current element from preorder and increment the index
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // Get the index of the root from the inorder map
        int rootIndex = map.get(rootValue);

        // Recursively build the left and right subtrees
        root.left = arrayToTree(preorder, left, rootIndex - 1);
        root.right = arrayToTree(preorder, rootIndex + 1, right);

        return root;
    }
}


/*

postorder and inorder 
import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    private Map<Integer, Integer> map; // Stores inorder indices
    private int postorderIndex;        // Tracks root in postorder

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        postorderIndex = postorder.length - 1;
        return arrayToTree(postorder, 0, inorder.length - 1);
    }

    private TreeNode arrayToTree(int[] postorder, int left, int right) {
        if (left > right) return null;

        int rootValue = postorder[postorderIndex--];
        TreeNode root = new TreeNode(rootValue);
        int rootIndex = map.get(rootValue);

        // Build right subtree first (since postorder is left-right-root)
        root.right = arrayToTree(postorder, rootIndex + 1, right);
        root.left = arrayToTree(postorder, left, rootIndex - 1);

        return root;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Sample Input
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        // Build tree
        TreeNode root = solution.buildTree(inorder, postorder);

        // Output inorder traversal (should match the input inorder array)
        System.out.print("Inorder Traversal of Constructed Tree: ");
        inorderTraversal(root);
    }

    // Helper method for inorder traversal
    private static void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }
}
*/
