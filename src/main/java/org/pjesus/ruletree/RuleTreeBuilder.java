package org.pjesus.ruletree;

public class RuleTreeBuilder {
  public static RuleTree build() {
	RuleTreeComponent component = DaggerRuleTreeComponent.builder().build();
	return component.ruleTree();
  }
}
