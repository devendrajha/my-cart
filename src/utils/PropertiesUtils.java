package io.smartnexus.ats.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {
  public static Properties configProp = new Properties();

  public Properties loadProps() {
    Thread currentThread = Thread.currentThread();
    ClassLoader contextClassLoader = currentThread.getContextClassLoader();
    InputStream in = this.getClass().getClassLoader().getResourceAsStream("deviceDetails.properties");
    try {
      if (in != null) {
        configProp.load(in);
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
    return configProp;
  }

  public String getQuery(String str) {
    return configProp.getProperty(str);
  }

}
