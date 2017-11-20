/**
 * https://www.interviewbit.com/problems/least-common-ancestor
 *
 * Recursion-based approach.
 *
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LeastCommonAncestor {
    private boolean found1, found2;
    
	public int lca(TreeNode a, int val1, int val2) {
	    int res = searchLca(a, val1, val2);
	    
	    return (found1 && found2) ? res : -1;
	}
	
	public int searchLca(TreeNode a, int val1, int val2) {
	    if (a == null)
	        return -1;
	        
        int l = searchLca(a.left, val1, val2);
        int r = searchLca(a.right, val1, val2);

        if (a.val == val1)
            found1 = true;

        if (a.val == val2)
            found2 = true;

        if (l != -1 && r != -1)
            return a.val;
        else if (a.val == val1 || a.val == val2)
            return a.val;
        else if (l != -1)
            return l;
        else if (r != -1)
            return r;
        else //a.val is not val1 or val2, and left and right are -1
            return -1;
	}
}
