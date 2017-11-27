package trees;

/**
 * https://www.interviewbit.com/problems/path-sum/
 *
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PathSum {
	public int hasPathSum(TreeNode t, int v) {
	    if (t == null)
	        return 0;

	    if (t.left == null && t.right == null) {
	        if (v - t.val == 0) return 1;
	        else return 0;
	    } 

        if (1 == hasPathSum(t.left, v - t.val))
    	    return 1;
    	
        if (1 == hasPathSum(t.right, v - t.val))
    	    return 1;
    	 
    	return 0;
	}
}
