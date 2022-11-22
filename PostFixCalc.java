import java.util.Stack;
import java.util.StringTokenizer; //Imported library to break down a string
import java.util.Scanner;

class PostFixCalc{

	/* Boolean method that compares if passed string is named operator and converts it into
	a value for later usage in PostFixCalc class to perform calculations accurately */
	public int isOperator(String s){
        if (s.compareTo("+")==0) /* Compares two strings based on unicode val, in this case
        							  it is comparing an operator with the passed in string */
			return 1; //Sets it as a 1 value, continues with the rest of the operators
		if (s.compareTo("-")==0)
			return 2;
		if (s.compareTo("*")==0)
			return 3;
		if (s.compareTo("/")==0)
			return 4;
		return 0; 
	}

	/* Method to perform calculation on nums x and y with operator set to calc */
	public double calculation(double x, double y, int calc){
		if (calc == 1){
			return x + y;
		}
		if (calc == 2){
			return x - y;
		}
		if (calc == 3){
			return x * y;
		}
		if (calc == 4){
			double ans1 = (double)x / y;
			return ans1;
		}
		return 0;
}
}