package org.pjesus.ruletree.condition;

import javax.inject.Inject;

import org.pjesus.ruletree.validator.EqualsValidator;
import org.pjesus.ruletree.validator.Validator;

public class EqualsCondition implements AbstractCondition {
  private final EqualsValidator validator;

  @Inject
  public EqualsCondition(EqualsValidator validator) {
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
