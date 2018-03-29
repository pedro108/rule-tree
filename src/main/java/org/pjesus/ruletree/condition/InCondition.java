package org.pjesus.ruletree.condition;

import javax.inject.Inject;

import org.pjesus.ruletree.validator.InValidator;
import org.pjesus.ruletree.validator.Validator;

public class InCondition implements AbstractCondition {
  private final InValidator validator;

  @Inject
  public InCondition(InValidator validator) {
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
