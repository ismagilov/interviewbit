package trees;

/**
 * https://www.interviewbit.com/problems/flatten-binary-tree-to-linked-list/
 *
 * Set right child of rightmost of left root's child to right root's child. 
 * And then set root's right to root's left, null root's left.
 *
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class FlattenBinaryTreeToLinkedListB {
    public TreeNode flatten(TreeNode t) {
        if (t == null)
            return t;

        TreeNode cur = t;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode it = cur.left;
                while (it.right != null) it = it.right;

                it.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }   

        return t;
    }
}
