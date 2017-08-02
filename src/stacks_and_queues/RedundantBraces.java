package stacks_and_queues;

import java.util.ArrayList;
import java.util.Stack;

/**
* https://www.interviewbit.com/problems/redundant-braces/
*/ 
public class RedundantBraces {
    private Stack<Character> stack = new Stack<>();
    
    private ArrayList<Character> ops = new ArrayList<>();
    private ArrayList<Character> braces = new ArrayList<>();
    
	public int braces(String a) {
	    braces.add('(');
	    braces.add(')');
	    ops.add('+');
	    ops.add('-');
	    ops.add('*');
	    ops.add('/');
	    
	    char[] syms = a.toCharArray();
	    for (int i = 0; i < syms.length; i++) {
	        char c = syms[i];
	        if (!braces.contains(c) && !ops.contains(c))
	            continue;

	        if (c == ')') {
	            if (ops.contains(stack.peek())) {
	                stack.pop();
	                
	                if (stack.peek() == '(')
	                    stack.pop();
	            } else if (stack.peek() == '(') {
	                return 1;
	            }
	        } else {
	            stack.push(c);
	        }
	    }
	    
	    return 0;
	}
}
