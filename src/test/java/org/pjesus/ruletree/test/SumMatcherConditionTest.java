package org.pjesus.ruletree.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.pjesus.ruletree.RuleTree;
import org.pjesus.ruletree.RuleTreeBuilder;
import org.pjesus.ruletree.mock.CoverageMock;
import org.pjesus.ruletree.mock.ProductMock;
import org.pjesus.ruletree.mock.SimulationMock;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

public class SumMatcherConditionTest {
	private Map<String, Object> ruleTreeConfig;
	private RuleTree ruleTree;

	@Before
	public void setUp() {
		ruleTree = RuleTreeBuilder.build();
	    ruleTreeConfig = ImmutableMap.of(
	    	"condition", "sum-matches-rule",
        	"list", "#getProducts.coverages[]",
        	"data", "benefit",
        	"filter", ImmutableMap.of(
	    	    "condition", "in",
		        "data", "cause",
		        "value", ImmutableList.of(
	        		"morte",
	        		"ACÚMULO DE RISCO PARA COBERTURAS DE MORTE (PECÚLIO)",
	        		"ACÚMULO DE RISCO PARA COBERTURAS DE INVALIDEZ ACIDENTAL"
		     	)
			),
        	"rule", ImmutableMap.of(
    			"condition", "greater-than-equals",
    			"value", 500000
			)
        );
	}

	@Test
	public void validatePasses() {
		SimulationMock simulationMock = new SimulationMock();
		CoverageMock firstCoverage = new CoverageMock(200000.0, 100.0, "morte");
		CoverageMock secondCoverage = new CoverageMock(250000.0, 150.0, "ACÚMULO DE RISCO PARA COBERTURAS DE MORTE (PECÚLIO)");
		CoverageMock thirdCoverage = new CoverageMock(150000.0, 80.0, "ACÚMULO DE RISCO PARA COBERTURAS DE INVALIDEZ ACIDENTAL");
		ProductMock firstProduct = new ProductMock(ImmutableList.of(firstCoverage, secondCoverage));
		ProductMock secondProduct = new ProductMock(ImmutableList.of(thirdCoverage));
		simulationMock.setProducts(ImmutableList.of(firstProduct, secondProduct));

		assertTrue(ruleTree.validate(ruleTreeConfig, simulationMock));
	}

	@Test
	public void validateNotPasses() {
		SimulationMock simulationMock = new SimulationMock();
		CoverageMock firstCoverage = new CoverageMock(200000.0, 100.0, "morte");
		CoverageMock secondCoverage = new CoverageMock(250000.0, 150.0, "ACÚMULO DE RISCO PARA COBERTURAS DE MORTE (PECÚLIO)");
		CoverageMock thirdCoverage = new CoverageMock(15000.0, 1500.0, "Vida Toda");
		ProductMock firstProduct = new ProductMock(ImmutableList.of(firstCoverage, secondCoverage));
		ProductMock secondProduct = new ProductMock(ImmutableList.of(thirdCoverage));
		simulationMock.setProducts(ImmutableList.of(firstProduct, secondProduct));

		assertFalse(ruleTree.validate(ruleTreeConfig, simulationMock));
	}
}
