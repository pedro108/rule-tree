package org.pjesus.ruletree.condition;

import javax.inject.Inject;

import org.pjesus.ruletree.validator.LesserThanEqualsValidator;
import org.pjesus.ruletree.validator.Validator;

public class LesserThanEqualsCondition implements AbstractCondition {
  private final LesserThanEqualsValidator validator;

  @Inject
  public LesserThanEqualsCondition(LesserThanEqualsValidator validator) {
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
