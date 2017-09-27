/**
 * https://www.interviewbit.com/problems/merge-two-sorted-lists/ 
 *
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class MergeTwoSorted {
	public ListNode mergeTwoLists(ListNode a, ListNode b) {
	    ListNode it1 = a;
	    ListNode it2 = b;
	    
	    ListNode res = null;
	    ListNode it = null;
	    while (it1 != null && it2 != null) {
	        if (it1.val <= it2.val) {
	            if (res == null) {
	                res = it1;
	                it = res;
	            } else { 
	                it.next = it1;
	                it = it.next;
	            }
	            
	            it1 = it1.next;
	        } else {
	            if (res == null) {
	                res = it2;
	                it = res;
	            } else {
	                it.next = it2;
	                it = it.next;
	            }

	            it2 = it2.next;
	        }
	    }

        if (it1 != null)
            it.next = it1;
        else if (it2 != null)
            it.next = it2;
	    
	    return res;
	}
}
