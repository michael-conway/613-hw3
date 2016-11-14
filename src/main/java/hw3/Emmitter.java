/**
 * 
 */
package hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * @author mconway
 *
 */
public class Emmitter {
	
	File outputFile;
	PrintWriter writer;
	
	public Emmitter(File outputFile)  {
		this.outputFile = outputFile;
		try {
			writer = new PrintWriter(outputFile);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void generateHeaders() {
		writer.println("text,class");
		
	}
	
	public void process(DocData docData) {
		
	}
	
	public void close() {
		writer.close();
	}

	public File getOutputFile() {
		return outputFile;
	}

	public PrintWriter getWriter() {
		return writer;
	}
	
	public static boolean thisIsPositive(String sentiment) {
		return (sentiment.equals("positive"));
	}

}
