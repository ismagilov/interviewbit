/**
 * https://www.interviewbit.com/problems/merge-k-sorted-lists/
 * 
 * Divide and conquer: merge pairs of lists.
 *
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class MergeKSortedListsB {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {

	    while (lists.size() != 1) {
            ArrayList<ListNode> merged = new ArrayList<>();
    	    for (int i = 0; i < lists.size(); i += 2) {
    	       if (i + 1 == lists.size())
    	            merged.add(lists.get(i));
    	       else 
    	            merged.add(mergeTwoLists(lists.get(i), lists.get(i + 1)));
    	    }
    	    
    	    lists = merged;
	    }
	    
	    return lists.get(0);
	}
	
	private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	    ListNode res = new ListNode(0);
	    ListNode it = res;
	    
	    ListNode it1 = l1, it2 = l2;
	    while (it1 != null && it2 != null) {
	        if (it1.val < it2.val) {
	            it.next = new ListNode(it1.val);
	            it = it.next;
	            
	            it1 = it1.next;
	        } else if (it1.val > it2.val) {
	            it.next = new ListNode(it2.val);
	            it = it.next;
	            
	            it2 = it2.next;
	        } else {
	            it.next = new ListNode(it1.val);
	            it = it.next;
	            it.next = new ListNode(it2.val);
	            it = it.next;
	            
	            it1 = it1.next;
	            it2 = it2.next;
	        }
	    }
	    
	    while (it1 != null) {
	        it.next = new ListNode(it1.val);
	        it = it.next;
	        it1 = it1.next;
	    }
	    
	    while (it2 != null) {
	        it.next = new ListNode(it2.val);
	        it = it.next;
	        it2 = it2.next;
	    }
	    
	    return res.next;
	}
}
