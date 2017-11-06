package trees;

/**
 * https://www.interviewbit.com/problems/kth-smallest-element-in-tree/
 *
 * Iterative approach, using stack data structure.
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
    private int cnt = 0;
    
    public int kthsmallest(TreeNode root, int k) {
        ArrayDeque<TreeNode> s = new ArrayDeque<>();
        
        TreeNode cur = root;
        int cnt = 0;
        while (cur != null || !s.isEmpty()) {
            if (cur != null) {
                s.push(cur);
                cur = cur.left;
            } else {
                cur = s.pop();
                cnt++;
                if (cnt == k)
                    return cur.val;
                cur = cur.right;
            }
        }
        
        return Integer.MIN_VALUE;
    }
}
