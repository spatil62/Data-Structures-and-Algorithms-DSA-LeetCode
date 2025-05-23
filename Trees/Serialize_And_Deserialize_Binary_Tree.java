/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";  // Empty tree case
        }
        
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        // Perform BFS, serialize each node
        sb.append("[");
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            
            if (node == null) {
                sb.append("null");
            } else {
                sb.append(node.val);
                q.add(node.left);
                q.add(node.right);
            }
            
            // To separate values in the serialized string
            if (!q.isEmpty()) {
                sb.append(",");
            }
        }
        sb.append("]");
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;  // Empty tree case
        }
        
        // Remove the brackets and split by commas
        String[] nodes = data.substring(1, data.length() - 1).split(",");
        
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));  // First node is root
        q.add(root);
        
        int index = 1;
        while (!q.isEmpty() && index < nodes.length) {
            TreeNode node = q.poll();
            
            // Deserialize the left child
            if (!nodes[index].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(nodes[index]));
                q.add(node.left);
            }
            index++;
            
            // Deserialize the right child
            if (index < nodes.length && !nodes[index].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(nodes[index]));
                q.add(node.right);
            }
            index++;
        }
        
        return root;
    }
}
// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root))
