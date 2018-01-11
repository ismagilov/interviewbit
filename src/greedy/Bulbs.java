package greedy;

/**
* https://www.interviewbit.com/problems/bulbs/
*/
public class Bulbs {
    public int bulbs(ArrayList<Integer> bulbs) {
        int cnt = 0;
        
        for (int i = 0; i < bulbs.size(); i++) {
            if (isTurnedOn(bulbs, i, cnt))
                continue;

            cnt++;
        }

        return cnt;
    }
    
    private boolean isTurnedOn(ArrayList<Integer> bulbs, int i, int cnt) {
        int v = bulbs.get(i);

        if ((v == 1 && cnt % 2 == 0) || (v == 0 && cnt % 2 == 1))
            return true;
        else
            return false; //v == 1 && cnt % 2 == 1 OR v == 0 && cnt % 2 == 0
    }
}
