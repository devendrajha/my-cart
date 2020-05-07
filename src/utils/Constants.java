package io.smartnexus.ats.utils;

public class Constants {

  static TestNgParameters testNg = new TestNgParameters();
  static CommonUtils cu = new CommonUtils();
  static String environment = testNg.getEnvironment();

  // Application Under Test URL's
  public static final String CORE_SERVICE = "https://" + environment + ".api.smartnexus.io/" + environment + "/core/";
  public static final String NOTIFICATION_SERVICE = "https://" + environment + ".api.smartnexus.io/" + environment + "/notifications/api/v1/";
  public static final String DTS_SERVICE = "https://api.smartnexus.io/" + environment + "/datatransformation/api/v1/";
  public static final String GEOFENCE_SERVICE = "https://api.smartnexus.io/" + environment + "/geofence/api/v1/";
  public static final String WEBHOOK_SERVER = "http://52.232.230.240:3000/snp/webhooks";
  public static final String JIRA_API = "https://flexci.atlassian.net";
  public static final String AGENT_CORE_SERVICE = "https://api.smartnexus.io/" + environment + "/agent/";
  // Login page
  public static final long IMPLICIT_WAIT = 30;
  public static final long EXPLICIT_WAIT = 50;
  public static final long DEVICE_SAVE_EXPLICIT_WAIT = 25;
  public static final String MFGID = "mfg0E31";
  public static final String HWversion = "1.0.1";
  public static final String SWversion = "1.1.1";

  // putsReq URL

  // Application specific constants
  public static final String TENANT_CUID = "" + cu.generateRandomNumber() + cu.generateRandomNumber();
  public static final String TENANT_NAME = "snp_" +System.currentTimeMillis();
  public static final String PRODUCTMASTER_NAME = "Product Master_" + cu.randomName();
  public static final String PRODUCTMASTER_SKU = "sku" + cu.generateRandomID() + cu.generateRandomID();
  public static final String PACKAGE_NAME = "package_" + cu.randomName();
  public static final String GROUP_NAME = "reportinggrp_" + cu.randomName();

  public static final String INDUSTRY_ID = "f789254a-560d-4271-852d-e32ae08233b3";
  // Provision page Control panel
  public static final String CP_USERNAME = "autosubscriber" + cu.randomName();
  public static final String CP_PASSWORD = "autosubscriber" + cu.randomName();
  public static final int IN_RANDOM_NUMBER_LENGTH = 4;
  public static final String ROOT_USERNAME = testNg.getUserName();
  public static final String ROOT_PASSWORD = testNg.getPassword();
  // REST API url

  // Dynamic end POINT
  public static final String DYNAMICENDPOINT_NAME = "DEP" + cu.randomName();
  // Product line page
  public static final String FIRMWARE_NAME = "fw_" + cu.randomName();

  // new window swith fail

  // DatatType uniqueID

  public static final String BOOL = "c58a07bd-25e6-4180-b2f7-1184c94b5766";
  public static final String INT = "2cd5d39f-4b39-4690-b201-8126b33ca71e";
  public static final String BYTE = "185e2c32-4c22-4417-b3e5-541b68924a97";
  public static final String DECIMAL = "4bb47cf9-ff32-46ce-b36b-526d710585c8";
  public static final String BIGINT = "eae54e31-3e45-42ba-8cf1-b14cbdb452a3";
  public static final String STRING = "df7fa1bf-be62-4d2e-8ac5-72913ebc1042";
  public static final String FLOAT = "539aa436-05a4-424c-9033-0faf2fd1fd79";
  public static final String DOUBLE = "fae0b3d3-de17-446f-a934-f0c4649c3859";
  public static final String LDOUBLE = "e613ea3c-97eb-41a2-a0c4-c9e264b4d11e";
  public static final String JSON = "eee5412c-897f-4a60-8d9e-18d2ae724ea2";

  // formTypes
  public static final int TEXT = 1;
  public static final int DROPDOWN = 2;
  public static final int CHECKBOX = 4;
  public static final int SYSDATE = 6;
  public static final int NA = 0;
  // PACKAGE TYPE

  public static final String APK = "17f7187b-50ff-4ddb-af18-31d8a007f256";
  public static final String FIRMWARE = "17f7187b-51ff-4ddb-af18-31d8a007f256";
  public static final String CONNECTION_CONFIG = "17f7187b-52ff-4ddb-af18-31d8a007f256";

  // constraint types

  public static final String MAX = "6f4bce3a-973f-421d-ba3a-1328c6f1605b";
  public static final String MIN = "4b4d281d-59c5-4550-9e8d-4ed254324c26";
  public static final String POSITIVE = "cc3c1ebd-a485-488c-acde-5edd4c615f30";
  public static final String NEGETIVE = "5cd4f011-d3b0-4c05-84d4-215d5190243f";

  // Locationmanager settings Localid
  public static final int dataEnabled = 201;
  public static final int indoorLocation = 202;
  public static final int dataDeliveryInterval = 203;
  public static final int isOnline = 204;
  public static final int isOffline = 205;
  public static final int webHookUrl = 206;

  // Data transformation
  public static final String PROPERTY_NAME = "dtsname " + cu.randomName();

  // Notification messages
  public static final String ACTIVATE = "Device Activated";
  
  
}
