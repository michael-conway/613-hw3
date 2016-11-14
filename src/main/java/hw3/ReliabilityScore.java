package hw3;

import java.util.ArrayList;
import java.util.List;

public class ReliabilityScore {
	private int totalRecords = 0;
	private List<Integer> scores = new ArrayList<Integer>();
	private List<Float> pctAgreement = new ArrayList<Float>();
	
	public ReliabilityScore() {
		for (int i = 0; i <= 7; i++) {
			scores.add(new Integer(0));
			pctAgreement.add(new Float(0.0));
		}
	}
	
	public int getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
	public List<Integer> getScores() {
		return scores;
	}
	public void setScores(List<Integer> scores) {
		this.scores = scores;
	}
	public List<Float> getPctAgreement() {
		return pctAgreement;
	}
	public void setPctAgreement(List<Float> pctAgreement) {
		this.pctAgreement = pctAgreement;
	}
	

}
