package org.pjesus.ruletree.condition;

import javax.inject.Inject;

import org.pjesus.ruletree.validator.ExistsValidator;
import org.pjesus.ruletree.validator.Validator;

public class ExistsCondition implements AbstractCondition {
  private final ExistsValidator validator;

  @Inject
  public ExistsCondition(ExistsValidator validator) {
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
