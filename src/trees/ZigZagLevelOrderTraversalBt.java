package trees;

/**
 * https://www.interviewbit.com/problems/zigzag-level-order-traversal-bt
 *
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ZigZagLevelOrderTraversalBt {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
	    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	    
	    Queue<TreeNode> q = new ArrayDeque<>();
	    if (root != null)
	        q.offer(root);
	    
	    boolean leftToRight = true;     
	    while (!q.isEmpty()) {
            Deque<TreeNode> nq = new ArrayDeque<>();
            ArrayList<Integer> level = new ArrayList<>();
            
            while (!q.isEmpty()) {
                TreeNode cur = q.poll();
                level.add(cur.val);
                
                if (leftToRight) {
                    if (cur.left != null) nq.push(cur.left);
                    if (cur.right != null) nq.push(cur.right);
                } else {
                    if (cur.right != null) nq.push(cur.right);
                    if (cur.left != null) nq.push(cur.left);
                }
            }

            leftToRight = !leftToRight;
            
	        if (!level.isEmpty())
	            res.add(level);
	        
	        if (!nq.isEmpty())
	            q = nq;
	    }
	    
	    return res;
	}
}
