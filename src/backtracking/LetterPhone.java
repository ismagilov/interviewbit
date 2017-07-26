/**
* https://www.interviewbit.com/problems/letter-phone/
*/
public class LetterPhone {
    private final String[] phone;
    
    public Solution() {
        String[] ph = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        phone = ph;
    }
    
	public ArrayList<String> letterCombinations(String a) {
	    return combinations(a, 0, a.length(), new StringBuilder());
	}
	
	private ArrayList<String> combinations(String numbers, int start, int lng, StringBuilder set) {
	    ArrayList<String> res = new ArrayList<>();
	    if (set.length() == lng) {
	        res.add(new String(set));
	        return res;
	    }
	    
        int digit = numbers.charAt(start) - '0';
        char[] letters = phone[digit].toCharArray();
        for (char l : letters) {
            set.append(l);
            res.addAll(combinations(numbers, start + 1, lng, set));
            set.deleteCharAt(set.length() - 1);
        }
        
	    return res;
	}
}
