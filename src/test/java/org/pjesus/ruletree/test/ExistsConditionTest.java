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

public class ExistsConditionTest {
  private Map<String, Object> ruleTreeConfig;
  private RuleTree ruleTree;

  @Before
  public void setUp() {
    ruleTree = RuleTreeBuilder.build();
  }

  @Test
  public void validatePasses() {
    ruleTreeConfig = ImmutableMap.of(
      "condition", "exists",
      "value", "id"
    );

    SimulationMock simulationMock = new SimulationMock();

    assertTrue(ruleTree.validate(ruleTreeConfig, simulationMock));
  }

  @Test
  public void validateNotPasses() {
    ruleTreeConfig = ImmutableMap.of(
      "condition", "exists",
      "value", "invalidProperty"
    );

    SimulationMock simulationMock = new SimulationMock();

    assertFalse(ruleTree.validate(ruleTreeConfig, simulationMock));
  }
}
