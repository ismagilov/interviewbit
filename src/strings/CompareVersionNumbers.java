package strings;

/**
* https://www.interviewbit.com/problems/compare-version-numbers/
*/ 
public class CompareVersionNumbers {
	public int compareVersion(String a, String b) {
		int i = 0, j = 0;
		int res = 0;
		while (i != a.length() || j != b.length()) {
			StringBuilder ab = new StringBuilder();
			while (i < a.length() && a.charAt(i) != '.') {
					ab.append(a.charAt(i));
					i++;
			}

			StringBuilder bb = new StringBuilder();
			while (j < b.length() && b.charAt(j) != '.') {
					bb.append(b.charAt(j));
					j++;
			}

				res = compare(ab, bb);  
				if (res != 0)
			break;

				if (i != a.length())
			i++;
				if (j != b.length())
			j++;
		}

		return res;
	}

	private int compare(StringBuilder b1, StringBuilder b2) {
	    int lng1 = b1.length();
	    int lng2 = b2.length();

	    int res = 0;
	    if (b1.length() == b2.length()) {
			res = b1.toString().compareTo(b2.toString());
	    } else if (b1.length() < b2.length()) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < lng2 - lng1; i++)
				sb.append('0');
			sb.append(b1);
			res = sb.toString().compareTo(b2.toString());
	    } else {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < lng1 - lng2; i++)
				sb.append('0');
			sb.append(b2);
			res = b1.toString().compareTo(sb.toString());
	    }

	    if (res == 0)
			return 0;
	    else if (res < 0)
			return -1;
	    else 
			return 1;
	}
}

