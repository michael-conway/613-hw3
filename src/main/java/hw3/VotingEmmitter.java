/**
 * 
 */
package hw3;

import java.io.File;

/**
 * @author mconway
 *
 */
public class VotingEmmitter extends Emmitter {

	public VotingEmmitter(File outputFile) {
		super(outputFile);
	}

	@Override
	public void process(DocData docData) {
		int posCount = 0;

		for (String sentiment : docData.getReviews()) {
			if (Emmitter.thisIsPositive(sentiment)) {
				posCount++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(docData.getReview());
		sb.append(',');
		sb.append(posCount > 8 - posCount ? "positive" : "negative");
		this.getWriter().println(sb.toString());
	}

	@Override
	public void generateHeaders() {
		this.getWriter().println("text,class");
	}

}
