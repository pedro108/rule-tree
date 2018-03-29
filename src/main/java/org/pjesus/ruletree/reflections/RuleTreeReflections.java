package org.pjesus.ruletree.reflections;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;

public class RuleTreeReflections extends Reflections {
  public RuleTreeReflections() {
    super("org.pjesus.ruletree", new MethodAnnotationsScanner());
  }
}
