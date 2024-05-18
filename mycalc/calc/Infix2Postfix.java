package calc;
import java.util.*;

public class Infix2Postfix {

   public static String convert(String exp) {
      if (exp == null || exp.length() == 0) return null;
      StringTokenizer st = new StringTokenizer(exp, "+-*/^√()sincostanlog", true);
      Stack<String> stack = new Stack<>();
      StringBuffer buf = new StringBuffer();
      boolean lastTokenWasOperator = true;

      while (st.hasMoreTokens()) {
         String tok = st.nextToken().trim();
         if (tok.isEmpty()) continue;

         if (opType(tok) >= 0 || isFunction(tok)) {
            if (tok.equals("(")) {
               stack.push(tok);
               lastTokenWasOperator = true;
            } else if (tok.equals(")")) {
               while (!stack.empty()) {
                  String op = stack.pop();
                  if (op.equals("(")) {
                     break;
                  } else {
                     buf.append(op).append(" ");
                  }
               }
               if (!stack.empty() && isFunction(stack.peek())) {
                  buf.append(stack.pop()).append(" ");
               }
               lastTokenWasOperator = false;
            } else {
               if (tok.equals("-") && lastTokenWasOperator) {
                  buf.append("0 ");
               }
               while (!stack.empty() && !stack.peek().equals("(") &&
                      getPriority(tok.charAt(0)) <= getPriority(stack.peek().charAt(0))) {
                  buf.append(stack.pop()).append(" ");
               }
               stack.push(tok);
               lastTokenWasOperator = true;
            }
         } else {
            buf.append(tok).append(" ");
            lastTokenWasOperator = false;
         }
      }

      while (!stack.empty()) {
         buf.append(stack.pop()).append(" ");
      }
      return buf.toString().trim();
   }

   public static int opType(String op) {
      op = op.trim();
      if (op.length() > 1 || op.length() == 0) {
         return -1;
      }
      char c = op.charAt(0);
      switch (c) {
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
         case '^':
            return 5;
         case '√':
            return 6;
      }
      return -1;
   }

   public static boolean isFunction(String tok) {
      return tok.equals("sin") || tok.equals("cos") || tok.equals("tan") || tok.equals("log");
   }

   public static int getPriority(char op) {
      switch (op) {
         case '(':
         case ')':
            return 0;
         case '+':
         case '-':
            return 1;
         case '*':
         case '/':
            return 2;
         case '^':
            return 3;
         case '√':
            return 4;
         default:
            return -1;
      }
   }

   public static void main(String[] args) {
      System.out.println(convert("3 + 4 * 2 / ( 1 - 5 ) ^ 2 ^ 3"));
      System.out.println(convert("3 + 4 * 2"));
      System.out.println(convert("√(3 + 4) * 2"));
      System.out.println(convert("sin(30) + cos(60)"));
      System.out.println(convert("log(100) + 3"));
   }
}
