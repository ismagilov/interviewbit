package stacks_and_queues;

/**
* Track min in each stack node.
*
* https://www.interviewbit.com/problems/min-stack/
*/
class MinStackA {
    private StackNode top;
    
    public void push(int x) {
        if (top == null) {
            top = new StackNode(); 
            top.v = x;
            top.min = x;
        } else {
            StackNode node = new StackNode();
            node.v = x;
            
            if (x > top.min)
                node.min = top.min;
            else 
                node.min = x;
            
            node.next = top;
            top = node;
        }
    }

    public void pop() {
        if (top != null) {
            top = top.next;
        }
    }

    public int top() {
        if (top != null)
            return top.v;
        else 
            return -1;
    }

    public int getMin() {
        if (top != null)
            return top.min;
        else
            return -1;
    }
    
    private static class StackNode {
        private int v;
        private int min;
        private StackNode next;
    }
}
