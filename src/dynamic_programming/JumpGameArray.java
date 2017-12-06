package dynamic_programming;

/**
* https://www.interviewbit.com/problems/jump-game-array/
*/
public class JumpGameArray {
	public int canJump(ArrayList<Integer> a) {
	    if (a == null || a.isEmpty())
	        return 0;

	    int maxJump = 0;
	    for (int i = 0; i < a.size(); i++) {
	        int j = a.get(i);
	        
	        if (i > maxJump)
	            return 0;
	        
	        maxJump = Math.max(maxJump, i + j);
	    }
	    
	    return 1;
	}
}
