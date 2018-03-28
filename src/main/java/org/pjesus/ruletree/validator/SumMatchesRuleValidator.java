package org.pjesus.ruletree.validator;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.pjesus.ruletree.RuleTree;
import org.pjesus.ruletree.rule.Rule;
import org.pjesus.ruletree.selector.DataSelector;

public class SumMatchesRuleValidator implements Validator {

	private RuleTree ruleTree;
    private DataSelector selector;

    @Inject
    public SumMatchesRuleValidator(RuleTree ruleTree, DataSelector selector) {
        this.ruleTree = ruleTree;
        this.selector = selector;
    }

    public Boolean validate(Rule rule, Object data) {
    	try {
    		Map<String, Object> attributes = rule.getAttributes();
    		List<?> list = (List<?>) selector.select(data, (String) attributes.get("list"));
    		Map<String, Object> ruleConfig = (Map<String, Object>) attributes.get("rule");
    		
    		if (attributes.get("filter") != null) {
        		Map<String, Object> filter = (Map<String, Object>) attributes.get("filter");
    			list = list.stream().filter(item -> ruleTree.validate(filter, item)).collect(Collectors.toList());
    		}
    		
    		if (attributes.get("data") != null) {
        		String attributeData = (String) attributes.get("data");
        		list = list.stream().map(item -> selectData(item, attributeData)).collect(Collectors.toList());
    		}
    		
			return ruleTree.validate(ruleConfig, list.stream().mapToDouble(item -> (Double) item).sum());
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
