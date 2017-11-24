package trees;

/**
 * https://www.interviewbit.com/problems/invert-the-binary-tree/
 *
 * BFS approach.
 *
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class InvertTheBinaryTreeA {
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        if (root != null)
            q.offer(root);
            
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;
            
            if (cur.left != null)
                q.offer(cur.left);
            if (cur.right != null)
                q.offer(cur.right);
        }
        
        return root;
    }
}

