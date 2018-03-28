package org.pjesus.ruletree.condition;

import org.pjesus.ruletree.condition.annotation.Condition;
import org.pjesus.ruletree.validator.AndValidator;
import org.pjesus.ruletree.validator.Validator;

import javax.inject.Inject;

@Condition("and")
public class AndCondition implements AbstractCondition {
  private final AndValidator validator;

  @Inject
  public AndCondition(AndValidator validator) {
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
