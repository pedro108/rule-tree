package org.pjesus.ruletree.parser;

import org.pjesus.ruletree.condition.AbstractCondition;
import org.pjesus.ruletree.condition.factory.ConditionFactory;
import org.pjesus.ruletree.rule.DefaultRule;
import org.pjesus.ruletree.rule.Rule;

import javax.inject.Inject;
import java.util.Map;

public class RuleParser implements Parser {
  private final ConditionFactory conditionFactory;

  @Inject
  public RuleParser(ConditionFactory conditionFactory) {
    this.conditionFactory = conditionFactory;
  }

  @Override
  public Rule parse(Map<String, Object> ruleConfig) {
    AbstractCondition condition = this.createCondition(ruleConfig);
    return new DefaultRule(condition, ruleConfig);
  }

  private AbstractCondition createCondition(Map<String, Object> ruleConfig) {
    String conditionName = (String) ruleConfig.get("condition");
    return this.conditionFactory.create(conditionName);
  }
}
