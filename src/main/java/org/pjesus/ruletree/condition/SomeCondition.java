package org.pjesus.ruletree.condition;

import javax.inject.Inject;

import org.pjesus.ruletree.validator.SomeValidator;
import org.pjesus.ruletree.validator.Validator;

public class SomeCondition implements AbstractCondition {
  private final SomeValidator validator;

  @Inject
  public SomeCondition(SomeValidator validator) {
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
