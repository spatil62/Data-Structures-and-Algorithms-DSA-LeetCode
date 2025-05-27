class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> resultlist = new ArrayList<>();
        Queue<int []> pacq = new LinkedList<>();
        Queue<int []> atlq = new LinkedList<>();

        int row = heights.length;
        int col = heights[0].length;

        boolean[][] pac = new boolean[row][col];
        boolean[][] atl = new boolean[row][col];

        for(int i=0;i<row;i++)
        {
        pacq.add(new int[] {i,0});
        atlq.add(new int[] {i,col-1});
        pac[i][0]=true;
        atl[i][col-1]=true;
        }

        for(int i=0;i<col;i++)
        {
        pacq.add(new int[] {0,i});
        atlq.add(new int[] {row-1,i});
        pac[0][i]=true;
        atl[row-1][i]=true;
        }

        bfs(heights, pacq, pac, row, col);
        bfs(heights, atlq, atl, row, col);

        for(int i=0;i<row;i++)
        for(int j=0;j<col;j++)
        if(pac[i][j]==true && atl[i][j]==true)
        resultlist.add(Arrays.asList(i, j));

        return resultlist;

    }

    public void bfs(int[][] heights, Queue<int[]> q, boolean[][] visited, int row, int col)
    {
        int[] dx={1, -1, 0, 0};
        int[] dy={0, 0, 1, -1};

        while(!q.isEmpty())
        {
            int[] value = q.poll();

            for(int i=0;i<4;i++)
            {
            int x = value[0]+dx[i];
            int y = value[1]+dy[i];

            if(x<0 || y<0 || x>=row || y>=col || visited[x][y]==true || heights[x][y]<heights[value[0]][value[1]]) 
            continue;

            q.add(new int[]{x,y});
            visited[x][y]=true;
            }
        }      
    }
}

