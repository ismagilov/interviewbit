/**
 * https://www.interviewbit.com/problems/convert-sorted-list-to-binary-search-tree/ 
 *
 * Solution O(NlogN).
 *
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class ConvertSortedListToBinarySearchTreeA {
	public TreeNode sortedListToBST(ListNode a) {
	    ListNode it = a;
	    int lng = 0;
	    while (it != null) {
	        lng++;
	        it = it.next;
	    }
	    
	    return constructBst(a, lng);
	}
	
	private TreeNode constructBst(ListNode first, int lng) {
	    if (lng == 0)
	        return null;
	    if (lng == 1)
	        return new TreeNode(first.val);
	    
	    int mid = lng / 2;
	    ListNode middle = first;
	    int cnt = 0;
	    while (cnt < mid) {
	        middle = middle.next;
	        cnt++;
	    }
	    
	    TreeNode root = new TreeNode(middle.val);
	    
	    root.left = constructBst(first, mid);
	    root.right = constructBst(middle.next, lng - mid - 1);
	       
	    return root; 
	}
}
