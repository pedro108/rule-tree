package org.pjesus.ruletree.validator;

import org.pjesus.ruletree.rule.Rule;
import org.pjesus.ruletree.selector.DataSelector;
import org.pjesus.ruletree.utils.CollectionUtils;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

public class InValidator implements Validator {
  private final DataSelector dataSelector;

  @Inject
  public InValidator(DataSelector dataSelector) {
    this.dataSelector = dataSelector;
  }

  @Override
  public Boolean validate(Rule rule, Object data) {
    Map<String, Object> attributes = rule.getAttributes();
    String dataPath = (String) attributes.get("data");
    List<?> values = (List<?>) attributes.get("value");

    try {
      final Object selectedData = this.dataSelector.select(data, dataPath);
      return CollectionUtils.anyMatch(values, new CollectionUtils.MatchCallback() {
		
		@Override
		public boolean match(Object value) {
			return value.equals(selectedData);
		}
      });
    } catch (Exception e) {
      return false;
    }
  }
}
