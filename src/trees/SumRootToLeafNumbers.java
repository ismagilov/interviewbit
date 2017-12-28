package trees;

/**
 * https://www.interviewbit.com/problems/sum-root-to-leaf-numbers/
 * 
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class SumRootToLeafNumbers {
    private int sum = 0;
    private final int M = 1003;
    
    public int sumNumbers(TreeNode root) {
        return sumLeaves(root, 0);
    }
    
    private int sumLeaves(TreeNode root, int acc) {
        if (root == null) return 0;
        
        int v = (acc * 10 + root.val) % M;
        
        if (root.left == null && root.right == null)
            return v;

        int res = sumLeaves(root.left, v) + sumLeaves(root.right, v);
        
        return res % M;
    }
}
