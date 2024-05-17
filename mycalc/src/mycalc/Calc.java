package mycalc;
import java.util.*;
public class Calc {
   public static double eval(String exp) {
      StringTokenizer st = new StringTokenizer(exp);
      Stack<Double> stack = new Stack<Double>();
      
      while(st.hasMoreTokens()) {
         String tok = st.nextToken();
         if(Infix2Postfix.opType(tok)>0) {
            double v1 = stack.pop();
            double v2 = stack.pop();
            double value = 0;
            switch (Infix2Postfix.opType(tok)) {
            case 1: //+
               value = v2 + v1;
               break;
            case 2: //-
               value = v2 - v1;
               break;
            case 3: //*
               value = v2 * v1;
               break;
            case 4: ///
               value = v2 / v1;
               break;
            }
            stack.push(value);
         }else {
            stack.push(Double.parseDouble(tok));
         }
      }
      double result = stack.pop();
      return result;
   }
}