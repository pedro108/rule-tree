package org.pjesus.ruletree.condition.factory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;

import javax.inject.Inject;

import org.pjesus.ruletree.DaggerRuleTreeComponent;
import org.pjesus.ruletree.RuleTreeComponent;
import org.pjesus.ruletree.condition.AbstractCondition;
import org.pjesus.ruletree.condition.annotation.Condition;
import org.pjesus.ruletree.utils.CollectionUtils;
import org.reflections.Reflections;

public class ConditionFactory {
  private final Reflections reflections;

  @Inject
  public ConditionFactory(Reflections reflections) {
    this.reflections = reflections;
  }

  public AbstractCondition create(final String conditionName) {
	RuleTreeComponent component = DaggerRuleTreeComponent.builder().build();
	  
	Collection<Method> conditionMethods = reflections.getMethodsAnnotatedWith(Condition.class);
	conditionMethods = CollectionUtils.filter(conditionMethods, new CollectionUtils.FilterCallback() {

		@Override
		public boolean filter(Object method) {
			return ((Method) method).getAnnotation(Condition.class).value().equals(conditionName);
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
