package math;

/**
* https://www.interviewbit.com/problems/excel-column-number/
*/
public class ExcelColumnNumber {
	public int titleToNumber(String a) {
	    char[] chs = a.toCharArray();
	    
	    int res = 0;
	    for (int i = 0; i < chs.length; i++) {
            res += (chs[chs.length - 1 - i] - 64) * Math.pow(26, i);
	    }
	        
	    return res;
	}
}
