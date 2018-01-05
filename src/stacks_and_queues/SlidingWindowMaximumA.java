package stacks_and_queues;

/**
* https://www.interviewbit.com/problems/sliding-window-maximum/
*/
public class SlidingWindowMaximumA {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> slidingMaximum(final List<Integer> a, int w) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        ArrayList<Integer> r = new ArrayList<>();

        for (int i = 0; i < a.size() && i < w; i++) {
            int v = a.get(i);
            while (!q.isEmpty() && v > a.get(q.getLast()))
                q.removeLast();

            q.addLast(i);
        }

        if (!q.isEmpty())
        r.add(a.get(q.getFirst()));

        for (int i = w; i < a.size(); i++) {
            int v = a.get(i);
            while (!q.isEmpty() && v > a.get(q.getLast()))
                q.removeLast();
            while (!q.isEmpty() && q.getFirst() < i - w + 1)
                q.removeFirst();
                
            q.addLast(i);

            r.add(a.get(q.getFirst()));
        }

        return r;
    }
}
