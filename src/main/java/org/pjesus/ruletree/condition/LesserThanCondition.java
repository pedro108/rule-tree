package org.pjesus.ruletree.condition;

import javax.inject.Inject;

import org.pjesus.ruletree.validator.LesserThanValidator;
import org.pjesus.ruletree.validator.Validator;

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
