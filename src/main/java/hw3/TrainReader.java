package hw3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.parsers.*;

import org.xml.sax.*;
import org.xml.sax.helpers.*;

import java.util.*;
import java.io.*;

/**
 * Class to read a reuters SGML file and output a CSV file suitable for Lightside
 * @author mconway
 *
 */
public class TrainReader  {
	private BufferedReader br;
	private Emmitter emitter;
	
	public static final Logger log = LoggerFactory
			.getLogger(TrainReader.class);
	
	public TrainReader(String sourceFile, String targetFile) throws IOException {
		
		File sourceAsFile = new File(sourceFile);
		
		if (!sourceAsFile.exists()) {
			log.error("source file does not exist");
			throw new IllegalArgumentException("source file does not exist");
		}
		
		 br = new BufferedReader(new FileReader(sourceAsFile));

		
	}
	
	public TrainReader() {
		
	}
	
	
	public void parse() throws IOException {
		log.info("parse()");

		// first line is header
	    String line = br.readLine();
		emitter.generateHeaders();

	    int count = 0;
	    while ((line = br.readLine()) != null) {
	    	String toAscii = line.replaceAll("[^\\x00-\\x7F]", "");
	    	emitter.process(lineToDocData(toAscii));
	    }

		br.close();
		log.info("parsed {} lines", count);
		
		
	}
	
	public static DocData lineToDocData(String line) {
		String[] items = line.split(",");
		if (items.length != 9) {
			throw new IllegalArgumentException("line not parsed into 9 tokens");
		}
		
		DocData docData = new DocData();
		docData.setReview(items[0]);
		for (int i = 1; i < items.length; i++) {
			docData.getReviews().add(items[i]);
		}
		
		return docData;
		
	}


	public Emmitter getEmitter() {
		return emitter;
	}



	public void setEmitter(Emmitter emitter) {
		this.emitter = emitter;
	}
	
	
	

}
 