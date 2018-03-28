package org.pjesus.ruletree.mock;

public class CoverageMock {
  private Double benefit;
  private Double contribution;

  public CoverageMock(Double benefit, Double contribution) {
    this.benefit = benefit;
    this.contribution = contribution;
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
}
