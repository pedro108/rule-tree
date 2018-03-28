package org.pjesus.ruletree;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class RuleTreeBuilder {
  public static RuleTree build() {
    Injector injector = Guice.createInjector(new RuleTreeModule());
    return injector.getInstance(RuleTree.class);
  }
}
