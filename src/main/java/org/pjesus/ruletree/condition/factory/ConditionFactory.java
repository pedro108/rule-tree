package org.pjesus.ruletree.condition.factory;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.pjesus.ruletree.RuleTreeModule;
import org.pjesus.ruletree.condition.AbstractCondition;
import org.pjesus.ruletree.condition.annotation.Condition;
import org.reflections.Reflections;

import javax.inject.Inject;
import java.util.Set;

public class ConditionFactory {
  private final Reflections reflections;

  @Inject
  public ConditionFactory(Reflections reflections) {
    this.reflections = reflections;
  }

  public AbstractCondition create(String conditionName) {
    Set<Class<?>> conditionClasses = this.reflections.getTypesAnnotatedWith(Condition.class);
    Class<?> conditionClass = conditionClasses.stream()
      .filter(c -> c.getAnnotation(Condition.class).value().equals(conditionName))
      .findFirst()
      .orElse(AbstractCondition.class);

    Injector injector = Guice.createInjector(new RuleTreeModule());
    return (AbstractCondition) injector.getInstance(conditionClass);
  }
}
