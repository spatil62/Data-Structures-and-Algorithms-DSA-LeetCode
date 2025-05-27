class WordDictionary {
    // Define a TrieNode class that will represent each node in the Trie
    private class TrieNode {
        TrieNode[] children;
        boolean isWord;

        // Constructor for TrieNode
        public TrieNode() {
            children = new TrieNode[26]; // 26 letters in the alphabet
            isWord = false; // Initially, it's not a word
        }
    }

    private TrieNode root;

    // Constructor to initialize the root node
    public WordDictionary() {
        root = new TrieNode();
    }

    // Adds a word into the data structure
    public void addWord(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a'; // Get the index corresponding to the character
            if (current.children[index] == null) {
                current.children[index] = new TrieNode(); // Create a new node if it doesn't exist
            }
            current = current.children[index];
        }
        current.isWord = true; // Mark the end of the word
    }

    // Searches for a word in the data structure that may contain '.' as a wildcard character
    public boolean search(String word) {
        Queue<TrieNode> queue = new LinkedList<>();
        queue.offer(root);

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int size = queue.size();

            for (int j = 0; j < size; j++) {
                TrieNode currentNode = queue.poll();

                if (c == '.') {
                    // Check all possible child nodes
                    for (TrieNode child : currentNode.children) {
                        if (child != null) {
                            queue.offer(child);
                        }
                    }
                } else {
                    // Check the specific child node
                    int index = c - 'a';
                    if (currentNode.children[index] != null) {
                        queue.offer(currentNode.children[index]);
                    }
                }
            }
            
            // If the queue is empty, no match was found for this character
            if (queue.isEmpty()) {
                return false;
            }
        }

        // Check if any of the remaining nodes in the queue represent the end of a word
        while (!queue.isEmpty()) {
            if (queue.poll().isWord) {
                return true;
            }
        }

        return false;
    }
}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
