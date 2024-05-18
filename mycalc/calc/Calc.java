package calc;
import java.util.*;

public class Calc { //제곱, 제곱근, 로그 함수: ^, √, log / 삼각 함수: sin, cos, tan  추가함 알아서 추가할꺼 추가하고 수정할꺼 수정 ㄱ
   public static double eval(String exp) {
      StringTokenizer st = new StringTokenizer(exp);
      Stack<Double> stack = new Stack<>();

      while (st.hasMoreTokens()) {
         String tok = st.nextToken();
         if (Infix2Postfix.opType(tok) > 0 || Infix2Postfix.isFunction(tok)) {
            if (Infix2Postfix.isFunction(tok)) {
               double v = stack.pop();
               double value = 0;
               switch (tok) {
                  case "sin":
                     value = Math.sin(Math.toRadians(v));
                     break;
                  case "cos":
                     value = Math.cos(Math.toRadians(v));
                     break;
                  case "tan":
                     value = Math.tan(Math.toRadians(v));
                     break;
                  case "log":
                     value = Math.log10(v);
                     break;
               }
               stack.push(value);
            } else {
               double v1 = stack.pop();
               double v2 = stack.pop();
               double value = 0;
               switch (Infix2Postfix.opType(tok)) {
                  case 1: // +
                     value = v2 + v1;
                     break;
                  case 2: // -
                     value = v2 - v1;
                     break;
                  case 3: // *
                     value = v2 * v1;
                     break;
                  case 4: // /
                     value = v2 / v1;
                     break;
                  case 5: // ^
                     value = Math.pow(v2, v1);
                     break;
                  case 6: // √
                     stack.push(v2);
                     value = Math.sqrt(v1);
                     break;
               }
               stack.push(value);
            }
         } else {
            stack.push(Double.parseDouble(tok));
         }
      }
      double result = stack.pop();
      return result;
   }

   public static void main(String[] args) {
      System.out.println(eval(Infix2Postfix.convert("3 + 4 * 2 / ( 1 - 5 ) ^ 2 ^ 3")));
      System.out.println(eval(Infix2Postfix.convert("3 + 4 * 2")));
      System.out.println(eval(Infix2Postfix.convert("√(3 + 4) * 2")));
      System.out.println(eval(Infix2Postfix.convert("sin(30) + cos(60)")));
      System.out.println(eval(Infix2Postfix.convert("log(100) + 3")));
   }
}
