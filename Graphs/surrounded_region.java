class Solution {
    public void solve(char[][] board) {
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        Queue<int []> q = new LinkedList<>();

        int row = board.length;
        int col = board[0].length;

        for(int j=0;j<col;j++)
        {
            if(board[0][j]=='O')
            q.add(new int[]{0,j});
            
            if(board[row-1][j]=='O')
            q.add(new int[]{row-1,j});
        }

        for(int i=0;i<row;i++)
        {
            if(board[i][0]=='O')
            q.add(new int[]{i,0});
            
            if(board[i][col-1]=='O')
            q.add(new int[]{i,col-1});
        }

        while(!q.isEmpty())
        {
            int[] Value = q.poll();
            int x = Value[0];
            int y = Value[1];

            board[x][y]='1';

            for(int i=0;i<4;i++)
            {
                int newX = x+dx[i];
                int newY = y+dy[i];

                if(newX<0 || newY<0 || newX>=row || newY>=col || board[newX][newY]!='O')
                continue;

                board[newX][newY]='1';
                q.add(new int[]{newX,newY});
                
            }
        }

        for(int i=0;i<row;i++)
        for(int j=0;j<col;j++)
        if(board[i][j]=='O')
        board[i][j]='X';
        else if(board[i][j]=='1')
        board[i][j]='O';
    }
}











        /*int x=0, y=0;

        int row = board.length;
        int col = board[0].length;
     
        int[][] vis = new int[row][col];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<col;i++)
        if(board[0][i]=='O')
        {
        q.add(new int[]{0,i});
        vis[0][i] = 1;
        }

        for(int i=0;i<col;i++)
        if(board[row-1][i]=='O')
        {
        q.add(new int[]{row-1,i});
        vis[row-1][i] = 1;
        }        

        for(int i=0;i<row;i++)
        if(board[i][0]=='O')
        {
        q.add(new int[]{i,0});
        vis[i][0] = 1;
        }

        for(int i=0;i<row;i++)
        if(board[i][col-1]=='O')
        {
        q.add(new int[]{i,col-1}); 
        vis[i][col-1] = 1; 
        }

        int[] dx = {0,1,0,-1};
        int[] dy = {-1,0,1,0};  

        while(!q.isEmpty())
        {
            int[] q_value=q.poll();

            for(int j=0;j<4;j++)
            {
                x=dx[j]+q_value[0];
                y=dy[j]+q_value[1];

               if (x < 0 || y < 0 || x >= row || y >= col ||
                    board[x][y] != 'O' || vis[x][y] == 1) 
                    continue;

                    vis[x][y] = 1;
                    q.add(new int[]{x, y});
            }
        }

        for(int i=0;i<row;i++)
        for(int j=0;j<col;j++)
        if(vis[i][j]==0 && board[i][j] == 'O')
        board[i][j]='X';

        return;
        
    }
}*/
