package org.pjesus.ruletree.condition;

import org.pjesus.ruletree.validator.Validator;

public interface AbstractCondition {
  public Validator getValidator();
  public Boolean validateSchema();
  public String toString();
}
