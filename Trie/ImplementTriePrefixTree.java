class Trie {
    //for trie do follow Take you forward 
    // Define a TrieNode class that will represent each node in the Trie
    private class TrieNode {
        TrieNode[] children;
        boolean isWord;

        // Constructor for TrieNode
        public TrieNode() {
            children = new TrieNode[26]; // There are 26 letters in the alphabet
            isWord = false; // Initially, it's not a word
        }
    }

    private TrieNode root;

    // Constructor to initialize the root node
    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie
    public void insert(String word) {
        TrieNode current = root;
        //automatic increament array element everytime
        for (char c : word.toCharArray()) {
            int index = c - 'a'; // Get the index corresponding to the character
            if (current.children[index] == null) {
                current.children[index] = new TrieNode(); // Create a new node if it doesn't exist
            }
            current = current.children[index];
        }
        current.isWord = true; // Mark the end of the word
    }

    // Returns true if the word is in the trie
    public boolean search(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                return false; // If the character is not found, return false
            }
            current = current.children[index];
        }
        return current.isWord; // Check if the current node marks the end of a word
    }

    // Returns true if there is any word in the trie that starts with the given prefix
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                return false; // If the prefix doesn't exist, return false
            }
            current = current.children[index];
        }
        return true; // If we successfully go through the prefix, return true
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
