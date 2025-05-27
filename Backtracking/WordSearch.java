class Solution {
    public boolean exist(char[][] board, String word) {
         for (int i = 0; i < board.length; i++) 
            for (int j = 0; j < board[0].length; j++) 
                if (dfs(board, word, i, j, 0)) 
                    return true;    
        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int index) {
        // Base cases
        if (index == word.length()) {
            return true; // All characters matched
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false; // Out of bounds or character mismatch
        }

        // Temporarily mark the cell as visited
        char temp = board[row][col];
        board[row][col] = '#';

        // Explore all four possible directions (up, down, left, right)
        boolean found = dfs(board, word, row + 1, col, index + 1) ||
                        dfs(board, word, row - 1, col, index + 1) ||
                        dfs(board, word, row, col + 1, index + 1) ||
                        dfs(board, word, row, col - 1, index + 1);

        // Restore the original character after exploring
        board[row][col] = temp;

        return found;
    }
}


