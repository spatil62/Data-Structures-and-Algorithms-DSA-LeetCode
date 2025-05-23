class LRUCache {

    /*private int capacity;
    private HashMap<Integer, Node> cache;
    private Node left, right;

    // Node class for the doubly linked list
    private class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        // Initialize dummy nodes for LRU and MRU
        left = new Node(0, 0);
        right = new Node(0, 0);
        left.next = right;
        right.prev = left;
    }

    // Helper method to remove a node from the doubly linked list
    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    // Helper method to insert a node at the MRU position (right end)
    private void insert(Node node) {
        Node prev = right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = right;
        right.prev = node;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node); // Move the node to the MRU position
            insert(node);
            return node.value;
        }
        return -1; // Key not found
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key)); // Remove the old node
        }
        if (cache.size() == capacity) {
            // Remove the least recently used node
            Node lru = left.next;
            remove(lru);
            cache.remove(lru.key);
        }
        // Add the new node
        Node node = new Node(key, value);
        insert(node);
        cache.put(key, node);
    }
}*/

private LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity; // Remove the eldest when capacity is exceeded
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
