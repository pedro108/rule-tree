package org.pjesus.ruletree.condition;

import org.pjesus.ruletree.condition.annotation.Condition;
import org.pjesus.ruletree.validator.LesserThanEqualsValidator;
import org.pjesus.ruletree.validator.Validator;

import javax.inject.Inject;

@Condition("lesser-than-equals")
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
