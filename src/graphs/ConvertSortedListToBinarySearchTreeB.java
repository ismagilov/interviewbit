/**
 * https://www.interviewbit.com/problems/convert-sorted-list-to-binary-search-tree/
 *
 * Solution O(N). Construct BST moving forward by list from start till end;
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
public class Solution {
    private ListNode list;
    
	public TreeNode sortedListToBST(ListNode a) {
	    ListNode it = a;
	    int lng = 0;
	    while (it != null) {
	        lng++;
	        it = it.next;
	    }
	    list = a;
	    
	    return constructBst(0, lng - 1);
	}
	
	private TreeNode constructBst(int s, int e) {
	    if (s > e)
	        return null;
	        
	    int mid = s + (e - s) / 2;
	    
	    TreeNode left = constructBst(s, mid - 1);
	    
	    TreeNode root = new TreeNode(list.val);
	    root.left = left;
	    
	    list = list.next;
	    
	    TreeNode right = constructBst(mid + 1, e);
	    root.right = right;
	       
	    return root; 
	}
}
