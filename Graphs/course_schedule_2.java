class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //create adj list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<numCourses;i++)
        adj.add(new ArrayList<>());

        for(int i=0;i<prerequisites.length;i++)
        adj.get(prerequisites[i][1]).add(prerequisites[i][0]);

        int[] indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[numCourses];
        int n=0;

        for(int i=0;i<numCourses;i++)
        for(int value : adj.get(i))
        indegree[value]=indegree[value]+1;

        for(int i=0;i<numCourses;i++)
        if(indegree[i]==0)
        q.add(i);


        while(!q.isEmpty())
        {
            int node = q.poll();
            result[n]=node;
            n++;

            for(int value : adj.get(node))
            {
                indegree[value]--;
                if(indegree[value]==0)
                {
                    q.add(value);
                }
            }
        }

        for(int i=0;i<numCourses;i++)
        if(indegree[i]>0)
        return new int[0];

        return result;

    }
}




        /*int course[] = new int[numCourses];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
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

        int cnt = 0, k=0;

        while(!q.isEmpty())
        {
            int q_value = q.poll();
            cnt++;
            course[k++]=q_value;
            for(int adj_value : adj.get(q_value))
            {
                indegree[adj_value]--;
                if(indegree[adj_value]==0)
                q.add(adj_value);
            }
        }       

        // Reverse the course array
        reverseArray(course, k);

        // If the number of courses completed is not equal to numCourses, return an empty array
        if(cnt != numCourses) 
        return new int[0];

        return course;
    }

    // Helper method to reverse the array
    private void reverseArray(int[] array, int length) {
        int left = 0;
        int right = length - 1;
        while(left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}*/
