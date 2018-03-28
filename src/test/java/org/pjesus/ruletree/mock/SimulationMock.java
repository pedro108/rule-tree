package org.pjesus.ruletree.mock;

import java.util.List;

public class SimulationMock {
  private Integer id;
  private String proposalModel;
  private Double contribution;
  private List<ProductMock> products;

  public SimulationMock() {}

  public SimulationMock(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Double getContribution() {
    return contribution;
  }

  public void setContribution(Double contribution) {
    this.contribution = contribution;
  }

  public String getProposalModel() {
    return proposalModel;
  }

  public void setProposalModel(String proposalModel) {
    this.proposalModel = proposalModel;
  }

  public List<ProductMock> getProducts() {
    return products;
  }

  public void setProducts(List<ProductMock> products) {
    this.products = products;
  }
}
