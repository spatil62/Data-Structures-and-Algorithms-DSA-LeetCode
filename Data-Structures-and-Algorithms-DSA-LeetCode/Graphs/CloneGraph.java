/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

/*In this context, cloning means creating an exact deep copy of a data structure. This involves:
Copying the Node Data:
Creating a new node with the same value as the original.
Replicating the Connections:
Not only do you copy the node itself, but you also create copies of the links (or edges) between nodes. Each cloned node's neighbor list will point to other cloned nodes, not to the original ones.*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // Map to store the mapping between original nodes and their clones
        Map<Node, Node> visited = new HashMap<>();

        // Queue for BFS traversal
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        
        // Create the clone for the root node and put it in the map
        visited.put(node, new Node(node.val));
        
        // Perform BFS
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            
            // Iterate through each neighbor of the current node
            for (Node neighbor : current.neighbors) {
                // If this neighbor hasn't been visited yet
                if (!visited.containsKey(neighbor)) {
                    // Create a clone of this neighbor and put it in the map
                    visited.put(neighbor, new Node(neighbor.val));
                    // Add the neighbor to the queue for BFS
                    queue.add(neighbor);
                }
                // Add the cloned neighbor to the current node's clone's neighbors list
                visited.get(current).neighbors.add(visited.get(neighbor));
            }
        }

        // Return the clone of the given node
        return visited.get(node);
    }
}

