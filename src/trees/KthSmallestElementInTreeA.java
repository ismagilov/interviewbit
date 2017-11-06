package trees;

/**
 * https://www.interviewbit.com/problems/kth-smallest-element-in-tree/
 * 
 * Solved using recursive in-order traversal.
 *
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class KthSmallestElementInTreeA {
    private int cnt = 0;
    
    public int kthsmallest(TreeNode root, int k) {
        if (root == null || k < 0)
            return Integer.MIN_VALUE;
            
        int found = kthsmallest(root.left, k);
        if (found != Integer.MIN_VALUE)
            return found;
        
        cnt++;
        if (cnt == k)
            return root.val;
        
        return kthsmallest(root.right, k);
    }
}
