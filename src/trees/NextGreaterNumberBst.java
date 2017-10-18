package trees;

/**
 * https://www.interviewbit.com/problems/next-greater-number-bst/
 * 
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class NextGreaterNumberBst {
	public TreeNode getSuccessor(TreeNode root, int v) {
	    TreeNode cur = root;
	    TreeNode ancestor = null;
	    
	    while (v != cur.val) {
	        if (v > cur.val)
                cur = cur.right;
	        else if (v < cur.val){
	            ancestor = cur;
	            cur = cur.left;
	        }
	    }
	    
	    if (cur.right != null) {
	        cur = cur.right;
    	    while (cur.left != null)
    	        cur = cur.left;
    	    
    	    return cur;
	    }
	    
	    return ancestor;
	}
}
