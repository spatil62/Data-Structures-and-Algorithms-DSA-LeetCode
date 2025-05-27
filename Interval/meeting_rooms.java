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
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Sort intervals by start time
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        
        // Check for conflicts between consecutive intervals
        for (int i = 1; i < intervals.size(); i++) {
            // If the current interval's start time is less than the previous interval's end time, there's a conflict
            if (intervals.get(i).start < intervals.get(i - 1).end) {
                return false;
            }
        }
        
        // No conflicts found
        return true;
    }
}

