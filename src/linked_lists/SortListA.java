package linked_list;

/**
 * https://www.interviewbit.com/problems/sort-list/
 *
 * Top-bottom approach using recursion. Solution is accepted, but in fact, its space is O(logN).
 *
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class SortListA {
    public ListNode sortList(ListNode list) {
        if (list == null || list.next == null)
            return list;
        
        ListNode fast = list;
        ListNode slow = list;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        
        prev.next = null;
        
        ListNode l1 = list;
        ListNode l2 = slow;
        
        l1 = sortList(l1);
        l2 = sortList(l2);
        
        return mergeLists(l1, l2);
    }
    
    public ListNode mergeLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
                
            tail = tail.next;    
        }
        
        while (l1 != null) {
            tail.next = l1;
            l1 = l1.next;
            tail = tail.next;
        }
        
        while (l2 != null) {
            tail.next = l2;
            l2 = l2.next;
            tail = tail.next;
        }

        return head.next;
    }
}
