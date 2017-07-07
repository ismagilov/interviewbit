/**
 * https://www.interviewbit.com/problems/k-reverse-linked-list/
 * 
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class KReverseLinkedList {
    public ListNode reverseList(ListNode a, int K) {
        ListNode prev = null;
        ListNode cur = a;        
        ListNode head = null;
        
        while (cur != null) {
            ListNode bucketFirst = cur;
            ListNode bucketLast = cur;

            int i = K - 1;
            while (i > 0) {
                bucketLast = bucketLast.next;
                i--;
            }
            ListNode next = bucketLast.next;
            bucketLast.next = null;

            bucketLast = bucketFirst;
            bucketFirst = reverseBucket(bucketFirst);

            bucketLast.next = next;
            if (prev != null)
                prev.next = bucketFirst;
            else
                head = bucketFirst;
            
            cur = next;
            prev = bucketLast;
        }
        
        return head;
    }
    
    private ListNode reverseBucket(ListNode b) {
        ListNode prev = null;
        ListNode cur = b;
        
        while (cur != null) {
            ListNode next = cur.next;
            
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        return prev;
    }
}
