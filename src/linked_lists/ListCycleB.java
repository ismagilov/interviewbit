package linked_lists;

/**
 * https://www.interviewbit.com/problems/list-cycle/
 *
 * When cycle is detected, move the first pointer to head and start moving two pointer. Meet point is the answer.
 *
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class ListCycleB {
	public ListNode detectCycle(ListNode head) {
	    ListNode s = head;
	    ListNode f = head;
	    
	    boolean found = false;
	    while (f.next != null && f.next.next != null) {
	        s = s.next;
	        f = f.next.next;
	        
	        if (s == f) {
	            s = head;
	            
	            while (s != f) {
	                s = s.next;
	                f = f.next;
	            }
	            
	            return s;
	        }
	    }
	    
	    return null;
	}
}
