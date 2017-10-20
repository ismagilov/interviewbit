package trees;

/**
 * https://www.interviewbit.com/problems/preorder-traversal/
 *
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PreorderTraversal {
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
	    ArrayList<Integer> order = new ArrayList<>();
	    Deque<TreeNode> s = new ArrayDeque<>();
	    
	    if (root != null) 
	        s.push(root);
	    while (!s.isEmpty()) {
	        TreeNode cur = s.pop();
	        order.add(cur.val);
	        
	        if (cur.right != null)
	            s.push(cur.right);
	            
	        if (cur.left != null)
	            s.push(cur.left);
	    }
	    
	    return order;
	}
}
