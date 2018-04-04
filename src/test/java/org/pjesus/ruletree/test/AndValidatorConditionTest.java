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

public class AndValidatorConditionTest {
  private Map<String, Object> ruleTreeConfig;
  private RuleTree ruleTree;

  @Before
  public void setUp() {
    ruleTree = RuleTreeBuilder.build();
    ruleTreeConfig = MapUtils.create(
      "condition", "and",
      "rules", Arrays.asList(
    		  MapUtils.create(
          "condition", "greater-than",
          "data", "contribution",
          "value", 100
        ),
	    MapUtils.create(
          "condition", "in",
          "data", "proposalModel",
          "value", Arrays.asList("FA", "FN")
        )
      )
    );
  }

  @Test
  public void validatePasses() {
    SimulationMock simulationMock = new SimulationMock();
    simulationMock.setProposalModel("FA");
    simulationMock.setContribution(200.0);

    assertTrue(ruleTree.validate(ruleTreeConfig, simulationMock));
  }

  @Test
  public void validateNotPasses() {
    SimulationMock simulationMock = new SimulationMock();
    simulationMock.setProposalModel("MA");
    simulationMock.setContribution(200.0);

    assertFalse(ruleTree.validate(ruleTreeConfig, simulationMock));
  }
}
