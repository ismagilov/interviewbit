package trees;

/**
 * https://www.interviewbit.com/problems/symmetric-binary-tree/
 *
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SymmetricBinaryTree {
	public int isSymmetric(TreeNode a) {
	    return isSymTree(a, a) ? 1 : 0;
	}
	
	private boolean isSymTree(TreeNode a, TreeNode b) {
	    if (null == a && null == b)
	        return true;
	    if (null == a || null == b)
	        return false;
	        
	    return a.val == b.val && isSymTree(a.left, b.right) && isSymTree(a.right, b.left);    
	}
}
