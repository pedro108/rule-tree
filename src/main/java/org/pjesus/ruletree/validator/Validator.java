package org.pjesus.ruletree.validator;

import org.pjesus.ruletree.rule.Rule;

public interface Validator {
  public Boolean validate(Rule rule, Object data);
}
