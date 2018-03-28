package org.pjesus.ruletree.condition;

import org.pjesus.ruletree.condition.annotation.Condition;
import org.pjesus.ruletree.validator.InValidator;
import org.pjesus.ruletree.validator.Validator;

import javax.inject.Inject;

@Condition("in")
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
