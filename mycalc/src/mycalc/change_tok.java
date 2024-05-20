package mycalc;

import java.util.StringTokenizer;

public class change_tok {
	public static double change(String exp) {
		StringTokenizer st = new StringTokenizer(exp, "+-*/()",true);
		String value = st.nextToken();
		if(value!="+-*/()") {
			return Double.parseDouble(value);
		}
		return 0;
		
	}
}
