/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 *
 * https://www.interviewbit.com/problems/merge-k-sorted-lists/
 *
 * Heap-based solution.
 */
public class MergeKSortedListsA {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
	    PriorityQueue<ListNode> h = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));

	    ListNode headRes = new ListNode(0);
	    ListNode lastRes = headRes;
	    
	    for (ListNode l : lists)
	        h.offer(l);
	    
	    while (!h.isEmpty()) {
	        ListNode min = h.poll();
	        
	        lastRes.next = new ListNode(min.val);
	        lastRes = lastRes.next;
	        
	        if (min.next != null)
	            h.offer(min.next);
	    }
	    
	    return headRes.next;
	}
}
