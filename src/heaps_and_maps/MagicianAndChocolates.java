/**
* https://www.interviewbit.com/problems/magician-and-chocolates/
*/
public class MagicianAndChocolates {
    public int nchoc(int K, ArrayList<Integer> A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for (int a : A)
            pq.offer(a);
            
        long res = 0;
        for (int i = 0; i < K; i++) {
            int max = pq.poll();
            res += max;
            res %= 1000000007;
            
            pq.offer(max / 2);
        }
        
        return (int)res;
    }
}
