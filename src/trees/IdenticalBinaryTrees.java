package trees;

/**
 * https://www.interviewbit.com/problems/identical-binary-trees/
 *
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class IdenticalBinaryTrees {
	public int isSameTree(TreeNode t1, TreeNode t2) {
	    return isSame(t1, t2) ? 1 : 0;
	}
	
	private boolean isSame(TreeNode t1, TreeNode t2) {
	    if (t1 == null && t2 == null)
	        return true;
	    else if (t1 == null || t2 == null)
	        return false;
	        
	    return t1.val == t2.val && isSame(t1.left, t2.left) && isSame(t1.right, t2.right);  
	}
}
