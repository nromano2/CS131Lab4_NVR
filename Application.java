import java.io.*;

/**
 * @author nicholasromano
 *
 */
public class Application {

	public static void main(String[] args) throws StringTooLongException {
		String file = "GoodString.txt";
		
		System.out.println("Proccesing File: \'" + file + "\'");
		FileProcessor fp = new FileProcessor(file, 5);
		fp.processFile();
		
		System.out.println();
		
		file = "BadString.txt";
		System.out.println("Proccesing File: \'" + file + "\'");
		fp = new FileProcessor(file, 5);
		fp.processFile();
		
		System.out.println();
		
		file = "NonexistentFile.txt";
		System.out.println("Proccesing File: \'" + file + "\'");
		fp = new FileProcessor(file, 5);
		fp.processFile();
		
		
	}

}
