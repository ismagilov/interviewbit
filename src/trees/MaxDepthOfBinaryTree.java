/**
 * https://www.interviewbit.com/problems/max-depth-of-binary-tree/
 *
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MaxDepthOfBinaryTree {
	public int maxDepth(TreeNode root) {
	    return maxDepth(root, 0);
	}
	
	private int maxDepth(TreeNode n, int curDepth) {
	    if (n == null)
	        return curDepth;
	        
	    int curLeft = maxDepth(n.left, curDepth + 1);
	    int curRight = maxDepth(n.right, curDepth + 1);
	    
	    return Math.max(curLeft, curRight);
	}
}
