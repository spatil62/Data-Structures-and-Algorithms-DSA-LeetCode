class Solution {
    public int numIslands(char[][] grid) {
        //Tip : first half problem way of direction solve it 
        //second half mostly using khans principle if not 
        //if ques is not directed edges add two side edges and
        //follow same approach if its directed use khans principle 
        //if not use only queue


        //check adjecency list logic as well
        int row = grid.length;
        int col = grid[0].length;
        int count_islands = 0;

        // Direction vectors for moving up, down, left, right
        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        // Visited array to track visited cells
        boolean[][] visited = new boolean[row][col];

        // Iterate over all cells in the grid
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // If the current cell is land ('1') and hasn't been visited
                if (grid[i][j] == '1' && !visited[i][j]) {
                    // Start BFS for this island
                    bfs(grid, visited, i, j, row, col, dx, dy);
                    // Increment island count
                    count_islands++;
                }
            }
        }

        return count_islands;
    }

    private void bfs(char[][] grid, boolean[][] visited, int i, int j, int row, int col, int[] dx, int[] dy) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // Explore all 4 directions (up, down, left, right)
            for (int k = 0; k < 4; k++) {
                int newX = x + dx[k];
                int newY = y + dy[k];

                // Check if the new position is within bounds and is land ('1') and not visited
                if (newX >= 0 && newY >= 0 && newX < row && newY < col &&
                    grid[newX][newY] == '1' && !visited[newX][newY]) {
                    // Mark the cell as visited and add it to the queue
                    visited[newX][newY] = true;
                    queue.add(new int[]{newX, newY});
                }
            }
        }
    }
}
