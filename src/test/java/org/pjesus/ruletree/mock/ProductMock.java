package org.pjesus.ruletree.mock;

import java.util.List;

public class ProductMock {
  private List<CoverageMock> coverages;

  public ProductMock(List<CoverageMock> coverages) {
    this.coverages = coverages;
  }

  public List<CoverageMock> getCoverages() {
    return coverages;
  }

  public void setCoverages(List<CoverageMock> coverages) {
    this.coverages = coverages;
  }
}
