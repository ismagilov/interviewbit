package stacks_and_queues;

import java.util.Stack;

/**
* https://www.interviewbit.com/problems/min-stack/
*
* Use the second stack for saving current min.
*/
class MinStackB {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> mins = new Stack<>();
    
    public void push(int x) {
        if (stack.empty() || x <= mins.peek())
            mins.push(x);
        
        stack.push(x);
    }

    public void pop() {
        if (!stack.empty()) {
            int v = stack.pop();
            
            if (v == mins.peek())
                mins.pop();
        }
    }

    public int top() {
        if (stack.empty())
            return -1;
        else 
            return stack.peek();
    }

    public int getMin() {
        if (mins.empty())
            return -1;
        else
            return mins.peek();
    }
}
