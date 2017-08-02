package backtracking;

import library.ListNode;

/**
 * https://www.interviewbit.com/problems/reverse-link-list-recursion/
 *
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class ReverseLinkListRecursion {
	public ListNode reverseList(ListNode a) {
	    if (a == null || a.next == null)
	        return a;
	        
	    ListNode res = reverseList(a.next);
	    
	    a.next.next = a;
	    a.next = null;
	    
        return res;	    
	}
}
