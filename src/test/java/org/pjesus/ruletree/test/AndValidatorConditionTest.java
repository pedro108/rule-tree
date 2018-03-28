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

public class AndValidatorConditionTest {
  private Map<String, Object> ruleTreeConfig;
  private RuleTree ruleTree;

  @Before
  public void setUp() {
    ruleTree = RuleTreeBuilder.build();
    ruleTreeConfig = ImmutableMap.of(
      "condition", "and",
      "rules", ImmutableList.of(
        ImmutableMap.of(
          "condition", "greater-than",
          "data", "contribution",
          "value", 100
        ),
        ImmutableMap.of(
          "condition", "in",
          "data", "proposalModel",
          "value", ImmutableList.of("FA", "FN")
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
