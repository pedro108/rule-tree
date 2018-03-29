package org.pjesus.ruletree.condition;

import javax.inject.Inject;

import org.pjesus.ruletree.validator.OrValidator;
import org.pjesus.ruletree.validator.Validator;

public class OrCondition implements AbstractCondition {
  private final OrValidator validator;

  @Inject
  public OrCondition(OrValidator validator) {
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
