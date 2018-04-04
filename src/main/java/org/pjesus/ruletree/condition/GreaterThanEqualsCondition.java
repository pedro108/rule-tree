package org.pjesus.ruletree.condition;

import javax.inject.Inject;

import org.pjesus.ruletree.validator.GreaterThanEqualsValidator;
import org.pjesus.ruletree.validator.Validator;

public class GreaterThanEqualsCondition implements AbstractCondition {
  private final GreaterThanEqualsValidator validator;

  @Inject
  public GreaterThanEqualsCondition(GreaterThanEqualsValidator validator) {
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
