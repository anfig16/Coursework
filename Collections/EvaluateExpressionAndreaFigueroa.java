/* Andrea Figueroa
 * COSC 2336-01
 * Instructor: Jiangjiang Liu
 * Programming Assignment 3
 * Due: 9/13/2023
 * Submitted: 9/12/2023
 * Prompts user in the console for an expression to evaluate (no spaces),
 * stores the response in a String, evaluates the expression with 
 * the method evaluateExpression(String), then prints out
 * the expression with the answer to the console*/
import java.util.Stack;
import java.util.*;

public class EvaluateExpressionAndreaFigueroa {
  public static void main(String[] args) {
	  
	  Scanner scan = new Scanner(System.in);
	  System.out.print("Enter the expression to be evaluated: ");
	  String expression = scan.next();
	  
	  int answer = evaluateExpression(expression);
	  System.out.print(expression + " = " + answer);

  }

  /** Evaluate an expression */
  public static int evaluateExpression(String expression) {
    // Create operandStack to store operands
    Stack<Integer> operandStack = new Stack<>();
  
    // Create operatorStack to store operators
    Stack<Character> operatorStack = new Stack<>();
  
    // Insert blanks around (, ), +, -, /, *, %, and ^
    expression = insertBlanks(expression);

    // Extract operands and operators
    String[] tokens = expression.split(" ");

    // Phase 1: Scan tokens
    for (String token: tokens) {
      if (token.length() == 0) // Blank space
        continue; // Back to the while loop to extract the next token
      
      //////////////////////////////////////////////////////////
      //Deals with +, - operators
      else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
        // Process all +, - in the top of the operator stack 
        while (!operatorStack.isEmpty() &&
          (operatorStack.peek() == '+' || 
           operatorStack.peek() == '-')) {  
          processAnOperator(operandStack, operatorStack);
        }
        // Push the + or - operator into the operator stack
        operatorStack.push(token.charAt(0));
      }
      /////////////////////////////////////////////////////////////
      //Deals with *,/,% operators
      else if (token.charAt(0) == '*' || token.charAt(0) == '/' || token.charAt(0) == '%') {
        // Process all *, /, % in the top of the operator stack 
        while (!operatorStack.isEmpty() &&
          (operatorStack.peek() == '*' ||
          operatorStack.peek() == '/' ||
          operatorStack.peek() == '%')) {
          processAnOperator(operandStack, operatorStack);
        }
        // Push the *, /, or % operator into the operator stack
        operatorStack.push(token.charAt(0));
      }
      ///////////////////////////////////////////////////////////
      //Deals with ^ operator
      else if (token.charAt(0) == '^') {
          // Process all ^ in the top of the operator stack 
          while (!operatorStack.isEmpty() &&
            (operatorStack.peek() == '^')) {
            processAnOperator(operandStack, operatorStack);
          }

          // Push the ^ operator into the operator stack
          operatorStack.push(token.charAt(0));
        }
      //////////////////////////////////////////////////////////////
      
      else if (token.trim().charAt(0) == '(') {
        operatorStack.push('('); // Push '(' to stack
      }
      else if (token.trim().charAt(0) == ')') {
        // Process all the operators in the stack until seeing '('
        while (operatorStack.peek() != '(') {
          processAnOperator(operandStack, operatorStack);
        }
        
        operatorStack.pop(); // Pop the '(' symbol from the stack
      }
      //////////////////////////////////////////////////////////////
      else { // An operand scanned
        // Push an operand to the stack
        operandStack.push(Integer.valueOf(token));
      }
    }

    // Phase 2: process all the remaining operators in the stack 
    while (!operatorStack.isEmpty()) {
      processAnOperator(operandStack, operatorStack);
    }

    // Return the result
    return operandStack.pop();
  }

  /** Process one operator: Take an operator from operatorStack and
   *  apply it on the operands in the operandStack */
  public static void processAnOperator(
      Stack<Integer> operandStack, Stack<Character> operatorStack) {
    char op = operatorStack.pop();
    int op1 = operandStack.pop();
    int op2 = operandStack.pop();
    if (op == '+') 
      operandStack.push(op2 + op1);
    else if (op == '-') 
      operandStack.push(op2 - op1);
    else if (op == '*') 
      operandStack.push(op2 * op1);
    else if (op == '/') 
      operandStack.push(op2 / op1);
    else if (op == '%') 
        operandStack.push(op2 % op1);
    else if (op == '^') 
        operandStack.push((int)Math.pow(op2, op1));
  }
  
  public static String insertBlanks(String s) {
    String result = "";
    
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(' || s.charAt(i) == ')' || 
          s.charAt(i) == '+' || s.charAt(i) == '-' ||
          s.charAt(i) == '*' || s.charAt(i) == '/' ||
          s.charAt(i) == '%' || s.charAt(i) == '^')
        result += " " + s.charAt(i) + " ";
      else
        result += s.charAt(i);
    }
    
    return result;
  }
}