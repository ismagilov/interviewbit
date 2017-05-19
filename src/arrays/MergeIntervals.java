package arrays;

/**
 * https://www.interviewbit.com/problems/merge-intervals/
 *
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class MergeIntervals {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> res = new ArrayList<Interval>();
        
        boolean inserted = false;
        for (Interval cur : intervals) {
            if (inserted) {
                Interval last = res.get(res.size() - 1);
                
                if (cur.start > last.end)
                    res.add(cur);
                else if (cur.start <= last.end)
                    last.end = Math.max(cur.end, last.end);
            } else {
                if (newInterval.start > cur.end) {
                    res.add(cur);
                    continue;
                }
                    
                if (newInterval.end < cur.start) {
                    res.add(newInterval);
                    res.add(cur);
                    inserted = true;
                } else {
                    Interval merged = new Interval();
                    merged.start = Math.min(cur.start, newInterval.start);
                    merged.end = Math.max(cur.end, newInterval.end);
                    
                    res.add(merged);
                    inserted = true;            
                }
            } 
        }
        
        if (intervals.size() == 0 || inserted == false)
            res.add(newInterval);

        return res;
    }
}
