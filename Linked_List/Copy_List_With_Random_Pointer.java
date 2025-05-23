/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
     // Map to store the mapping from original node to its copy
        Map<Node, Node> map = new HashMap<>();
        //oldToCopy.put(null, null); // Handle null case

        // First pass: create copies of the nodes and store in the map
        Node cur = head;
        while (cur != null) {
            Node copy = new Node(cur.val);
            map.put(cur, copy);
            cur = cur.next;
        }

        // Second pass: link the next and random pointers for the copied nodes
        cur = head;
        while (cur != null) {
            Node copy = map.get(cur);
            copy.next = map.get(cur.next);
            copy.random = map.get(cur.random);
            cur = cur.next;
        }

        // Return the head of the copied list
        return map.get(head);
    }
}
