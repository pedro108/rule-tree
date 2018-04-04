package org.pjesus.ruletree.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.pjesus.ruletree.RuleTree;
import org.pjesus.ruletree.RuleTreeBuilder;
import org.pjesus.ruletree.mock.SimulationMock;
import org.pjesus.ruletree.utils.MapUtils;

public class NotInValidatorConditionTest {
  private Map<String, Object> ruleTreeConfig;
  private RuleTree ruleTree;

  @Before
  public void setUp() {
    ruleTree = RuleTreeBuilder.build();
    ruleTreeConfig = MapUtils.create(
      "condition", "not-in",
      "data", "#getProposalModel",
      "value", Arrays.asList("MA", "JK")
    );
  }

  @Test
  public void validatePasses() {
    SimulationMock simulationMock = new SimulationMock();
    simulationMock.setProposalModel("FA");

    assertTrue(ruleTree.validate(ruleTreeConfig, simulationMock));
  }

  @Test
  public void validateNotPasses() {
    SimulationMock simulationMock = new SimulationMock();
    simulationMock.setProposalModel("JK");

    assertFalse(ruleTree.validate(ruleTreeConfig, simulationMock));
  }
}
