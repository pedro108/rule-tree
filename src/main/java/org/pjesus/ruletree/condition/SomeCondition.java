package org.pjesus.ruletree.condition;

import org.pjesus.ruletree.condition.annotation.Condition;
import org.pjesus.ruletree.validator.SomeValidator;
import org.pjesus.ruletree.validator.Validator;

import javax.inject.Inject;

@Condition("some")
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
