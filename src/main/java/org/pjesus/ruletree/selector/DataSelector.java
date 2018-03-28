package org.pjesus.ruletree.selector;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings({"rawtypes", "unchecked"})
public class DataSelector {

  public Object select(Object data, String dataPath) throws Exception {
    if (dataPath == null)
      return data;

    Matcher matcher = getMatches(dataPath);

    List<String> attributes = new ArrayList<>();
    List<String> accessors = new ArrayList<>();
    List<String> modifiers = new ArrayList<>();
    while (matcher.find()) {
      attributes.add(getMatchAttributes(matcher));
      accessors.add(getMatchAccessors(matcher));
      modifiers.add(getMatchModifiers(matcher));
    }

    for (int i = 0; i < attributes.size(); i++) {
      String value = attributes.get(i);
      String accessorCode = accessors.get(i);
      String modifierCode = modifiers.get(i);
      if (isPropertyAccessor(accessorCode)) {
        data = getPropertyValue(data, value, modifierCode);
        continue;
      }
      if (isMethodAccessor(accessorCode)) {
        data = getMethodValue(data, value, modifierCode);
        continue;
      }
      throw new Exception("Property selection invalid");
    }

    return data;
  }

  private Matcher getMatches(String dataPath) {
    Pattern r = Pattern.compile("([.#]?)([a-zA-Z0-9]+)(\\[])?");
    return r.matcher(dataPath);
  }

  private String getMatchModifiers(Matcher matches) {
    return matches.group(3);
  }

  private String getMatchAttributes(Matcher matches) {
    return matches.group(2);
  }

  private String getMatchAccessors(Matcher matches) {
    return matches.group(1);
  }

  private boolean isPropertyAccessor(String accessorCode) {
    return ".".equals(accessorCode) || "".equals(accessorCode);
  }

  private boolean isMethodAccessor(String accessorCode) {
    return "#".equals(accessorCode);
  }

  private boolean isFlatMapModifier(String modifierCode) {
    return "[]".equals(modifierCode);
  }

  private Object getPropertyValue(Object data, Object value, String modifier) throws Exception {
    if (data instanceof Object[])
      data = Arrays.asList(data);
    if (data instanceof List) {
      if (isFlatMapModifier(modifier)) {
        List flatMap = new ArrayList();
        for (Object item : (List) data) {
          List list = (List) getMethodValue(item, "get" + capitalize((String) value));
          flatMap.addAll(list);
        }
        return flatMap;
      }

      return ((List) data).get((int) value);
    }

    if (data instanceof Map)
      return ((Map) data).get(value);

    Field field = data.getClass().getDeclaredField((String) value);
    boolean isBoolean = field.getType() == Boolean.class  || field.getType() == boolean.class;
    if(isBoolean && ((String) value).contains("is"))
      return getMethodValue(data, (String) value);
    return getMethodValue(data, (isBoolean ? "is" : "get") + capitalize((String) value));
  }

  private String capitalize(final String line) {
    return Character.toUpperCase(line.charAt(0)) + line.substring(1);
  }

  private Object getMethodValue(Object data, Object value, String modifier) throws Exception {
    if (data instanceof Object[])
      data = Arrays.asList(data);
    if (data instanceof List) {
      if (isFlatMapModifier(modifier)) {
        List flatMap = new ArrayList();
        for (Object item : (List) data) {
          List list = (List) getMethodValue(item, (String) value);
          flatMap.addAll(list);
        }
        return flatMap;
      }

      return ((List) data).get((int) value);
    }

    if (data instanceof Map)
      return ((Map) data).get(value);

    return getMethodValue(data, (String) value);
  }

  private Object getMethodValue(Object obj, String methodName) throws Exception {
    Method method = obj.getClass().getMethod(methodName);
    return method.invoke(obj);
  }
}
