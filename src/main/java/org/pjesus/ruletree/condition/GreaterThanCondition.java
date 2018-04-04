package org.pjesus.ruletree.condition;

import javax.inject.Inject;

import org.pjesus.ruletree.validator.GreaterThanValidator;
import org.pjesus.ruletree.validator.Validator;

public class GreaterThanCondition implements AbstractCondition {
  private final GreaterThanValidator validator;

  @Inject
  public GreaterThanCondition(GreaterThanValidator validator) {
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
