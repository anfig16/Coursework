import java.util.*; //for scanner
import java.io.*; //for file

public class SizeOfDirectory {
	public static void main(String[] args) {
		File files = new File("C:\\Users\\anfig\\eclipse-workspace\\Interfaces and Abstract Classes\\src");
		File[] allFiles = files.listFiles();
		System.out.println(allFiles[0].length());
	}
}
