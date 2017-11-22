package linked_lists;

/**
 * https://www.interviewbit.com/problems/remove-nth-node-from-list-end/
 *
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class RemoveNthNodeFromListEnd {
	public ListNode removeNthFromEnd(ListNode list, int n) {
	    ListNode start = new ListNode(-1);
	    start.next = list;
	    
	    ListNode slow = start, fast = start;
	    
	    for (int i = 0; i <= n && fast != null; i++)
	        fast = fast.next;

	    while (fast != null) {
	        fast = fast.next;
	        slow = slow.next;
	    }      
	    
	    if (slow.next != null)
	        slow.next = slow.next.next;

	    return start.next;
	}
}
