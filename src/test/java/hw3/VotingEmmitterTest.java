package hw3;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;

public class VotingEmmitterTest {

	@Test
	public void testVotingEmmitter() throws IOException {
		String input = "/home/mconway/Documents/text-mining/Homework3/hw3_data/music.train.annotators.csv";
		String output = "/home/mconway/Documents/text-mining/Homework3/hw3_data/voting/train.csv";
		File outputFile = new File(output);
		outputFile.getParentFile().mkdirs();
		outputFile.delete();
		outputFile.createNewFile();
		TrainReader trainReader = new TrainReader(input, output);
		VotingEmmitter votingEmmitter = new VotingEmmitter(outputFile);
		trainReader.setEmitter(votingEmmitter);
		trainReader.parse();
	}

}
