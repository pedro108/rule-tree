package org.pjesus.ruletree.rule;

import org.pjesus.ruletree.condition.AbstractCondition;

import java.util.Map;

public interface Rule {
  public AbstractCondition getCondition();
  public Map<String, Object> getAttributes();
  public String toString();
}
