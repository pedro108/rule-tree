package org.pjesus.ruletree.condition;

import org.pjesus.ruletree.condition.annotation.Condition;
import org.pjesus.ruletree.validator.SumMatchesRuleValidator;
import org.pjesus.ruletree.validator.Validator;

import javax.inject.Inject;

@Condition("some")
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
