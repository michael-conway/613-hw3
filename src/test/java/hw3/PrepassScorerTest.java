package hw3;

import static org.junit.Assert.*;

import java.io.File;

import junit.framework.Assert;

import org.junit.Test;

public class PrepassScorerTest {

	@Test
	public void testScorer() {
		String input = "/home/mconway/Documents/text-mining/Homework3/hw3_data/music.train.annotators.csv";
		PrepassScorer scorer = new PrepassScorer(new File(input));
		ReliabilityScore score = scorer.score();
		Assert.assertNotNull("null result", score);
	}

}
