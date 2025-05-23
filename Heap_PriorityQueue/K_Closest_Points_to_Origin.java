class Solution {
    public int[][] kClosest(int[][] points, int k) {

        int[][] result = new int[k][2];

        //refer aditya verma's video
        //The thing is k closest to origin means minimum distance 
        //so we need min heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));

        //square root and square both things comparison wise same
        //so instead of square root we will take square to make it easy
        for(int i=0;i<points.length;i++){
            int dist = (points[i][0]*points[i][0])+(points[i][1]*points[i][1]);
            pq.add(new int[]{dist, points[i][0], points[i][1]});
        }

        for(int i=0;i<k;i++){
            int[] arr = pq.poll();
            result[i][0]=arr[1];
            result[i][1]=arr[2];
        }

        return result;
    }
}
