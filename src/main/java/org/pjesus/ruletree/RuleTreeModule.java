package org.pjesus.ruletree;

import org.pjesus.ruletree.condition.factory.ConditionFactory;
import org.pjesus.ruletree.parser.Parser;
import org.pjesus.ruletree.parser.RuleParser;
import org.pjesus.ruletree.selector.DataSelector;

import dagger.Module;
import dagger.Provides;

@Module
public class RuleTreeModule {
	
	@Provides
	public Parser provideParser(ConditionFactory conditionFactory) {
		return new RuleParser(conditionFactory);
	}
	
	@Provides
	public DataSelector provideDataSelector() {
		return new DataSelector();
	}
}
