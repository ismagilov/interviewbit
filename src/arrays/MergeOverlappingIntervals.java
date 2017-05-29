package arrays;

/**
 * https://www.interviewbit.com/problems/merge-overlapping-intervals/
 *
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class MergeOverlappingIntervals {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(o -> o.start));
        
        ArrayList<Interval> res = new ArrayList<Interval>();
        
        for (Interval i : intervals) {
            if (res.isEmpty()) {
                res.add(i);
                continue;
            }
            
            int lastIdx = res.size() - 1;
            Interval last = res.get(lastIdx);
           
            if (Math.max(i.start, last.start) > Math.min(i.end, last.end)) {
                res.add(i);
            } else {
                Interval newInterval = new Interval(Math.min(i.start, last.start), Math.max(i.end, last.end));
                res.set(lastIdx, newInterval);
            }
        }
            
        return res;
    }
}
