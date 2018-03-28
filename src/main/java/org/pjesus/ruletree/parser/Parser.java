package org.pjesus.ruletree.parser;

import org.pjesus.ruletree.rule.Rule;

import java.util.Map;

public interface Parser {
  Rule parse(Map<String, Object> ruleConfig);
}
