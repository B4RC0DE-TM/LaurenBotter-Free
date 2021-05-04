// 
// Todos los derechos reservados a Daniel.Arvizu.Rosselli
// 
package me.arvizu.laurenbotter;

import java.util.HashMap;
import java.util.Map;

public class opciones {

  private final Map<String, Object> options = new HashMap<>();

  public boolean isOption(String id) {
    return this.options.containsKey(id);
  }

  public <T> T getOption(String id, T defaultValue) {
    return (T) this.options.getOrDefault(id, defaultValue);
  }

  public Map<String, Object> getopciones() {
    return options;
  }

  public static class Builder {
    public static opciones of(String... args) {
      final opciones options = new opciones();
      for (String arg : args) {
        final String[] part = arg.split("=");
        if (part.length > 1) {
          Object value = part[1];//.replace("=", "");


          //autodetect of int
          try {
            value = Integer.parseInt((String)value);
          }
          catch (Exception ignored) {
          }

          if (value instanceof String && value.equals("si") || value.equals("no")) {
            //autodetect of boolean
            try {
              value = Boolean.parseBoolean((String) value);
            } catch (Exception ignored) {
            }
          }

          options.options.put(part[0].replace("=", ""), value);
        }
      }
      return options;
    }
  }

    static class options {

        public options() {
        }
    }

}
