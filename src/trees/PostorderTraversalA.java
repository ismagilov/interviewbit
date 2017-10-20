/**
 * https://www.interviewbit.com/problems/postorder-traversal/
 *
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class PostorderTraversalA {
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
	    Deque<TreeNode> s1 = new ArrayDeque<>();
	    Deque<TreeNode> s2 = new ArrayDeque<>();

	    if (root != null)
	        s1.push(root);
	    while (!s1.isEmpty()) {
	        TreeNode cur = s1.pop();
	        s2.push(cur);
	        
	        if (cur.left != null)
	            s1.push(cur.left);
	        if (cur.right != null)     
	            s1.push(cur.right);
	    }
	    
	    ArrayList<Integer> order = new ArrayList<>();
	    while (!s2.isEmpty())
	        order.add(s2.pop().val);
	    
	    return order;
	}
}
