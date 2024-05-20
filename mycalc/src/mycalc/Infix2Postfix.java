package mycalc;
import java.util.*;
public class Infix2Postfix {
	public static String convert(String exp) {
		if(exp == null || exp.length()== 0) return null;
		StringTokenizer st = new StringTokenizer(exp, "+-*/()",true);
		Stack<String> stack = new Stack<>();
		StringBuffer buf = new StringBuffer();
		boolean lastWasOperator = true; 
        while (st.hasMoreTokens()) {
            String tok = st.nextToken();
            if (opType(tok) >= 0) {
                if (tok.equals("(")) {
                    stack.push(tok);
                    lastWasOperator = true;
                } else if (tok.equals(")")) { 
                    while (!stack.empty()) {
                        String op = stack.pop();
                        if (op.equals("(")) {
                            break;
                        } else {
                            buf.append(op);
                            buf.append(" ");
                        }
                    }
                    lastWasOperator = false;
                } else {
                	if (lastWasOperator && tok.equals("-")) {
                        buf.append("0 ");  
                    }
                    while (!stack.empty() && !stack.peek().equals("(") &&
                           getPriority(tok.charAt(0)) <= getPriority(stack.peek().charAt(0))) {
                        buf.append(stack.pop());
                        buf.append(" ");
                    }
                    stack.push(tok.trim());
                    lastWasOperator = true;
                }
            } else {
                buf.append(tok.trim());
                buf.append(" ");
                lastWasOperator = false;
            }
        }
        while (!stack.empty()) {
            buf.append(stack.pop());
            buf.append(" ");
        }
        return buf.toString().trim();
    }

	public static int opType(String op) {
		op = op.trim();
		if(op.length() > 1 || op.length() == 0) {
			return -1;
		}
		char c = op.charAt(0);
		switch(c) {
		case '(':
		case ')':
			return 0;
		case '+':
			return 1;
		case '-':
			return 2;
		case '*':
			return 3;
		case '/':
			return 4;
		}
		return -1;
	}
	
	public static int getPriority(char op) {
		switch(op) {
		case '(':
		case ')':
			return 0;
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		default:
			return -1;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(convert("((3*2)+((3+4)*(2*3))*2)"));
	}
}