class Solution {
    public void islandsAndTreasure(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return;

        int rows = grid.length;
        int cols = grid[0].length;

        // Initialize the queue for BFS
        Queue<int[]> queue = new LinkedList<>();

        // Directions for moving (right, left, down, up) as dx and dy
        int[] dx = {1, -1, 0, 0};  // Change in row (down, up, no move, no move)
        int[] dy = {0, 0, 1, -1};  // Change in column (no move, no move, right, left)

        // Add all treasure chest cells (0s) to the queue
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    queue.add(new int[]{r, c});
                }
            }
        }

        // Perform BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            // Check the 4 possible directions (up, down, left, right)
            for (int i = 0; i < 4; i++) {
                int newRow = r + dx[i];
                int newCol = c + dy[i];

                // Skip out-of-bounds cells or already visited cells (INF)
                if (newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols || grid[newRow][newCol] != Integer.MAX_VALUE) {
                    continue;
                }

                // Update the distance
                grid[newRow][newCol] = grid[r][c] + 1;
                // Add the new cell to the queue
                queue.add(new int[]{newRow, newCol});
            }
        }
    }
}

