package dynamic_programming;

/**
 * https://www.interviewbit.com/problems/max-sum-path-in-binary-tree/
 * 
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MaxSumPathInBinaryTree {
    private int globalMax = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSumForNode(root);
        return globalMax;    
    }

    public int maxPathSumForNode(TreeNode root) {
        if (root == null) return 0;

        int maxFinishedInLeft = maxPathSumForNode(root.left);
        int maxFinishedInRight = maxPathSumForNode(root.right);

        int maxFinishedInRoot = Math.max(Math.max(maxFinishedInLeft, maxFinishedInRight) + root.val, root.val);
        int maxThroughRoot = Math.max(maxFinishedInRoot, maxFinishedInLeft + maxFinishedInRight + root.val);

        globalMax = Math.max(maxThroughRoot, globalMax);

        return maxFinishedInRoot;
    }
}
