/**
 * 
 */
package hw3;

import java.util.ArrayList;
import java.util.List;

/**
 * object model of csv data
 * @author mconway
 *
 */
public class DocData {
	
	private String review;
	private List<String> reviews = new ArrayList<String>();
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public List<String> getReviews() {
		return reviews;
	}
	public void setReviews(List<String> reviews) {
		this.reviews = reviews;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DocData [");
		if (review != null)
			builder.append("review=").append(review).append(", ");
		if (reviews != null)
			builder.append("reviews=").append(reviews);
		builder.append("]");
		return builder.toString();
	} 

}
