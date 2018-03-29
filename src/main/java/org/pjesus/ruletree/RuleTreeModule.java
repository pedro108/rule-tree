package org.pjesus.ruletree;

import org.pjesus.ruletree.condition.factory.ConditionFactory;
import org.pjesus.ruletree.parser.Parser;
import org.pjesus.ruletree.parser.RuleParser;
import org.pjesus.ruletree.reflections.RuleTreeReflections;
import org.pjesus.ruletree.selector.DataSelector;
import org.reflections.Reflections;

import dagger.Module;
import dagger.Provides;

@Module
public class RuleTreeModule {
	
	@Provides
	public Reflections provideReflections() {
		return new RuleTreeReflections();
	}

	@Provides
	public Parser provideParser(ConditionFactory conditionFactory) {
		return new RuleParser(conditionFactory);
	}
	
	@Provides
	public DataSelector provideDataSelector() {
		return new DataSelector();
	}
}
