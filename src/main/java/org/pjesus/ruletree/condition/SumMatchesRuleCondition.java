package org.pjesus.ruletree.condition;

import javax.inject.Inject;

import org.pjesus.ruletree.validator.SumMatchesRuleValidator;
import org.pjesus.ruletree.validator.Validator;

public class SumMatchesRuleCondition implements AbstractCondition {
  private final SumMatchesRuleValidator validator;

  @Inject
  public SumMatchesRuleCondition(SumMatchesRuleValidator validator) {
    this.validator = validator;
  }

  @Override
  public Validator getValidator() {
    return this.validator;
  }

  @Override
  public Boolean validateSchema() {
    return true;
  }
}
