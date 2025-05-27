class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //create adj list 
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        //memory 
        for(int i=0;i<numCourses;i++)
        adj.add(new ArrayList<Integer>());

        //lets create adj list 
        for(int i=0;i<prerequisites.length;i++)
        adj.get(prerequisites[i][0]).add(prerequisites[i][1]);

        //create queue and indegree
        int[] indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();

        //create indegree
        for(int i=0;i<numCourses;i++)
        for(int node : adj.get(i))
        indegree[node]++;

        for(int i=0;i<numCourses;i++)
        if(indegree[i]==0)
        q.add(i);

        while(!q.isEmpty())
        {
            int q_value = q.poll();

            for(int value : adj.get(q_value))
            {
                indegree[value]--;
                if(indegree[value]==0)
                q.add(value);
            }
        }

        for(int i=0;i<numCourses;i++)
        if(indegree[i]>0)
        return false;
        
        return true;

    }
}



        /*ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<numCourses;i++)
        adj.add(new ArrayList<Integer>());

        for(int i=0;i<prerequisites.length;i++)
        adj.get(prerequisites[i][0]).add(prerequisites[i][1]); 

        int indegree[] = new int[numCourses];

        for(int i=0;i<numCourses;i++)
        for(int node : adj.get(i))
        indegree[node]++;

        for(int i=0;i<numCourses;i++)
        if(indegree[i]==0)
        q.add(i);

        int cnt = 0;

        while(!q.isEmpty())
        {
            int q_value = q.poll();
            cnt++;
            for(int adj_value : adj.get(q_value))
            {
                indegree[adj_value]--;
                if(indegree[adj_value]==0)
                q.add(adj_value);
            }
        }       

        if(cnt==numCourses)
        return true;
        else
        return false;
    }
}*/
