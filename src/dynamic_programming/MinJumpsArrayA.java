package dynamic_programming;

/**
* https://www.interviewbit.com/problems/min-jumps-array/
*
* Greedy approach.
*/
public class MinJumpsArrayA {
    public int jump(ArrayList<Integer> arr) {
        int reached = 0;
        int jmps = 0;
        int lastReached = 0;
        for (int i = 0; i <= reached && i < arr.size(); i++) {
            if (i > lastReached) {
                jmps++;
                lastReached = reached;
            }
            reached = Math.max(reached, i + arr.get(i));
        }
        
        return reached >= arr.size() - 1 ? jmps : -1;
    }
}
