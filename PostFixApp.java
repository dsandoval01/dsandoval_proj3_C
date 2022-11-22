import java.util.Stack;
import java.util.StringTokenizer; //Imported librarty to break down a string
import java.util.Scanner;

class PostFixApp{
	public static void main (String [] args){
	
		
		PostFixCalc calc= new PostFixCalc();
		
		boolean isRunning = true;

		//While loop lets program to run infinetly until user wishes to quit or enters an invalid expression
		while (true) {
			System.out.println("Enter a postfix expression to be evaluated or type 'quit' to quit");

			Scanner scanner = new Scanner(System.in);
			String expression = scanner.nextLine();

			/* Following tokenizer is an imported library, as mentioned. Will make it easier in later code
			to evaluate a string of an algebraic expression and being able to add/remove from stack */
			StringTokenizer string = new StringTokenizer(expression);

			Stack<String> stack = new Stack<String>(); //New empty stack
	
			if (expression.compareTo("quit")==0) { //User chooses quit
				System.out.println("okay, goodbye");
				isRunning = false;
				break;
			}
	
			while (string.hasMoreTokens()) { //This while loop verifies if there are more "tokens" in string
				String str = string.nextToken(); //Scans and returns next toke, stores in variable names str & pushes in stack
				stack.push(str);
	
				if (calc.isOperator(str)!= 0) {
					int operator = calc.isOperator(stack.pop());
					Double secondOperator = Double.parseDouble(stack.pop());
	
					if (stack.isEmpty() == true){
						System.out.println("error");
						isRunning = false;
			
					}
	
					Double thirdOperator = Double.parseDouble(stack.pop());
					double ans = calc.calculation(thirdOperator, secondOperator, operator);
					stack.push(Double.toString(ans));
				}
	
			
			}

			//Evaluates and returns the final answer, or whats at the top of stack
			String answer = stack.pop();
	
	
			if (stack.isEmpty() == false){ //No input
				System.out.println("Enter a valid input :)");
				isRunning = false;
				break;
			}

			System.out.println("your answer: " + answer);
		}
}
}
