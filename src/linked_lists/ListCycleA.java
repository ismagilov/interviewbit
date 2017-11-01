package linked_lists;

/**
 * https://www.interviewbit.com/problems/list-cycle/
 *
 * When cycle is found, count cycle's size. Put the first pointer on the begining. The second move forward on
 * cycle's size. Move bothe pointers forward, until they meet.
 *
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class ListCycleA {
	public ListNode detectCycle(ListNode a) {
	    ListNode s = a;
	    ListNode f = a;
	    
	    boolean found = false;
	    while (f.next != null && f.next.next != null) {
	        s = s.next;
	        f = f.next.next;
	        
	        if (s == f) {
	            found = true;
	            break;
	        }
	    }
	    
	    if (!found)
	        return null;

	    //Calculate cycle size
	    ListNode start = s;
	    int cycleSize = 1;
	    while (s.next != start) {
	        cycleSize++;
	        s = s.next;
	    }

        //s2 on head, s1 move on cycleSize forward
	    int i = cycleSize;
        ListNode s1 = a;
	    ListNode s2 = a;
	    while (i > 0) {
	        s1 = s1.next;
	        i--;
	    }

        //Meet point is the cycle start
	    while (s1 != s2) {
	        s1 = s1.next;
	        s2 = s2.next;
	    }
	    
	    return s1;
	}
}
