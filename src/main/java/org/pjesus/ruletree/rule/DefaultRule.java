package org.pjesus.ruletree.rule;

import org.pjesus.ruletree.condition.AbstractCondition;

import java.util.Map;

public class DefaultRule implements Rule {
  private AbstractCondition condition;
  private Map<String, Object> attributes;

  public DefaultRule(AbstractCondition condition, Map<String, Object> attributes) {
    this.condition = condition;
    this.attributes = attributes;
  }

  @Override
  public AbstractCondition getCondition() {
    return this.condition;
  }

  @Override
  public Map<String, Object> getAttributes() {
    return this.attributes;
  }
}
