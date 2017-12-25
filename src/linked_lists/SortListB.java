package linked_lists;

/**
 * https://www.interviewbit.com/problems/sort-list/
 *
 * Bottom-up approach, without recursion.
 *
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class SortListB {
    public ListNode sortList(ListNode list) {
        int lng = 0;
        
        ListNode it = list;
        while (it != null) {
            lng++;
            it = it.next; 
        }

        ListNode head = new ListNode(-1);
        head.next = list;
        
        for (int s = 1; s < lng; s *= 2) {
            ListNode before = head;
            
            while (before.next != null) {
                ListNode l1 = before.next;
                ListNode l2 = sublist(l1, s);
                ListNode after = sublist(l2, s);
                
                MergedListEnds mle = mergeLists(l1, l2);
                
                before.next = mle.first;
                before = mle.last;
                
                before.next = after;
            }
        }
        
        return head.next;
    }

    private ListNode sublist(ListNode list, int lng) {
        ListNode it = list;
        int i = 0;
        while (it != null && i < lng - 1) {
            it = it.next;
            i++;
        }
        
        ListNode tail = null;
        if (it != null) {
            tail = it.next;
            it.next = null;
        }

        return tail;
    }
    
    private MergedListEnds mergeLists(ListNode l1, ListNode l2) {
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

        MergedListEnds mle = new MergedListEnds();
        mle.first = head.next;
        mle.last = tail;
        
        return mle;
    }
    
    private static class MergedListEnds {
        private ListNode first;
        private ListNode last;
    }
}
