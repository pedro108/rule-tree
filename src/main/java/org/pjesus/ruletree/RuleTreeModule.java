package org.pjesus.ruletree;

import com.google.inject.AbstractModule;
import org.pjesus.ruletree.parser.Parser;
import org.pjesus.ruletree.parser.RuleParser;
import org.pjesus.ruletree.reflections.RuleTreeReflections;
import org.reflections.Reflections;

public class RuleTreeModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(Parser.class).to(RuleParser.class);
    bind(Reflections.class).to(RuleTreeReflections.class);
  }
}
