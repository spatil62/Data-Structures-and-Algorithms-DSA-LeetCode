class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max_area=0;
        int row = grid.length;
        int col = grid[0].length;

        int[] dx = {0,1,0,-1};
        int[] dy = {-1,0,1,0};

        boolean[][] vis = new boolean[row][col];

        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++)
                if(vis[i][j]!=true && grid[i][j]==1)
                    max_area = Math.max(bfs(grid,vis,i,j,dx,dy,row,col),max_area);
      
        return max_area;       
    }

    public int bfs(int[][] grid, boolean[][] vis, int i, int j, int[] dx, int[] dy, int row, int col)
    {
        int count=0, x=0, y=0;
        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{i,j});
        //imp visited here
        vis[i][j]=true;

        while(!q.isEmpty())
        {
            int[] q_value = q.poll();

            for(int k=0;k<4;k++)
                {
                    x=dx[k]+q_value[0];
                    y=dy[k]+q_value[1];

                    if(x<0 || y<0 || x>=row || y>=col || grid[x][y]==0 || vis[x][y]==true)
                    continue;

                    vis[x][y]=true;
                    q.add(new int[]{x,y});
                }
            count++;
        }
        return count;
    }
}
