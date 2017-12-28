package strings;

/**
* https://www.interviewbit.com/problems/multiply-strings/
*
* Heavy straightforward approach.
*/
public class MultiplyStringsA {
    public String multiply(String n1, String n2) {
        StringBuilder sb1 = removeLeadingZeros(new StringBuilder(n1).reverse());
        StringBuilder sb2 = removeLeadingZeros(new StringBuilder(n2).reverse());
        
        StringBuilder res = new StringBuilder("0");
        for (int i = 0; i < sb2.length(); i++) {
            StringBuilder m = multiplyByDigit(sb1, sb2.charAt(i) - '0', i);
            res = sum(res, m);
        }
        
        res = removeLeadingZeros(res);
        
        return res.reverse().toString();
    }
    
    public StringBuilder removeLeadingZeros(StringBuilder sb) {
        while (sb.length() > 1 && sb.charAt(sb.length() - 1) == '0')
            sb.deleteCharAt(sb.length() - 1);
            
        return sb;
    }
    
    public StringBuilder multiplyByDigit(StringBuilder n, int d, int rank) {
        StringBuilder res = new StringBuilder();
        
        for (int i = 0; i < rank; i++)
            res.append("0");
            
        int carry = 0;    
        for (int i = 0; i < n.length(); i++) {
            int nd = Character.digit(n.charAt(i), 10);
            
            int v = nd * d + carry;
            char r = Character.forDigit(v % 10, 10);;
            carry = v / 10;
            
            res.append(r);
        }    
        
        if (carry != 0)
            res.append((char)(carry + '0'));

        return res;
    }
    
    public StringBuilder sum(StringBuilder n1, StringBuilder n2) {
        int lng = Math.max(n1.length(), n2.length());
        
        StringBuilder res = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < lng; i++) {
            int d1 = i < n1.length() ? Character.digit(n1.charAt(i), 10) : 0;
            int d2 = i < n2.length() ? Character.digit(n2.charAt(i), 10) : 0;
            
            int v = d1 + d2 + carry;
            char r = Character.forDigit(v % 10, 10);
            carry = v / 10;
            
            res.append(r);
        }
        
        if (carry != 0)
            res.append((char)(carry + '0'));
            
        return res;    
    }
}
