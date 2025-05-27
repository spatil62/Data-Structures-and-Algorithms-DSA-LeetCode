class Solution {
    public int swimInWater(int[][] grid) {
        //matrix given so dont create adj list
        int n = grid.length;

        int[] dx = {0, 1, 0, -1};  // Directions for moving in 4 directions (up, right, down, left)
        int[] dy = {-1, 0, 1, 0};

        // Priority queue to store (time, x, y) and explore cells with minimum elevation first
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        // Start from the top-left corner (0, 0)
        pq.add(new int[]{grid[0][0], 0, 0});  
        
        // To track visited cells to avoid revisiting them
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        
        int maxTime = grid[0][0];  // The initial max time is the elevation at (0, 0)

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int t = current[0];  // Water level (time)
            int x = current[1];  // Row index
            int y = current[2];  // Column index

            // If we have reached the bottom-right corner, return the time
            if (x == n - 1 && y == n - 1) {
                return t;
            }
            
            // Explore the 4 adjacent cells
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // Skip invalid or already visited cells
                if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny]==true) {
                    continue;
                }
                
                visited[nx][ny] = true;
                // Add the new cell to the priority queue with the max time encountered so far
                pq.add(new int[]{Math.max(t, grid[nx][ny]), nx, ny});
            }
        }
        
        return -1;  // Return -1 if no path is found (although this shouldn't happen with valid input)
    }
}
