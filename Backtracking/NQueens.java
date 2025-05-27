class Solution {
    public List<List<String>> solveNQueens(int n) {
      // Resultant list to store all solutions
        List<List<String>> res = new ArrayList<>();
        
        // Tracking used columns, positive diagonals, and negative diagonals
        Set<Integer> col = new HashSet<>();
        Set<Integer> posDiag = new HashSet<>(); // r + c
        Set<Integer> negDiag = new HashSet<>(); // r - c

        // Initialize the board
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
            board[i][j] = '.';
            }
        }

        backtrack(0, n, board, col, posDiag, negDiag, res);
        return res;
    }

    private void backtrack(int r, int n, char[][] board, Set<Integer> col, Set<Integer> posDiag, Set<Integer> negDiag, List<List<String>> res) {
        // Base case: If we have placed queens in all rows
        if (r == n) {
            // Add the current board configuration to the result
            List<String> copy = new ArrayList<>();
            for (char[] row : board) {
                copy.add(new String(row));
            }
            res.add(copy);
            return;
        }

        // Iterate through each column in the current row
        for (int c = 0; c < n; c++) {
            // Check if the column, positive diagonal, or negative diagonal is attacked
            if (col.contains(c) || posDiag.contains(r + c) || negDiag.contains(r - c)) {
                continue;
            }

            // Place the queen
            board[r][c] = 'Q';
            col.add(c);
            posDiag.add(r + c);
            negDiag.add(r - c);

            // Recurse to the next row
            backtrack(r + 1, n, board, col, posDiag, negDiag, res);

            // Backtrack: Remove the queen and update sets
            board[r][c] = '.';
            col.remove(c);
            posDiag.remove(r + c);
            negDiag.remove(r - c);
        }
    }
}
