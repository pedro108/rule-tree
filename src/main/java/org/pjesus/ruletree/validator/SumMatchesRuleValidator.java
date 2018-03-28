package org.pjesus.ruletree.validator;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.pjesus.ruletree.RuleTree;
import org.pjesus.ruletree.rule.Rule;
import org.pjesus.ruletree.selector.DataSelector;
import org.pjesus.ruletree.utils.CollectionUtils;

public class SumMatchesRuleValidator implements Validator {

	private RuleTree ruleTree;
    private DataSelector selector;

    @Inject
    public SumMatchesRuleValidator(RuleTree ruleTree, DataSelector selector) {
        this.ruleTree = ruleTree;
        this.selector = selector;
    }

    @SuppressWarnings("unchecked")
	public Boolean validate(Rule rule, Object data) {
    	try {
    		Map<String, Object> attributes = rule.getAttributes();
    		List<?> list = (List<?>) selector.select(data, (String) attributes.get("list"));
    		Map<String, Object> ruleConfig = (Map<String, Object>) attributes.get("rule");
    		
    		if (attributes.get("filter") != null) {
        		final Map<String, Object> filter = (Map<String, Object>) attributes.get("filter");
        		list = (List<?>) CollectionUtils.filter(list, new CollectionUtils.FilterCallback() {
					
					@Override
					public boolean filter(Object item) {
						return ruleTree.validate(filter, item);
					}
				});
    		}
    		
    		if (attributes.get("data") != null) {
        		final String attributeData = (String) attributes.get("data");
        		list = (List<Double>) CollectionUtils.mapToDouble(list, new CollectionUtils.MapCallback() {
					
					@Override
					public Object map(Object item) {
						return selectData(item, attributeData);
					}
				});
    		}
    		
			return ruleTree.validate(ruleConfig, CollectionUtils.sum((Collection<Number>) list));
    	} catch (Exception e) {
    		return false;
    	}
    }

    private Double selectData(Object data, String dataPath) {
        try {
			return (Double) selector.select(data, dataPath);
		} catch (Exception e) {
			return 0.0;
		}
    }
}
