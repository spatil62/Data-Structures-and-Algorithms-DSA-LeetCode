/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {

        if (intervals == null || intervals.size() == 0) {
            return 0; // No meetings, no rooms needed
        }

        int max= Integer.MIN_VALUE;
        int count = 0;
        int start_index = 0;
        int end_index = 0;
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];

        for(int i=0;i<intervals.size();i++)
        {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        while(start_index<intervals.size())
        {
            if(start[start_index]<end[end_index])
            {
                start_index++;
                count++;
            }
            else if(start[start_index]>=end[end_index])
            {
                end_index++;
                count--;
            }
            max = Math.max(max,count);
        }

        return max;

    }
}


