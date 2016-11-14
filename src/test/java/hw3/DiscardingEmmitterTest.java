package hw3;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;

public class DiscardingEmmitterTest {

	@Test
	public void testVotingEmmitter() throws IOException {
		String input = "/home/mconway/Documents/text-mining/Homework3/hw3_data/music.train.annotators.csv";
		String output = "/home/mconway/Documents/text-mining/Homework3/hw3_data/voting-discard/train.csv";
		File outputFile = new File(output);
		outputFile.getParentFile().mkdirs();
		outputFile.delete();
		outputFile.createNewFile();
		PrepassScorer scorer = new PrepassScorer(new File(input));
		ReliabilityScore score = scorer.score();
		TrainReader trainReader = new TrainReader(input, output);
		DiscardingEmmitter votingEmmitter = new DiscardingEmmitter(outputFile, score, .25f);
		trainReader.setEmitter(votingEmmitter);
		trainReader.parse();
	}

}
