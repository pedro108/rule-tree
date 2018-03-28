package org.pjesus.ruletree.condition;

import org.pjesus.ruletree.condition.annotation.Condition;
import org.pjesus.ruletree.validator.LesserThanValidator;
import org.pjesus.ruletree.validator.Validator;

import javax.inject.Inject;

@Condition("lesser-than")
public class LesserThanCondition implements AbstractCondition {
  private final LesserThanValidator validator;

  @Inject
  public LesserThanCondition(LesserThanValidator validator) {
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
