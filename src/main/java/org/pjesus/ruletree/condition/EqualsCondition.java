package org.pjesus.ruletree.condition;

import org.pjesus.ruletree.condition.annotation.Condition;
import org.pjesus.ruletree.validator.EqualsValidator;
import org.pjesus.ruletree.validator.Validator;

import javax.inject.Inject;

@Condition("equals")
public class EqualsCondition implements AbstractCondition {
  private final EqualsValidator validator;

  @Inject
  public EqualsCondition(EqualsValidator validator) {
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
