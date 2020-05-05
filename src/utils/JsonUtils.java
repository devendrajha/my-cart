package io.smartnexus.ats.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;

public class JsonUtils {

  private static final Logger log = Logger.getLogger(JsonUtils.class.getName());

  /**
   * This method is used to compare the json response parameters
   *
   * @param expectedValue - input text to be verified
   * @param jsonPath      - path to locate the key value pair in json response
   * @param response      - output response where the text is to be verified
   * @return true if text is present in the response
   */
  public boolean jsonComparison(String expectedValue, String jsonPath, String response) {
    try {
      log.debug("Executing jsonComparison...for " + expectedValue);
      log.trace(response + "response");
      String[] jsonKeyList = jsonPath.split("~");
      String[] expResultKeyValue = expectedValue.split("~");
      List<String> keys = new ArrayList<String>();
      Map<String, Object> expResultMap = new HashMap<String, Object>();
      if (!expectedValue.isEmpty()) {
        for (int i = 0; i < expResultKeyValue.length; i++) {
          if (expResultKeyValue[i].contains("=")) {
            String[] keyMap = expResultKeyValue[i].split("=");
            expResultMap.put(keyMap[0], keyMap[1]);
            keys.add(keyMap[0]);
          }
        }
      }
      log.debug("Expected ResultMap -> " + expResultMap);
      JSONObject jsonObj = null;
      jsonObj = (JSONObject) new JSONParser().parse(response);
      for (int i = 0; i < jsonKeyList.length; i++) {
        if (jsonObj != null)
          jsonObj = (JSONObject) jsonObj.get(jsonKeyList[i]);
      }
      Map<String, Object> output = new HashMap<String, Object>();
      if (!expectedValue.isEmpty() && (keys != null) && jsonObj != null) {
        for (int i = 0; i < expResultKeyValue.length; i++) {
          output.put(keys.get(i), (Object) jsonObj.get(keys.get(i)));
        }
      }
      log.debug("Actual ResultMap -> " + output);
      if (!expResultMap.equals(output)) {
        String expResult = (String) expResultMap.toString();
        String actualResult = (String) output.toString();
        log.debug("Json expected and actual values are not equal");
        Assert.assertEquals(expResult, actualResult);
        return false;
      }
    } catch (Exception e) {
      log.debug("Json comparison failed due to: ", e);
      return true;
    }
    return true;
  }
}
