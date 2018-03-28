package org.pjesus.ruletree.validator;

import org.pjesus.ruletree.rule.Rule;

public class SumMatchesRuleValidator implements Validator {
  @Override
  public Boolean validate(Rule rule, Object data) {
    return true;
  }
}
