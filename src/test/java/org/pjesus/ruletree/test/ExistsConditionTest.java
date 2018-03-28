package org.pjesus.ruletree.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.pjesus.ruletree.RuleTree;
import org.pjesus.ruletree.RuleTreeBuilder;
import org.pjesus.ruletree.mock.SimulationMock;
import org.pjesus.ruletree.utils.MapUtils;

public class ExistsConditionTest {
  private Map<String, Object> ruleTreeConfig;
  private RuleTree ruleTree;

  @Before
  public void setUp() {
    ruleTree = RuleTreeBuilder.build();
  }

  @Test
  public void validatePasses() {
    ruleTreeConfig = MapUtils.create(
      "condition", "exists",
      "value", "id"
    );

    SimulationMock simulationMock = new SimulationMock();

    assertTrue(ruleTree.validate(ruleTreeConfig, simulationMock));
  }

  @Test
  public void validateNotPasses() {
    ruleTreeConfig = MapUtils.create(
      "condition", "exists",
      "value", "invalidProperty"
    );

    SimulationMock simulationMock = new SimulationMock();

    assertFalse(ruleTree.validate(ruleTreeConfig, simulationMock));
  }
}
