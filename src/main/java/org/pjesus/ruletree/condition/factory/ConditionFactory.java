package org.pjesus.ruletree.condition.factory;

import java.util.Collection;
import java.util.Set;

import javax.inject.Inject;

import org.pjesus.ruletree.RuleTreeModule;
import org.pjesus.ruletree.condition.AbstractCondition;
import org.pjesus.ruletree.condition.annotation.Condition;
import org.pjesus.ruletree.utils.CollectionUtils;
import org.reflections.Reflections;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class ConditionFactory {
  private final Reflections reflections;

  @Inject
  public ConditionFactory(Reflections reflections) {
    this.reflections = reflections;
  }

  public AbstractCondition create(final String conditionName) {
    Set<Class<?>> conditionClasses = this.reflections.getTypesAnnotatedWith(Condition.class);
    Collection<Class<?>> filteredConditionClasses = CollectionUtils.filter(conditionClasses, new CollectionUtils.FilterCallback() {
		
		@Override
		public boolean filter(Object object) {
			return ((Class<?>) object).getAnnotation(Condition.class).value().equals(conditionName);
		}
	});
    Class<?> conditionClass = CollectionUtils.getFirstOrDefault(filteredConditionClasses, AbstractCondition.class);
    Injector injector = Guice.createInjector(new RuleTreeModule());
    return (AbstractCondition) injector.getInstance(conditionClass);
  }
}
