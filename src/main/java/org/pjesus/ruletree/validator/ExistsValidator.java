package org.pjesus.ruletree.validator;

import org.pjesus.ruletree.rule.Rule;
import org.pjesus.ruletree.selector.DataSelector;

import javax.inject.Inject;
import java.util.Map;

public class ExistsValidator implements Validator {
  private final DataSelector dataSelector;

  @Inject
  public ExistsValidator(DataSelector dataSelector) {
    this.dataSelector = dataSelector;
  }

  @Override
  public Boolean validate(Rule rule, Object data) {
    Map<String, Object> attributes = rule.getAttributes();
    String valuePath = (String) attributes.get("value");

    try {
      this.dataSelector.select(data, valuePath);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
