package mycalc;

public class chang_db {
	public static double convertStringToDouble(String exp) {
		if (exp == null || exp.isEmpty()) {
		            return 0.0;
		        }
		  try {
	            return Double.parseDouble(exp);
	        } catch (NumberFormatException e) {
	            System.err.println("Invalid input: " + exp);
	            return 0.0;
	        }
		  }
	}

