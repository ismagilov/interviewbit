package linked_lists;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class ReverseLinkedListB {
	public ListNode reverseList(ListNode a) {
	    if (a == null || a.next == null)
	        return a;
	        
	    ListNode head = reverseList(a.next);
	    a.next.next = a;
	    a.next = null;
	    
	    return head;
	}
}
