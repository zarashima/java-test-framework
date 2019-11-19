package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {

  private static PropertyUtils instance;
  private final Properties props = new Properties();
  private Integer webTimeout;

  public static PropertyUtils getInstance() {
    if (instance == null) {
      instance = new PropertyUtils();
      instance.loadData();
    }
    return instance;
  }

  private void loadData() {
    String settingsFilePath = "src/test/resources/settings.properties";
    try {
      props.load(new FileInputStream(settingsFilePath));
    } catch (IOException e) {
      e.printStackTrace();
    }
    webTimeout = Integer.valueOf(props.getProperty("web.timeout"));
  }

  public Integer getWebTimeout() {
    return webTimeout;
  }
}