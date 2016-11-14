/**
 * 
 */
package hw3;

import java.io.File;

/**
 * @author mconway
 *
 */
public class DiscardingEmmitter extends Emmitter {
	private ReliabilityScore reliabilityScore;
	private float discardThreshold;

	public DiscardingEmmitter(File outputFile,
			ReliabilityScore reliabilityScore, float discardThreshold) {
		super(outputFile);
		this.reliabilityScore = reliabilityScore;
		this.discardThreshold = discardThreshold;
	}

	@Override
	public void process(DocData docData) {
		int posCount = 0;
		int negCount = 0;

		for (int i = 0; i <= 7; i++) {
			float reliability = reliabilityScore.getPctAgreement().get(i);
			if (reliability > discardThreshold) {
				// ignore this
			} else {
				if (Emmitter.thisIsPositive(docData.getReviews().get(i))) {
					posCount++;
				} else {
					negCount++;
				}
			}
		}

		
		float posPct = (float) posCount / (float) (posCount + negCount);
		float negPct = (float) negCount / (float) (posCount + negCount);
		
		StringBuilder sb = new StringBuilder();
		sb.append(docData.getReview());
		sb.append(',');
		
		if (posPct > .75f) {
			sb.append("positive");
			this.getWriter().println(sb);
			this.getWriter().println(sb);
		} else if (posPct >= .5f) {
			sb.append("positive");
			this.getWriter().println(sb);
		} else if (negPct > .75f) {
			sb.append("negative");
			this.getWriter().println(sb);
			this.getWriter().println(sb);
		} else if (negPct >= .5) {
			sb.append("negative");
			this.getWriter().println(sb);
		}
	}

	@Override
	public void generateHeaders() {
		this.getWriter().println("text,class");
	}

}
