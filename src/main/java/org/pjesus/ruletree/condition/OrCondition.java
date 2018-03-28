package org.pjesus.ruletree.condition;

import org.pjesus.ruletree.condition.annotation.Condition;
import org.pjesus.ruletree.validator.OrValidator;
import org.pjesus.ruletree.validator.Validator;

import javax.inject.Inject;

@Condition("or")
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
