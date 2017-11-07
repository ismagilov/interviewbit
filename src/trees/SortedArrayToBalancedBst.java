package trees;

/**
 * https://www.interviewbit.com/problems/sorted-array-to-balanced-bst/
 *
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SortedArrayToBalancedBst {
	public TreeNode sortedArrayToBST(final List<Integer> a) {
	    return constructBst(a, 0, a.size() - 1);
	}
	
	private TreeNode constructBst(List<Integer> arr, int s, int e) {
	    if (s > e)
	        return null;
	        
	    int mid = s + (e - s) / 2;
	    
	    TreeNode root = new TreeNode(arr.get(mid));
	    
	    root.left = constructBst(arr, s, mid - 1);
	    root.right = constructBst(arr, mid + 1, e);
	    
	    return root;
	}
}
