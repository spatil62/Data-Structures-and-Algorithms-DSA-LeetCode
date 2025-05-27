/*class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isWord = false;
}

public class Solution {
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<String> findWords(char[][] board, String[] words) {
        // Build the Trie
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isWord = true;
        }

        int rows = board.length;
        int cols = board[0].length;
        List<String> result = new ArrayList<>();

        // BFS on each cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char c = board[i][j];
                int index = c - 'a';
                if (root.children[index] != null) {
                    bfs(board, i, j, root, result);
                }
            }
        }
        return result;
    }

    private void bfs(char[][] board, int startRow, int startCol, TrieNode root, List<String> result) {
        Queue<int[]> nodeQueue = new LinkedList<>(); // Stores [row, col, childIndex]
        Queue<TrieNode> trieQueue = new LinkedList<>(); // Stores current TrieNode
        Queue<StringBuilder> pathQueue = new LinkedList<>(); // Stores current path
        Queue<boolean[][]> visitedQueue = new LinkedList<>(); // Stores visited arrays

        // Initialize queues with starting state
        char startChar = board[startRow][startCol];
        nodeQueue.offer(new int[]{startRow, startCol});
        trieQueue.offer(root.children[startChar - 'a']);
        pathQueue.offer(new StringBuilder().append(startChar));
        boolean[][] initialVisited = new boolean[board.length][board[0].length];
        initialVisited[startRow][startCol] = true;
        visitedQueue.offer(initialVisited);

        while (!nodeQueue.isEmpty()) {
            int[] currentPos = nodeQueue.poll();
            int row = currentPos[0];
            int col = currentPos[1];
            TrieNode node = trieQueue.poll();
            StringBuilder path = pathQueue.poll();
            boolean[][] visited = visitedQueue.poll();

            // Check if we found a word
            if (node.isWord) {
                result.add(path.toString());
                node.isWord = false; // Avoid duplicates
            }

            // Explore all 4 directions
            for (int[] dir : DIRECTIONS) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Check boundaries and if already visited
                if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length 
                    || visited[newRow][newCol]) {
                    continue;
                }

                char nextChar = board[newRow][newCol];
                int nextIndex = nextChar - 'a';
                if (node.children[nextIndex] != null) {
                    // Create new copies for the next state
                    boolean[][] newVisited = new boolean[board.length][board[0].length];
                    for (int i = 0; i < board.length; i++) {
                        System.arraycopy(visited[i], 0, newVisited[i], 0, board[0].length);
                    }
                    newVisited[newRow][newCol] = true;

                    StringBuilder newPath = new StringBuilder(path);
                    newPath.append(nextChar);

                    // Enqueue all components of the new state
                    nodeQueue.offer(new int[]{newRow, newCol});
                    trieQueue.offer(node.children[nextIndex]);
                    pathQueue.offer(newPath);
                    visitedQueue.offer(newVisited);
                }
            }
        }
    }
}*/

/*public class Solution {
    public List<String> findWords(char[][] board, String[] words) {

        List<String> result = new ArrayList<>();
        int rows = board.length;
        int cols = board[0].length;

        for (String word : words) {
            if (existsInBoard(board, word, rows, cols)) {
                result.add(word);
            }
        }

        return result;
    }

    private boolean existsInBoard(char[][] board, String word, int rows, int cols) {
        // Check each cell in the board as a starting point
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == word.charAt(0)) {
                    if (bfs(board, word, r, c, rows, cols)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

     private boolean bfs(char[][] board, String word, int startRow, int startCol, int rows, int cols) {
        // Initialize BFS with a single queue
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];

        // Add the starting position and first character index to the queue
        queue.add(new int[]{startRow, startCol, 0}); // [row, col, charIndex]
        visited[startRow][startCol] = true;

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int currentRow = cell[0];
            int currentCol = cell[1];
            int charIndex = cell[2];

            // If we matched the entire word, return true
            if (charIndex == word.length() - 1) {
                return true;
            }

            // Explore neighbors
            for (int[] dir : directions) {
                int newRow = currentRow + dir[0];
                int newCol = currentCol + dir[1];
                int nextCharIndex = charIndex + 1;

                // Validate the next cell
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols &&
                        !visited[newRow][newCol] && board[newRow][newCol] == word.charAt(nextCharIndex)) {
                    queue.add(new int[]{newRow, newCol, nextCharIndex});
                    visited[newRow][newCol] = true;
                }
            }

            // Backtrack (remove visited mark when leaving this level)
            visited[currentRow][currentCol] = false;
        }

        return false;
    }
}*/

import java.util.*;

public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        int rows = board.length;
        int cols = board[0].length;

        for (String word : words) {
            if (existsInBoard(board, word, rows, cols)) {
                result.add(word);
            }
        }

        return result;
    }

    private boolean existsInBoard(char[][] board, String word, int rows, int cols) {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == word.charAt(0)) {
                    if (bfs(board, word, r, c, rows, cols)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean bfs(char[][] board, String word, int startRow, int startCol, int rows, int cols) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow, startCol, 0});
        
        // We need to track visited cells for each path separately
        // So we'll use a queue of visited sets
        Queue<Set<String>> visitedQueue = new LinkedList<>();
        Set<String> initialVisited = new HashSet<>();
        initialVisited.add(startRow + "," + startCol);
        visitedQueue.add(initialVisited);

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int currentRow = cell[0];
            int currentCol = cell[1];
            int charIndex = cell[2];
            Set<String> visited = visitedQueue.poll();

            if (charIndex == word.length() - 1) {
                return true;
            }

            for (int[] dir : directions) {
                int newRow = currentRow + dir[0];
                int newCol = currentCol + dir[1];
                String coord = newRow + "," + newCol;

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols &&
                    !visited.contains(coord) && 
                    board[newRow][newCol] == word.charAt(charIndex + 1)) {
                    
                    // Create a new visited set for this path
                    Set<String> newVisited = new HashSet<>(visited);
                    newVisited.add(coord);
                    
                    queue.add(new int[]{newRow, newCol, charIndex + 1});
                    visitedQueue.add(newVisited);
                }
            }
        }

        return false;
    }
}

/*
public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        int rows = board.length;
        int cols = board[0].length;

        for (String word : words) {
            if (existsInBoard(board, word, rows, cols)) {
                result.add(word);
            }
        }

        return result;
    }

    private boolean existsInBoard(char[][] board, String word, int rows, int cols) {
        // Edge case: If the word's length is greater than the total number of cells in the board
        if (word.length() > rows * cols) {
            return false;
        }
        // Check each cell in the board as a starting point
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == word.charAt(0)) {
                    if (bfs(board, word, r, c, rows, cols)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }



 private boolean bfs(char[][] board, String word, int startRow, int startCol, int rows, int cols) {
        // Initialize BFS queue
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visitedSet = new HashSet<>();

        // Add the starting position and first character index to the queue
        queue.add(new int[]{startRow, startCol, 0}); // [row, col, charIndex]
        visitedSet.add(startRow + "," + startCol + "," + 0);

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int currentRow = cell[0];
            int currentCol = cell[1];
            int charIndex = cell[2];

            // If we matched the entire word, return true
            if (charIndex == word.length() - 1) {
                return true;
            }

            // Explore neighbors
            for (int[] dir : directions) {
                int newRow = currentRow + dir[0];
                int newCol = currentCol + dir[1];
                int nextCharIndex = charIndex + 1;

                // Validate the next cell
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols &&
                        board[newRow][newCol] == word.charAt(nextCharIndex)) {
                    String newKey = newRow + "," + newCol + "," + nextCharIndex;
                    if (!visitedSet.contains(newKey)) {
                        queue.add(new int[]{newRow, newCol, nextCharIndex});
                        visitedSet.add(newKey);
                    }
                }
            }
        }

        return false;
    }
}*/
