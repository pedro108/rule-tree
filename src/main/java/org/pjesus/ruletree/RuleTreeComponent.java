package org.pjesus.ruletree;

import org.pjesus.ruletree.condition.AndCondition;
import org.pjesus.ruletree.condition.EqualsCondition;
import org.pjesus.ruletree.condition.EveryCondition;
import org.pjesus.ruletree.condition.ExistsCondition;
import org.pjesus.ruletree.condition.GreaterThanCondition;
import org.pjesus.ruletree.condition.GreaterThanEqualsCondition;
import org.pjesus.ruletree.condition.InCondition;
import org.pjesus.ruletree.condition.LesserThanCondition;
import org.pjesus.ruletree.condition.LesserThanEqualsCondition;
import org.pjesus.ruletree.condition.NotInCondition;
import org.pjesus.ruletree.condition.OrCondition;
import org.pjesus.ruletree.condition.SomeCondition;
import org.pjesus.ruletree.condition.SumMatchesRuleCondition;
import org.pjesus.ruletree.condition.annotation.Condition;

import dagger.Component;

@Component(modules = { RuleTreeModule.class })
public interface RuleTreeComponent {
	
    RuleTree ruleTree();
    
    @Condition("and")
    AndCondition andCondition();

    @Condition("equals")
    EqualsCondition equalsCondition();

    @Condition("every")
    EveryCondition everyCondition();
    
    @Condition("exists")
    ExistsCondition existsCondition();

    @Condition("greater-than")
    GreaterThanCondition greaterThanondition();

    @Condition("greater-than-equals")
    GreaterThanEqualsCondition greaterThanEqualsCondition();
    
    @Condition("in")
    InCondition inCondition();

    @Condition("lesser-than")
    LesserThanCondition lesserThanCondition();

    @Condition("lesser-than-equals")
    LesserThanEqualsCondition lesserThanEqualsCondition();

    @Condition("not-in")
    NotInCondition notInCondition();

    @Condition("or")
    OrCondition orCondition();

    @Condition("some")
    SomeCondition someCondition();

    @Condition("sum-matches-rule")
    SumMatchesRuleCondition sumMatchesRuleCondition();
}
