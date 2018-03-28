package org.pjesus.ruletree.condition;

import org.pjesus.ruletree.condition.annotation.Condition;
import org.pjesus.ruletree.validator.NotInValidator;
import org.pjesus.ruletree.validator.Validator;

import javax.inject.Inject;

@Condition("not-in")
public class NotInCondition implements AbstractCondition {
  private final NotInValidator validator;

  @Inject
  public NotInCondition(NotInValidator validator) {
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
