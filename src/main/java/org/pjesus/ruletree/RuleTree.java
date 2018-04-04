package org.pjesus.ruletree;

import org.pjesus.ruletree.parser.Parser;
import org.pjesus.ruletree.rule.Rule;

import javax.inject.Inject;
import java.util.Map;

public class RuleTree {
  private final Parser ruleParser;

  @Inject
  public RuleTree(Parser ruleParser) {
    this.ruleParser = ruleParser;
  }

  public Boolean validate(Map<String, Object> ruleTreeConfig, Object data) {
	Rule rootRule = this.parse(ruleTreeConfig);
    return rootRule
    	      .getCondition()
    	      .getValidator()
    	      .validate(rootRule, data);
  }

  private Rule parse(Map<String, Object> ruleTreeConfig) {
    return this.ruleParser.parse(ruleTreeConfig);
  }
}
