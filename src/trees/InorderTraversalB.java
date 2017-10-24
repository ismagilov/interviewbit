package trees;

/**
 * https://www.interviewbit.com/problems/inorder-traversal/
 *
 * Without stack, Morris algo, O(1) memory space.
 *
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class InorderTraversalB {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
	    final ArrayList<Integer> order = new ArrayList<>();
	    
	    TreeNode cur = root;
	    while (cur != null) {
	        if (cur.left == null) {
	            order.add(cur.val);
	            cur = cur.right;
	        } else {
	            TreeNode pre = findPredecessor(cur);
	            
	            if (pre.right == null) {
	                pre.right = cur;
	                cur = cur.left;
	            } else {
	                pre.right = null;
	                order.add(cur.val);
	                cur = cur.right;
	            }
	        }
	        
	        
	    }

	    return order;
	}
	
	// Predecessor here means "before current" in order
	private TreeNode findPredecessor(TreeNode n) {
	    TreeNode cur = n.left;
	    
	    while (cur.right != null && cur.right != n)
	        cur = cur.right;
	    
	    return cur;
	}
}
