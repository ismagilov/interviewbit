package stacks_and_queues;

/**
* https://www.interviewbit.com/problems/sliding-window-maximum/
*
* Heap-based approach. Time: O(NlogW), the worst: O(NlogN)
*/
public class SlidingWindowMaximumB {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> slidingMaximum(final List<Integer> a, int w) {
        PriorityQueue<Pair> q = new PriorityQueue<>();
        ArrayList<Integer> r = new ArrayList<>();

        for (int i = 0; i < a.size(); i++) {
            int cur = a.get(i);
            Pair p = new Pair (i, cur);

            q.offer(p);
            if (i >= w - 1) {
                while (q.peek().pos < i - w + 1)
                    q.poll();
                
                r.add(q.peek().val);
            }   
        }

        return r;
    }

    private final class Pair implements Comparable<Pair> {
        int pos;
        int val;

        private Pair(int p, int v) {
            this.pos = p;
            this.val = v;
        }
        
        public int compareTo(Pair other) {
            return -1 * Integer.compare(val, other.val);
        }
    }
}
