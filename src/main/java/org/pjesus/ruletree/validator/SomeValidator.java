package org.pjesus.ruletree.validator;

import org.pjesus.ruletree.RuleTree;
import org.pjesus.ruletree.rule.Rule;
import org.pjesus.ruletree.selector.DataSelector;
import org.pjesus.ruletree.utils.CollectionUtils;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

public class SomeValidator implements Validator {
  private final RuleTree ruleTree;
  private final DataSelector dataSelector;

  @Inject
  public SomeValidator(RuleTree ruleTree, DataSelector dataSelector) {
    this.ruleTree = ruleTree;
    this.dataSelector = dataSelector;
  }

  @SuppressWarnings("unchecked")
  @Override
  public Boolean validate(Rule rule, Object data) {
    Map<String, Object> attributes = rule.getAttributes();
    String dataPath = (String) attributes.get("data");
    final Map<String, Object> ruleConfig = (Map<String, Object>) attributes.get("rule");

    try {
      List<?> selectedDataList = (List<?>) this.dataSelector.select(data, dataPath);
      return CollectionUtils.anyMatch(selectedDataList, new CollectionUtils.MatchCallback() {
  		
  		@Override
  		public boolean match(Object dataItem) {
  			return ruleTree.validate(ruleConfig, dataItem);
  		}
      });
    } catch (Exception e) {
      return false;
    }
  }
}
