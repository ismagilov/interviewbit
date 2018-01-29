/**
* https://www.interviewbit.com/problems/seats/
*/
public class Seats {
    private final int M = 10000003;
    
    public int seats(String seats) {
        char[] chs = seats.toCharArray();
        
        int totalSeats = 0;
        for (char ch : chs) {
            if (ch == 'x')
                totalSeats++;
        }
        
        int space = 0;
        int res = 0;
        int leftSeats = 0;
        for (char ch : chs) {
            if (ch == '.') {
                space++;
            } else {
                res += space * Math.min(leftSeats, totalSeats - leftSeats);
                res %= M;
                space = 0;
                leftSeats++;
            }
        }
        
        return res;
    }
}
