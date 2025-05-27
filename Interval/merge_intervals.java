class Solution {
    public int[][] merge(int[][] intervals) {
        //dont forget about comparator before interview 
        /*Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
         }
        });*/
        //logic behind every interval problem 
        //1.make sure new intervals first element is greater than sequences last element
        //2.make sure old sequence first element is greater than new sequences last element 
        //3.basically find spot where our interval is in between sequences 
        //by finding above two and chnage conditions of equal to or anything else accordingly 


        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        List<int []> list = new ArrayList<>();

        for(int[] interval : intervals)
        {
            if(list.size()==0 || list.getLast()[1]<interval[0])
            list.add(interval);
            else 
            list.getLast()[1]=Math.max(list.getLast()[1],interval[1]);
        }
        return list.toArray(new int[list.size()][]);
    }
}


