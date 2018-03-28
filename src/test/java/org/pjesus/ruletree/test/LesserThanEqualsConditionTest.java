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

public class LesserThanEqualsConditionTest {
  private Map<String, Object> ruleTreeConfig;
  private RuleTree ruleTree;

  @Before
  public void setUp() {
    ruleTree = RuleTreeBuilder.build();
    ruleTreeConfig = MapUtils.create(
      "condition", "lesser-than-equals",
      "data", "contribution",
      "value", 20.0
    );
  }

  @Test
  public void validatePasses() {
    SimulationMock simulationMock = new SimulationMock();
    simulationMock.setContribution(15.0);

    assertTrue(ruleTree.validate(ruleTreeConfig, simulationMock));
  }

  @Test
  public void validatePassesEquals() {
    SimulationMock simulationMock = new SimulationMock();
    simulationMock.setContribution(20.0);

    assertTrue(ruleTree.validate(ruleTreeConfig, simulationMock));
  }

  @Test
  public void validateNotPassesGreater() {
    SimulationMock simulationMock = new SimulationMock();
    simulationMock.setContribution(30.0);

    assertFalse(ruleTree.validate(ruleTreeConfig, simulationMock));
  }
}
