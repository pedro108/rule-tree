package org.pjesus.ruletree.validator;

import org.pjesus.ruletree.RuleTree;
import org.pjesus.ruletree.rule.Rule;
import org.pjesus.ruletree.utils.CollectionUtils;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

public class OrValidator implements Validator {
  private final RuleTree ruleTree;

  @Inject
  public OrValidator(RuleTree ruleTree) {
    this.ruleTree = ruleTree;
  }

  @SuppressWarnings("unchecked")
  @Override
  public Boolean validate(Rule rule, final Object data) {
    Map<String, Object> attributes = rule.getAttributes();
    List<Map<String, Object>> ruleConfigs = (List<Map<String, Object>>) attributes.get("rules");

    try {
      return CollectionUtils.anyMatch(ruleConfigs, new CollectionUtils.MatchCallback() {
  		
  		@Override
  		public boolean match(Object ruleConfig) {
  			return ruleTree.validate((Map<String, Object>) ruleConfig, data);
  		}
      });
    } catch (Exception e) {
      return false;
    }
  }
}
