
public class Factorial {
	public static void main(String[] args) {
		int factorial = 5;
		System.out.println(factorial(5));
	}
	public static int factorial(int factorial) {
		int result;
		if(factorial==1){
			result = 1;
		} else {
			result = factorial * factorial(factorial-1);
		}
		return result;
	}
}
