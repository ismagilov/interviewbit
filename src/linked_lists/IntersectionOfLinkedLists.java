package linked_lists;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 *
 * https://www.interviewbit.com/problems/intersection-of-linked-lists/
 *
 * Two pointers solution.
 */
public class IntersectionOfLinkedLists {
	public ListNode getIntersectionNode(ListNode a, ListNode b) {
	    ListNode pa = a, pb = b;
	    
	    int cnt = 0;
	    while (cnt < 2) {
	        if (pa == null) {
	            pa = b;
	            cnt++;
	        } else 
	            pa = pa.next;    
	            
	        if (pb == null) {
	            pb = a;
	            cnt++;
	        } else
                pb = pb.next;
	    }
	    
	    ListNode res = null;
	    while (pa != null && pb != null) {
	        if (pa == pb) {
	            res = pa;
	            break;
	        }
	            
	        pa = pa.next;
            pb = pb.next;
	    }
	    
	    return res;
	}
}
