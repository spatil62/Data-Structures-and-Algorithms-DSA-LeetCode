class Solution {
    public boolean isValidSudoku(char[][] board) {
        //if we get confused in worst situation write directly 9 bcoz it shows limit till 9

        //Note dont get confused with column check j and i 
        //keep in mind array[first][second] first will be row
        //second will be column and analyse what you need to check 
        //thats when you will understand 
        
        int row = board.length;
        int col = board[0].length;

        // ✅ Check rows
        for (int i = 0; i < row; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < col; j++) {
                if (board[i][j] != '.') {
                    if (set.contains(board[i][j])) 
                        return false;
                    set.add(board[i][j]);
                }
            }
        }

        // ✅ Check columns
        for (int i = 0; i < col; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < row; j++) {
                if (board[j][i] != '.') {
                    if (set.contains(board[j][i])) 
                        return false;
                    set.add(board[j][i]);
                }
            }
        }

        //we can also write it as this please check i and j and row and col 
        /*// ✅ Check columns
        for (int j = 0; j < col; j++) {
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < row; i++) {
                if (board[i][j] != '.') {
                    if (set.contains(board[i][j])) 
                        return false;
                    set.add(board[i][j]);
                }
            }
        }*/

        // ✅ Check each 3x3 sub-grid (works only for 9x9)
        for (int startRow = 0; startRow < 9; startRow += 3) {
            for (int startCol = 0; startCol < 9; startCol += 3) {
                HashSet<Character> set = new HashSet<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        char current = board[startRow + i][startCol + j];
                        if (current != '.') {
                            if (set.contains(current))
                                return false;
                            set.add(current);
                        }
                    }
                }
            }
        }

        return true;
    }
}

