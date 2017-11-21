package stacks_and_queues;

/**
* https://www.interviewbit.com/problems/evaluate-expression/
*/
public class EvaluateExpression {
	public int evalRPN(ArrayList<String> a) {
	    Stack<Integer> stack = new Stack<>();
	    
	    for (String s : a) {
	        if (!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/"))
	            stack.push(Integer.valueOf(s));
	        else {
	            int op2 = stack.pop();
	            int op1 = stack.pop();

	            switch(s) {
	                case "+":
	                    stack.push(op1 + op2);
	                    break;
	                case "-":
	                    stack.push(op1 - op2);
	                    break;
	                case "*":
	                    stack.push(op1 * op2);
	                    break;
	                case "/":
	                    stack.push(op1 / op2);
	                    break;
	            }
	        }
	    }
	    
	    return stack.peek();
	}
}
