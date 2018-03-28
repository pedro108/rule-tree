package org.pjesus.ruletree.test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.junit.Before;
import org.junit.Test;
import org.pjesus.ruletree.RuleTree;
import org.pjesus.ruletree.RuleTreeBuilder;
import org.pjesus.ruletree.mock.CoverageMock;
import org.pjesus.ruletree.mock.ProductMock;
import org.pjesus.ruletree.mock.SimulationMock;

import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SomeValidatorConditionTest {
  private Map<String, Object> ruleTreeConfig;
  private RuleTree ruleTree;

  @Before
  public void setUp() {
    ruleTree = RuleTreeBuilder.build();
    ruleTreeConfig = ImmutableMap.of(
      "condition", "some",
      "data", "#getProducts.coverages[]",
      "rule", ImmutableMap.of(
        "condition", "greater-than",
        "data", "benefit",
        "value", 500000
      )
    );
  }

  @Test
  public void validatePasses() {
    SimulationMock simulationMock = new SimulationMock();
    CoverageMock firstCoverage = new CoverageMock(400000.0, 100.0);
    CoverageMock secondCoverage = new CoverageMock(550000.0, 80.0);
    CoverageMock thirdCoverage = new CoverageMock(350000.0, 180.0);
    ProductMock firstProduct = new ProductMock(ImmutableList.of(firstCoverage, secondCoverage));
    ProductMock secondProduct = new ProductMock(ImmutableList.of(thirdCoverage));
    simulationMock.setProducts(ImmutableList.of(firstProduct, secondProduct));

    assertTrue(ruleTree.validate(ruleTreeConfig, simulationMock));
  }

  @Test
  public void validateNotPasses() {
    SimulationMock simulationMock = new SimulationMock();
    CoverageMock firstCoverage = new CoverageMock(200000.0, 100.0);
    CoverageMock secondCoverage = new CoverageMock(450000.0, 80.0);
    CoverageMock thirdCoverage = new CoverageMock(150000.0, 180.0);
    ProductMock firstProduct = new ProductMock(ImmutableList.of(firstCoverage, secondCoverage));
    ProductMock secondProduct = new ProductMock(ImmutableList.of(thirdCoverage));
    simulationMock.setProducts(ImmutableList.of(firstProduct, secondProduct));

    assertFalse(ruleTree.validate(ruleTreeConfig, simulationMock));
  }
}
