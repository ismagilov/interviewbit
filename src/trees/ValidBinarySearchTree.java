package trees;

/**
 * https://www.interviewbit.com/problems/valid-binary-search-tree/
 *
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	public int isValidBST(TreeNode tn) {
        return isValid(tn, Integer.MIN_VALUE, Integer.MAX_VALUE);	    
	}
	
	public int isValid(TreeNode tn, int left, int right) {
	    if (tn == null) return 1;
	    if (tn.val <= left || tn.val >= right)
	        return 0;
	    
	    return isValid(tn.left, left, tn.val) * isValid(tn.right, tn.val, right);    
	}
}
