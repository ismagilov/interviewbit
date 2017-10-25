/**
 * https://www.interviewbit.com/problems/min-depth-of-binary-tree/
 *
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MinDepthOfBinaryTree {
	public int minDepth(TreeNode root) {
	    if (root == null)
	        return 0;
	        
	    if (root.left == null && root.right == null)
	        return 1;
	    
	    if (root.right == null)
	        return minDepth(root.left) + 1;
	        
	    if (root.left == null)
	        return minDepth(root.right) + 1;     
	    
	    return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
	}
}
