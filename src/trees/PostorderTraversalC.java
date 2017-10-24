package trees;

/**
 * https://www.interviewbit.com/problems/postorder-traversal/
 *
 * Aproach based on stack and prev. Traversed element is added in one place.
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
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
	    Deque<TreeNode> s = new ArrayDeque<>();
	    ArrayList<Integer> order = new ArrayList<>();

	    if (root != null)
	        s.push(root);
	        
	    TreeNode prev = null;
        while (!s.isEmpty()) {
            TreeNode cur = s.peek();
            
            if (prev == null || prev.left == cur || prev.right == cur) {
                if (cur.left != null)
                    s.push(cur.left);
                else if (cur.right != null)
                    s.push(cur.right);
            } else if (cur.left == prev) {
                if (cur.right != null)
                    s.push(cur.right);
            } else {
                order.add(cur.val);
                s.pop();            
            }
        
            prev = cur;
        }

        return order;
	}
}
