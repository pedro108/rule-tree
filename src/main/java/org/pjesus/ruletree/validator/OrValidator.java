package org.pjesus.ruletree.validator;

import org.pjesus.ruletree.RuleTree;
import org.pjesus.ruletree.rule.Rule;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

public class OrValidator implements Validator {
  private final RuleTree ruleTree;

  @Inject
  public OrValidator(RuleTree ruleTree) {
    this.ruleTree = ruleTree;
  }

  @Override
  public Boolean validate(Rule rule, Object data) {
    Map<String, Object> attributes = rule.getAttributes();
    List<Map<String, Object>> ruleConfigs = (List<Map<String, Object>>) attributes.get("rules");

    try {
      return ruleConfigs.stream()
        .anyMatch(ruleConfig -> this.ruleTree.validate(ruleConfig, data));
    } catch (Exception e) {
      return false;
    }
  }
}
