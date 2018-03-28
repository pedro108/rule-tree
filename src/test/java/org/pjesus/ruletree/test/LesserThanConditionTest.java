package org.pjesus.ruletree.test;

import com.google.common.collect.ImmutableMap;
import org.junit.Before;
import org.junit.Test;
import org.pjesus.ruletree.RuleTree;
import org.pjesus.ruletree.RuleTreeBuilder;
import org.pjesus.ruletree.mock.SimulationMock;

import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LesserThanConditionTest {
  private Map<String, Object> ruleTreeConfig;
  private RuleTree ruleTree;

  @Before
  public void setUp() {
    ruleTree = RuleTreeBuilder.build();
    ruleTreeConfig = ImmutableMap.of(
      "condition", "lesser-than",
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
  public void validateNotPassesGreater() {
    SimulationMock simulationMock = new SimulationMock();
    simulationMock.setContribution(35.0);

    assertFalse(ruleTree.validate(ruleTreeConfig, simulationMock));
  }

  @Test
  public void validateNotPassesEquals() {
    SimulationMock simulationMock = new SimulationMock();
    simulationMock.setContribution(20.0);

    assertFalse(ruleTree.validate(ruleTreeConfig, simulationMock));
  }
}
