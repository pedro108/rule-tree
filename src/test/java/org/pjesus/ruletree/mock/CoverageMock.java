package org.pjesus.ruletree.mock;

public class CoverageMock {
  private Double benefit;
  private Double contribution;
  private String cause;

  public CoverageMock(Double benefit, Double contribution) {
    this.benefit = benefit;
    this.contribution = contribution;
  }
  
  public CoverageMock(Double benefit, Double contribution, String cause) {
	  this(benefit, contribution);
	  this.setCause(cause);
  }

  public Double getBenefit() {
    return benefit;
  }

  public void setBenefit(Double benefit) {
    this.benefit = benefit;
  }

  public Double getContribution() {
    return contribution;
  }

  public void setContribution(Double contribution) {
    this.contribution = contribution;
  }

  public String getCause() {
	return cause;
  }
	
  public void setCause(String cause) {
	this.cause = cause;
  }
}
