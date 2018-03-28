package org.pjesus.ruletree.condition;

import org.pjesus.ruletree.condition.annotation.Condition;
import org.pjesus.ruletree.validator.ExistsValidator;
import org.pjesus.ruletree.validator.Validator;

import javax.inject.Inject;

@Condition("exists")
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
