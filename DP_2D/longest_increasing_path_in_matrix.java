class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] inDegree = new int[m][n];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<int[]> q = new LinkedList<>();
        
        // Step 1: Calculate in-degrees
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] dir : directions) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
                        inDegree[x][y]++;
                    }
                }
            }
        }

        
        // Step 2: Add all cells with in-degree 0 to the queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (inDegree[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
            }
        }

        // Step 3: Perform BFS
        int maxPathLength = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            maxPathLength++; // Increase path length layer by layer
            for (int i = 0; i < size; i++) {
                int[] cell = q.poll();
                int row = cell[0], col = cell[1];
                for (int[] dir : directions) {
                    int x = row + dir[0];
                    int y = col + dir[1];
                    // Check bounds and value conditions
                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        if (matrix[x][y] <= matrix[row][col]) 
                            continue; // Skip if the current condition is not satisfied
                        
                        inDegree[x][y]--;
                        if (inDegree[x][y] == 0) 
                            q.add(new int[]{x, y});
                    }
                }
            }
        }

        return maxPathLength;
    }
}
