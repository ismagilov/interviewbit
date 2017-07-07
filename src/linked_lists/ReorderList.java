package linked_lists;

/**
 * https://www.interviewbit.com/problems/reorder-list/
 * 
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class ReorderList {
	public ListNode reorderList(ListNode a) {
	    ListNode slow = a;
	    ListNode fast = a;
	    
	    while (fast != null && fast.next != null) {
	        slow = slow.next;
	        fast = fast.next.next;
	    }
	    
	    ListNode second = slow.next;
	    slow.next = null;
	    second = reverse(second);
	    
	    ListNode first = a;
	    
	    while (second != null) {
	        ListNode nextSecond = second.next;
	        ListNode nextFirst = first.next;
	        
	        first.next = second;
	        second.next = nextFirst;
	        
	        second = nextSecond;
	        first = nextFirst;
	    }
	    
	    return a;
	}
	
	private void print(ListNode l) {
	    while (l != null) {
	        System.out.print(l.val + " ");
	        l = l.next;
	    }
	    System.out.println();
	}
	
	private ListNode reverse(ListNode l) {
	    ListNode prev = null;
	    ListNode cur = l;
	    
	    while (cur != null) {
	        ListNode next = cur.next;

	        cur.next = prev;
	        prev = cur;
	        cur = next;
	    }
	    
	    return prev;
	}
}
