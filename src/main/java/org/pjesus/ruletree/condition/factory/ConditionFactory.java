package org.pjesus.ruletree.condition.factory;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import org.pjesus.ruletree.DaggerRuleTreeComponent;
import org.pjesus.ruletree.RuleTreeComponent;
import org.pjesus.ruletree.condition.AbstractCondition;
import org.pjesus.ruletree.condition.annotation.Condition;
import org.pjesus.ruletree.utils.CollectionUtils;

public class ConditionFactory {

  @Inject
  public ConditionFactory() {

  }

  public AbstractCondition create(final String conditionName) {
	RuleTreeComponent component = DaggerRuleTreeComponent.builder().build();
	
	List<Method> methods = Arrays.asList(RuleTreeComponent.class.getMethods());
	Collection<Method> conditionMethods = CollectionUtils.filter(methods, new CollectionUtils.FilterCallback() {

		@Override
		public boolean filter(Object method) {
			Condition condition = ((Method) method).getAnnotation(Condition.class);
			return condition == null ? false : condition.value().equals(conditionName);
		}
	});
	Method method = conditionMethods.iterator().next();
	try {
		return (AbstractCondition) method.invoke(component);
	} catch (Exception e) {
		return null;
	}
  }
}
