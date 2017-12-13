package trees;

/**
 * https://www.interviewbit.com/problems/flatten-binary-tree-to-linked-list/
 *
 * Straigtforward recursive solution.
 *
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class FlattenBinaryTreeToLinkedListA {
    public TreeNode flatten(TreeNode t) {
        if (t == null)
            return t;

        TreeNode left = flatten(t.left);
        TreeNode right = flatten(t.right);

        t.left = null;
        t.right = left;

        TreeNode cur = t;
        while (cur.right != null) cur = cur.right;
        cur.right = right;

        return t;
    }
}
