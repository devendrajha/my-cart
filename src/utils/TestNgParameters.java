package io.smartnexus.ats.utils;

import java.util.Map;

public class TestNgParameters {

  private String browser;
  private String environment;
  private String coreapi;
  private String jiraUrl;
  private Map<String, String> map;
  private String notificationAPIUrl;
  private String userName;
  private String password;
  private String webhookEndPoint;
  private String dts;
  private String locmger;
  private String geofence;
  private String apim;
  

  public TestNgParameters() {
    GetValuesFromTestNg obj = new GetValuesFromTestNg();
    map = obj.getValuesFromXml();
  }

  public String getBrowser() {
    browser = map.get("browser");
    return browser;
  }

  public String getPassword() {
    password = map.get("password");
    return password;

  }

  public void setBrowser(String browser) {
    this.browser = browser;
  }

  public String getUserName() {
    userName = map.get("userName");
    return userName;
  }

  public String getEnvironment() {
    environment = map.get("environment");
    // environment=System.getProperty("environment");
    return environment;
  }

  public String getCoreApi() {
    coreapi = map.get("coreapi");
    return coreapi;
  }

  public String getJiraUrl() {
    jiraUrl = map.get("jiraUrl");
    return jiraUrl;
  }

  public String getNotificationAPIUrl() {
    notificationAPIUrl = map.get("notificationAPIUrl");
    return notificationAPIUrl;
  }

  public String getDTS() {
    dts = map.get("dts");
    return dts;
  }

  public String getWebhookEndPoint() {
    webhookEndPoint = map.get("webhookEndPoint");
    return webhookEndPoint;
  }

  public String getGeofence() {
    geofence = map.get("geofence");
    return geofence;
  }

  public String getLocmger() {
    String env = getEnvironment();
    if (env.equals("tst")) {
      locmger = "https://tst-locmgt-us-e-001-wapp.tst-paas-ase.p.azurewebsites.net/api/LocationManagerWebHook?code=CfDJ8AAAAAAAAAAAAAAAAAAAAAB0WWyS3q_0Pjiok4vl2smBaX49GRflWZRAGQquHONiWRBVfwLHcBkmGjzYofgpW5UZyo2vram2YKvGfR7lsB-swF3Qau35QgfNojb_9N8MsNAbURMBcA7UdMbitmF9vkSo25SJL77g9tNYzmPKuX8ruibDcYksrX0oI2SDrKjawA";

    } else if (env.equals("preview")) {
      locmger = "https://preview-locmgt-us-e-001-wapp.preview-paas.p.azurewebsites.net/api/LocationManagerWebHook?code=FchiHQZ/ry/t/1yCRqthFPXncZBv3t4kqjVgE3JClBHyZ8DSrHejAQ==";

    } else if (env.equals("prodiat")) {
      locmger = "https://prodiat-locmgt-us-e-001-wapp.prodiat-paas.p.azurewebsites.net/api/LocationManagerWebHook?code=bwNVhhgr0SJUi3k/1VEbisk9PsUvymSvvkGj3c2h8Ik6ng/izXNwYg==";

    }
    return locmger;
  }

  public String getApim() {
    String env = getEnvironment();
    if (env.equals("tst")) {
    	apim   ="5758cf1ba3604a76aed48ad70faeeac9";
    } else if (env.equals("preview")) {
      apim   ="bc6e5eb4441145739886ea8db7f7d86a";
    } else if (env.equals("prodiat")) {
      apim   ="aa2c5892de9c48eaabf15fb39e84648d";
    }
    return apim;
  }
  
  
}
