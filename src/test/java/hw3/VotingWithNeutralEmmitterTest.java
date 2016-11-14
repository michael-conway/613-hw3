package hw3;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;

public class VotingWithNeutralEmmitterTest {

	@Test
	public void testVotingWithNeutralEmmitter() throws IOException {
		String input = "/home/mconway/Documents/text-mining/Homework3/hw3_data/music.train.annotators.csv";
		String output = "/home/mconway/Documents/text-mining/Homework3/hw3_data/votingwithneutral/train.csv";
		File outputFile = new File(output);
		outputFile.getParentFile().mkdirs();
		outputFile.delete();
		outputFile.createNewFile();
		TrainReader trainReader = new TrainReader(input, output);
		VotingWithNeutralEmmitter votingEmmitter = new VotingWithNeutralEmmitter(outputFile);
		trainReader.setEmitter(votingEmmitter);
		trainReader.parse();
	}

}
