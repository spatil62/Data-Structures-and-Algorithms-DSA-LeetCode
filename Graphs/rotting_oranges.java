class Solution {
    public int orangesRotting(int[][] grid) {

        int fresh_count = 0, x = 0, y = 0, min = 0;
        Queue<int[]> q = new LinkedList<>(); 

        int row = grid.length;
        int col = grid[0].length;

        for(int i=0;i<row;i++)
        for(int j=0;j<col;j++)
        if(grid[i][j]==2)
            q.add(new int[]{i,j});
        else if(grid[i][j]==1)
            fresh_count++;

        if(fresh_count==0)
        return 0;

        int[] dx = {0,1,0,-1};
        int[] dy = {-1,0,1,0};

        while(!q.isEmpty())
        {
            int q_size = q.size();

            for(int i=0;i<q_size;i++)
            {
            int[] q_value = q.poll();
                for(int j=0;j<4;j++)
                    {
                     x = q_value[0]+dx[j];
                     y = q_value[1]+dy[j];

                     if(x<0 || y<0 || x>=row || y>=col || grid[x][y]==0 || grid[x][y]==2)
                     continue;

                     grid[x][y]=2;
                     q.add(new int[]{x,y});
                     fresh_count--;
                    }          
            }
            min++; 
        }

        return fresh_count == 0 ? min-1 : -1;
    }
}
