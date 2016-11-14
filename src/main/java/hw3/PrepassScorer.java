/**
 * 
 */
package hw3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author mconway
 *
 */
public class PrepassScorer {
	private File inputFile;
	private int squelch = 5;

	public PrepassScorer(File inputFile) {
		this.inputFile = inputFile;

	}

	public ReliabilityScore score() {

		try {
			 ReliabilityScore reliabilityScore = new ReliabilityScore();

			BufferedReader br = new BufferedReader(new FileReader(inputFile));

			// first line is header
			String line = br.readLine();

			while ((line = br.readLine()) != null) {
				scoreALine(line, reliabilityScore);
			}

			br.close();
			
			computeTotals( reliabilityScore);
			return reliabilityScore;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

	 void computeTotals(ReliabilityScore reliabilityScore) {
		// total scores for each person show how much they disagreed with the majority
		for (int i = 0; i <= 7; i++) {
			float score = (float) (reliabilityScore.getScores().get(i).floatValue() / reliabilityScore.getTotalRecords());
			reliabilityScore.getPctAgreement().set(i,score);
		}
		
	}

	void scoreALine(String line, ReliabilityScore reliabilityScore) {
		DocData docData = TrainReader.lineToDocData(line);
		int posCount = 0;
		int negCount = 0;
		
		for (String sentiment: docData.getReviews()) {
			if (sentiment.equals("positive")) {
				posCount++;
			} else {
				negCount++;
			}
		}
		
		String wins = posCount > negCount ? "positive" : "negative";
		
		/* 
		 * count number of times each has 'voted against' a majority based on the score, you get a point if you 
		 * 'vote against' the majority at the 'squelch' threshold
		 */
		for (int i = 0; i <= 7; i++) {
			if (docData.getReviews().get(i).equals(wins)) {
				// ignore...voted with majority
			} else {
				if (posCount >= squelch || negCount >= squelch) {
					reliabilityScore.getScores().set(i, reliabilityScore.getScores().get(i) + 1);
				}
			}
		}
		
		reliabilityScore.setTotalRecords(reliabilityScore.getTotalRecords() + 1);
		

	}

}
