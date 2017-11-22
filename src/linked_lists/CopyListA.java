/**
 * https://www.interviewbit.com/problems/copy-list/
 *
 * Hash-based approach.
 *
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class CopyListA {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> hash = new HashMap<>();

        RandomListNode cur = head;
        while (cur != null) {
            if (!hash.containsKey(cur))
                hash.put(cur, new RandomListNode(cur.label));
            RandomListNode copy = hash.get(cur);
            
            if (cur.next != null) {
                if (!hash.containsKey(cur.next))
                    hash.put(cur.next, new RandomListNode(cur.next.label));
                copy.next = hash.get(cur.next);
            }
            
            if (cur.random != null) {
                if (!hash.containsKey(cur.random))
                    hash.put(cur.random, new RandomListNode(cur.random.label));
                copy.random = hash.get(cur.random);
            }
            
            cur = cur.next;  
        }
        
        return hash.get(head);
    }
}
