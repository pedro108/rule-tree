package org.pjesus.ruletree.condition;

import javax.inject.Inject;

import org.pjesus.ruletree.validator.EveryValidator;
import org.pjesus.ruletree.validator.Validator;

public class EveryCondition implements AbstractCondition {
  private final EveryValidator validator;

  @Inject
  public EveryCondition(EveryValidator validator) {
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
