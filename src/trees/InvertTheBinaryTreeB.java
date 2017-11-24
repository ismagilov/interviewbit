package trees;

/**
 * https://www.interviewbit.com/problems/invert-the-binary-tree/
 *
 * DFS approach.
 *
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class InvertTheBinaryTreeB {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        
        return root;
    }
}
