package linked_lists;

/**
 * https://www.interviewbit.com/problems/insertion-sort-list/
 *
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode a) {
       if (a.next == null)
            return a;

        ListNode head = new ListNode(0);

        ListNode sorted = head;
        ListNode unsorted = a;
        ListNode nextUnsorted = null;
        int i = 0;
        while (unsorted != null) {
            nextUnsorted = unsorted.next;

            while (sorted.next != null && sorted.next.val < unsorted.val)
                sorted = sorted.next;

            unsorted.next = sorted.next;
            sorted.next = unsorted;

            unsorted = nextUnsorted;
            sorted = head;
        }

        return head.next;
    }
}
