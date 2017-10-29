/**
* https://www.interviewbit.com/problems/lru-cache/
*
* Solution based on HashMap and manually supported double linked list.
*/
public class LruCacheB {
    private final int capacity;
    private DoubleLinkedList list = new DoubleLinkedList();
    private final HashMap<Integer, Node> cache = new HashMap<>();
    
    public Solution(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node n = cache.get(key);
            
            list.remove(n);
            list.push(n);

            return n.value;
        } else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if (cache.containsKey(key)) {
            Node n = cache.get(key);
            n.value = value;
            
            list.remove(n);
            list.push(n);
        } else {
            Node n = new Node(key, value);
            cache.put(key, n);
            
            list.push(n);

            if (cache.size() > capacity) {
                Node last = list.pop();
                cache.remove(last.key);
            }
        }
    }
    
    private static class DoubleLinkedList {
        private Node head = new Node();
        private Node tail = new Node();
        
        private DoubleLinkedList() {
            head.next = tail;
            tail.prev = head;
        }
        
        private void remove(Node n) {
            n.prev.next = n.next;
            n.next.prev = n.prev;
        }
        
        private void push(Node n) {
            head.next.prev = n;
            
            n.next = head.next;
            n.prev = head;
            
            head.next = n;
        }
        
        private Node pop() {
            if (tail.prev == head)
                return null;
            
            Node res = tail.prev;
            remove(res);
            
            return res;
        }
        
        public String toString() {
            StringBuilder sb = new StringBuilder();
            
            Node it = head.next;
            while (it != tail) {
                sb.append("{").append(it.key).append(",").append(it.value).append("} ");
                it = it.next;
            }
            
            return sb.toString();
        }
    }
    
    private static class Node {
        private final int key;
        private int value;
        
        private Node() {
            key = -1;
            value = -1;
        }
        
        private Node(int k, int v) {
            this.key = k;
            this.value = v;
        }
        
        private Node prev;
        private Node next;
    }
}




