package org.pjesus.ruletree.validator;

import org.pjesus.ruletree.parser.Parser;
import org.pjesus.ruletree.rule.Rule;
import org.pjesus.ruletree.selector.DataSelector;

import javax.inject.Inject;
import java.util.Map;

public class EqualsValidator implements Validator {
  private final DataSelector dataSelector;

  @Inject
  public EqualsValidator(DataSelector dataSelector) {
    this.dataSelector = dataSelector;
  }

  @Override
  public Boolean validate(Rule rule, Object data) {
    Map<String, Object> attributes = rule.getAttributes();
    String dataPath = (String) attributes.get("data");
    Object value = attributes.get("value");

    try {
      Object selectedData = this.dataSelector.select(data, dataPath);
      return value.equals(selectedData);
    } catch (Exception e) {
      return false;
    }
  }
}
