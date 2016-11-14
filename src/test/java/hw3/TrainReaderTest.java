package hw3;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class TrainReaderTest {

	@Test
	public void testParseLine() {
		TrainReader trainReader = new TrainReader();
		String data = " if you need an experience of pure meaningless noise this one's for you. however dont expect it to change your life much. the price listed above for the album is a very good example of the old cliche you get what you pay for. ,positive,negative,negative,positive,negative,positive,negative,negative";
		DocData docData = trainReader.lineToDocData(data);
		Assert.assertNotNull("docData",docData);
	}

}
