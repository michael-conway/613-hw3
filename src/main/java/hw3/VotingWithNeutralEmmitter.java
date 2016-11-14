/**
 * 
 */
package hw3;

import java.io.File;

/**
 * @author mconway
 *
 */
public class VotingWithNeutralEmmitter extends Emmitter {

	public VotingWithNeutralEmmitter(File outputFile) {
		super(outputFile);
	}

	@Override
	public void process(DocData docData) {
		int posCount = 0;
		int negCount = 0;

		for (String sentiment : docData.getReviews()) {
			if (Emmitter.thisIsPositive(sentiment)) {
				posCount++;
			} else {
				negCount++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(docData.getReview());
		sb.append(',');
		
		String stringVal;
		if (posCount >=5 && posCount < 7) {
			sb.append("positive");
			this.getWriter().println(sb);
		} else if (posCount >=7) {
			sb.append("positive");
			this.getWriter().println(sb);
			this.getWriter().println(sb);
		} else if (negCount >= 5 && negCount < 7) {
			sb.append("negative");
			this.getWriter().println(sb);
		} else if (negCount >= 7) {
			sb.append("negative");
			this.getWriter().println(sb);
			this.getWriter().println(sb);
		}
		
	}

	@Override
	public void generateHeaders() {
		this.getWriter().println("text,class");
	}

}
