package trees;

/**
 * https://www.interviewbit.com/problems/inorder-traversal/
 *
 * Use stack.
 *
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class InorderTraversalA {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
	    final ArrayDeque<TreeNode> stack = new ArrayDeque<>();
	    final ArrayList<Integer> order = new ArrayList<>();
	    
	    TreeNode cur = root; 
	    while (cur != null || !stack.isEmpty()) {
	        if (cur != null) {
	            stack.push(cur);
	            cur = cur.left;
	        } else {
	            cur = stack.pop();
	            order.add(cur.val);    
	            cur = cur.right;
	        }
	    }

	    return order;
	}
}
