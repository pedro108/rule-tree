package org.pjesus.ruletree.condition;

import org.pjesus.ruletree.condition.annotation.Condition;
import org.pjesus.ruletree.validator.EveryValidator;
import org.pjesus.ruletree.validator.Validator;

import javax.inject.Inject;

@Condition("every")
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
