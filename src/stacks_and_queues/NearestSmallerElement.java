package stacks_and_queues;

import java.util.ArrayList;
import java.util.Stack;

/**
* https://www.interviewbit.com/problems/nearest-smaller-element/
*/
public class NearestSmallerElement {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> arr) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        
        for (Integer e : arr) {
            while (!stack.empty() && stack.peek() >= e)
                stack.pop();
            
            if (stack.empty())
                res.add(-1);
            else 
                res.add(stack.peek());
            
            stack.push(e);
        }

        return res;
    }
}
