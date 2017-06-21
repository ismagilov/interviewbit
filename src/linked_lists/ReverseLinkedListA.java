package linked_lists;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 * 
 * https://www.interviewbit.com/problems/reverse-linked-list/
 *
 * Iterative approach.
 */
public class ReverseLinkedListA {
	public ListNode reverseList(ListNode a) {
	    ListNode cur = a, prev = null, next = null;
	    
	    while (cur != null) {
	        next = cur.next;
	        cur.next = prev;
	        
	        prev = cur;
	        cur = next;
	    }
	    
	    return prev;
	}
}
