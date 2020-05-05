package io.smartnexus.ats.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

import io.smartnexus.ats.groups.AddProductsToOTA;
import io.smartnexus.ats.groups.DayOfWeek;
import io.smartnexus.ats.groups.OTAgroups;
import io.smartnexus.ats.packages.ImageResponse;
import io.smartnexus.ats.packages.PackageGroup;
import io.smartnexus.ats.packages.PackageTypes;
import io.smartnexus.ats.pojo.APIResponse;
import io.smartnexus.ats.pojo.ActivateProduct;
import io.smartnexus.ats.pojo.AddTemplate;
import io.smartnexus.ats.pojo.AttributeDetails;
import io.smartnexus.ats.pojo.Attributes;
import io.smartnexus.ats.pojo.ComapnyConfiguration;
import io.smartnexus.ats.pojo.CommandData;
import io.smartnexus.ats.pojo.CommandDetails;
import io.smartnexus.ats.pojo.CommandGroups;
import io.smartnexus.ats.pojo.CommandHistory;
import io.smartnexus.ats.pojo.Commands;
import io.smartnexus.ats.pojo.CompanyDetails;
import io.smartnexus.ats.pojo.CompanyOptions;
import io.smartnexus.ats.pojo.ConfigureAttribute;
import io.smartnexus.ats.pojo.Constraints;
import io.smartnexus.ats.pojo.CreateProductMaster;
import io.smartnexus.ats.pojo.CreateSettingProfile;
import io.smartnexus.ats.pojo.DataTypes;
import io.smartnexus.ats.pojo.DataiENBL;
import io.smartnexus.ats.pojo.DynamicEP;
import io.smartnexus.ats.pojo.EphemerisData;
import io.smartnexus.ats.pojo.ErrorResponse;
import io.smartnexus.ats.pojo.GelAllCommands;
import io.smartnexus.ats.pojo.GetAllEndPoint;
import io.smartnexus.ats.pojo.GetLogDetails;
import io.smartnexus.ats.pojo.GetPackageBundle;
import io.smartnexus.ats.pojo.GroupCustomFields;
import io.smartnexus.ats.pojo.GroupDetails;
import io.smartnexus.ats.pojo.Ienbl;
import io.smartnexus.ats.pojo.ListOfPossibleValues;
import io.smartnexus.ats.pojo.LogData;
import io.smartnexus.ats.pojo.NotificationResponse;
import io.smartnexus.ats.pojo.Options;
import io.smartnexus.ats.pojo.PackageBundle;
import io.smartnexus.ats.pojo.Parameters;
import io.smartnexus.ats.pojo.Product;
import io.smartnexus.ats.pojo.ProductDetails;
import io.smartnexus.ats.pojo.ProductList;
import io.smartnexus.ats.pojo.ProductMaster;
import io.smartnexus.ats.pojo.ProductMasterAttributes;
import io.smartnexus.ats.pojo.ProductMasterData;
import io.smartnexus.ats.pojo.ProductMasterSetting;
import io.smartnexus.ats.pojo.ProductMasterVirtualProducts;
import io.smartnexus.ats.pojo.ProductSettingHistory;
import io.smartnexus.ats.pojo.ProductSync;
import io.smartnexus.ats.pojo.SendCommand;
import io.smartnexus.ats.pojo.SendCommandParameter;
import io.smartnexus.ats.pojo.SetUserPreference;
import io.smartnexus.ats.pojo.Setting;
import io.smartnexus.ats.pojo.SettingHistory;
import io.smartnexus.ats.pojo.SettingProfileNames;
import io.smartnexus.ats.pojo.SettingProfileValues;
import io.smartnexus.ats.pojo.SettingValue;
import io.smartnexus.ats.pojo.Settings;
import io.smartnexus.ats.pojo.SettingsData;
import io.smartnexus.ats.pojo.SettingsDetail;
import io.smartnexus.ats.pojo.Subscribe;
import io.smartnexus.ats.pojo.TransitionDetails;
import io.smartnexus.ats.pojo.Transitions;
import io.smartnexus.ats.pojo.UpdateEP;
import io.smartnexus.ats.pojo.UpdateUserField;
import io.smartnexus.ats.pojo.UserField;
import io.smartnexus.ats.pojo.UserFieldID;
import io.smartnexus.ats.pojo.UserFieldList;
import io.smartnexus.ats.pojo.UserFieldValue;
import io.smartnexus.ats.pojo.UserFields;
import io.smartnexus.ats.pojo.VirtualProductDetails;
import io.smartnexus.ats.pojo.WebhookResponse;
import io.smartnexus.ats.tenant.AddTenant;

public class NorthBoundInterface {
	private TestNgParameters testNg = new TestNgParameters();
	private Rest rest = new Rest();
	private static final Logger log = Logger.getLogger(NorthBoundInterface.class.getName());
	private WebInterfaceWrapper w;
	static CommonUtils cu = new CommonUtils();
	private String templateId = null;
	public static String plId;
	private String MfgId = Constants.MFGID;
	public static String tenantId = AddTenant.tenantId;
	TestNgParameters tng = new TestNgParameters();
	static String path = System.getProperty("user.dir");
	static String log_id;
	static List<String> multiDeviceList = new ArrayList<String>();


	public NorthBoundInterface() {

	}

	/**
	 * Method to get list of Products under given company ID
	 * 
	 * @param serialNo
	 * @throws IOException
	 */
	public String getProductList(String deviceId) throws IOException {
		String url = Constants.CORE_SERVICE + "/api/v1/company/" + tenantId + "/products";
		Gson gson = new Gson();
		Product productline = gson.fromJson(rest.getJson(url, getToken()), Product.class);
		ProductList[] data = productline.getData();
		for (ProductList list : data) {
			if (list.getDeviceId().equals(deviceId)) {
				return list.getProductId();
			}
		}
		return null;
	}

	public String getAllEndPoint(String vpId, String type) throws JsonSyntaxException, IOException {
		String url = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/products/" + vpId + "/endpoints";
		Gson gson = new Gson();
		GetAllEndPoint[] data = gson.fromJson(rest.getJson(url, getToken()), GetAllEndPoint[].class);
		for (GetAllEndPoint getAllEndPoint : data) {
			if (getAllEndPoint.getEndpointType().equals(type)) {
				return getAllEndPoint.getEpId();
			}
		}

		return "";

	}

	/**
	 * Method to Get Product Line ID
	 * 
	 * @param productLineName
	 * @param token
	 */
	public String getProductMasterId(String productLineName) {
		Map<String, String> map = new HashMap<String, String>();
		String productLineId = null;
		String getEndPointUrl = Constants.CORE_SERVICE + "/api/v1/company/" + tenantId + "/productlines";
		Gson gson = new Gson();
		ProductMaster productline = gson.fromJson(rest.getJsonWithToken(getEndPointUrl, getToken()),
				ProductMaster.class);
		ProductMasterData[] data = productline.getData();
		for (ProductMasterData s : data) {
			map.put(s.getName(), s.getProductLineId());
			if (s.getName().equals(productLineName)) {
				productLineId = s.getProductLineId();
			}
		}
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (entry.getKey().equals(productLineName)) {
				break;
			}
		}
		return productLineId;
	}
	// GET
	// virtualproduct

	public String getvirtualProductID(String productLineId, String deviceId) {
		Map<String, String> map = new HashMap<String, String>();
		String virtualProdId = null;
		String prodId = getProductId(deviceId);
		String url = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + productLineId
				+ "/virtualproduct";
		Gson gson = new Gson();
		ProductMasterVirtualProducts vProduct = gson.fromJson(rest.getJsonWithToken(url, getToken()),
				ProductMasterVirtualProducts.class);
		VirtualProductDetails[] vProdDetail = vProduct.getData();
		for (VirtualProductDetails p : vProdDetail) {
			map.put(p.getProductId(), p.getVirtualProductId());
			if (p.getProductId().equals(prodId)) {
				virtualProdId = p.getVirtualProductId();
				break;
			}
		}

		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (entry.getKey().equals(virtualProdId)) {
				break;
			}
		}
		return virtualProdId;
	}

	public List<String> getProductLineAttributeData(String productLineId) {
		List<String> list = new ArrayList<>();
		String url = Constants.CORE_SERVICE + "/api/v1/company/" + tenantId + "/productlines/" + productLineId
				+ "/attributes";
		Gson gson = new Gson();
		ConfigureAttribute product = null;
		try {
			product = gson.fromJson(rest.getJsonWithToken(url, getToken()), ConfigureAttribute.class);
		} catch (JsonSyntaxException | IllegalStateException e) {
			e.getMessage();
		}

		List<Attributes> attr = product.getAttributes();
		for (Attributes p : attr) {
			list.add(p.getName());
		}
		return list;
	}

	/**
	 * Method to Get Product Line IDerwe
	 * 
	 * @param productLineSKU
	 * @throws ParseException
	 * @throws IOException
	 * @throws URISyntaxException
	 */

	public String getDataTypeId(String dataTypeName) {
		String dataTypeId = null;
		String apiUrl = Constants.CORE_SERVICE + "/api/v1/company/" + tenantId + "/datatypes";
		Gson gson = new Gson();
		DataTypes[] dataType = gson.fromJson(rest.getJson(apiUrl, getToken()), DataTypes[].class);
		for (DataTypes s : dataType) {
			if (s.getName().equals(dataTypeName)) {
				dataTypeId = s.getId();
				break;
			}
		}
		return dataTypeId;
	}

	public List<String> getProductLineSettingData(String productLineId) {
		List<String> list = new ArrayList<>();
		String url = Constants.CORE_SERVICE + "/api/v1/company/" + tenantId + "/productlines/" + productLineId
				+ "/settings";
		Gson gson = new Gson();
		ProductMasterSetting product = null;
		try {
			product = gson.fromJson(rest.getJsonWithToken(url, getToken()), ProductMasterSetting.class);
		} catch (JsonSyntaxException | IllegalStateException e) {
			e.getMessage();
		}
		Settings[] attr = product.getSettings();
		for (Settings sett : attr) {
			list.add(sett.getName());
		}

		return list;
	}

	public List<String> getDynamicEPData(String productLineId, String token, String mfgId) {
		List<String> list = new ArrayList<>();
		String url = Constants.CORE_SERVICE + "/api/v1/company/" + tenantId + "/productlines/" + productLineId
				+ "/endpoints/" + mfgId + "/attributes";
		Gson gson = new Gson();
		ConfigureAttribute product = null;
		try {
			product = gson.fromJson(rest.getJsonWithToken(url, getToken()), ConfigureAttribute.class);
		} catch (JsonSyntaxException | IllegalStateException e) {
			e.getMessage();
		}
		List<Attributes> attr = product.getAttributes();
		for (Attributes p : attr) {
			list.add(p.getName());
		}
		return list;
	}

	public void updatedJiraStatus(String ticketNo, String transitionId) {
		JSONParser parser = new JSONParser();
		String jiraUrl = Constants.JIRA_API + "/rest/api/latest/issue/" + ticketNo
				+ "/transitions?expand=transitions.fields";
		String addEndPoint = "{\"transition\":{\"id\":\"" + transitionId + "\"}}";
		Object obj;
		String res = null;
		try {
			obj = parser.parse(addEndPoint);
			JSONObject jsonObject = (JSONObject) obj;
			res = rest.postJiraApi(jiraUrl, jsonObject);
		} catch (ParseException e) {
			log.debug("Update Jira Ticket status  failed due to " + res);
		}

	}

	public Map<String, String> getJiraTransitionId(String ticketNo) {
		String jiraUrl = Constants.JIRA_API + "/rest/api/latest/issue/" + ticketNo + "/transitions";
		Gson gson = new Gson();
		TransitionDetails transitionDetails = gson.fromJson(rest.getJiraApi(jiraUrl), TransitionDetails.class);
		Transitions[] trans = transitionDetails.getTransitions();
		Map<String, String> map = new HashMap<>();
		for (Transitions id : trans) {
			map.put(id.getName(), id.getId());
		}
		return map;
	}

	public void changeJiraStatus(String methodName, String testCaseStatus) {
		String[] name = methodName.split("_");
		String ticketNo = null;
		if (name != null && name.length > 1) {
			/*
			 * ticketNo = name[0] + "-" + name[1]; Map<String, String> map =
			 * getJiraTransitionId(ticketNo); Iterator iter = (Iterator)
			 * map.entrySet().iterator(); while (iter.hasNext()) { Map.Entry entry =
			 * (Map.Entry) iter.next(); if (entry.getKey().equals(testCaseStatus)) {
			 * updatedJiraStatus(ticketNo, entry.getValue().toString()); break; } }
			 */} else
			log.error("Test case no not mapped");
	}

	/**
	 * Method to add Product Line through API
	 * 
	 * @param productLinename
	 * @param sku
	 * @return response status
	 */
	public String addProductMaster(String productLinename, String sku) {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines";
		CreateProductMaster createProductLine = new CreateProductMaster();
		createProductLine.setName(productLinename);
		createProductLine.setDescription("Product Master created By ATS ");
		createProductLine.setIndustryId("f789254a-560d-4271-852d-e32ae08233b3");
		createProductLine.setSku(sku);
		ObjectMapper mapper = new ObjectMapper();
		String addProductLineResponse = null;
		try {
			String jsonStr = mapper.writeValueAsString(createProductLine);
			HttpResponse response = rest.postRequest(apiUrl, jsonStr, getToken());
			response.getStatusLine().getStatusCode();
			HttpEntity entity = response.getEntity();
			addProductLineResponse = EntityUtils.toString(entity).replace("\"", "");
		} catch (org.apache.http.ParseException | IOException e) {
			log.debug("product master not added due to " + addProductLineResponse);
		}
		return addProductLineResponse;
	}

	/**
	 * Method to add Dynamic Ep to given Product Line details
	 * 
	 * @param plId(Product Line ID)
	 * @return
	 * @throws ParseException
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public String addPeripheral(String plId) {
		String apiUrl1 = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + plId + "/endpoints";
		DynamicEP dynamicEp = new DynamicEP();
		dynamicEp.setName("DEPNew");
		dynamicEp.setMfgId(MfgId);
		dynamicEp.setDescription("Peripheral Endpoint");
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = null;
		try {
			jsonStr = mapper.writeValueAsString(dynamicEp);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		HttpResponse response = rest.postRequest(apiUrl1, jsonStr, getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		String addDynamicEpResponse = null;
		try {
			addDynamicEpResponse = EntityUtils.toString(entity).replace("\"", "");
		} catch (org.apache.http.ParseException | IOException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return status + "," + addDynamicEpResponse;

	}

	/**
	 * Method to add Dynamic Ep to given Product Line details
	 * 
	 * @param plId(Product Line ID)
	 * @return
	 * @throws ParseException
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public String updatePeripheral(String plId, String dynamicEpId) {
		String apiUrl1 = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + plId + "/endpoints/"
				+ dynamicEpId + "";
		DynamicEP dynamicEp = new DynamicEP();
		dynamicEp.setName("DEPNew1");
		dynamicEp.setDescription("Dynamic Endpoint");
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = null;
		try {
			jsonInString = mapper.writeValueAsString(dynamicEp);
		} catch (JsonProcessingException e) {
			e.getMessage();
		}
		HttpResponse response = rest.putRequestUpdate(apiUrl1, jsonInString, getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		Gson gson = new Gson();
		ErrorResponse errorResponse = null;
		try {
			errorResponse = gson.fromJson(EntityUtils.toString(entity), ErrorResponse.class);
		} catch (JsonSyntaxException | org.apache.http.ParseException | IOException e) {
			e.getMessage();
		}
		if (status >= 200 & status < 205) {
			return status + "";
		}
		return errorResponse.getMsg();
	}

	/**
	 * Method to add Dynamic Ep Custom Field details for the Given PLID(productLine
	 * ID)
	 * 
	 * @param plId
	 * @param order
	 */
	public int addDynamicEPCustomFields(String plId, String order)
			throws ParseException, IllegalStateException, IOException {
		String apiUrl1 = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + plId + "/endpoints/"
				+ MfgId + "/customfields";
		String APIkey = "API" + cu.generateRandomID();
		List<UserField> userfield1 = new ArrayList<UserField>();
		UserField userField = new UserField();
		userField.setName("UserField1" + cu.randomName());
		userField.setDataType("2cd5d39f-4b39-4690-b201-8126b33ca71e");
		userField.setOrder(order);
		userField.setDescription("UserField_" + cu.randomName());
		userField.setApiKey(APIkey);
		userfield1.add(userField);
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(userfield1);
		HttpResponse response = rest.postRequest(apiUrl1, jsonStr, getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		String addDynamicEPCustomFields = EntityUtils.toString(entity);
		addDynamicEPCustomFields = addDynamicEPCustomFields.replace("\"", "");
		return status;

	}

	/**
	 * Method to Update Product Line details
	 * 
	 * @param plId
	 * @return String response
	 * @throws ParseException
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public int updateProductMaster(String productMasterId, String updatedName) {
		String description = updatedName + cu.generateRandomNumber();
		String jiraUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + productMasterId;
		CreateProductMaster obj = new CreateProductMaster();
		obj.setName("01-ATS PM");
		obj.setDescription(description);
		obj.setIndustryId(Constants.INDUSTRY_ID);
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = null;
		try {
			jsonInString = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		HttpResponse response = rest.putRequestUpdate(jiraUrl, jsonInString, getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		Gson gson = new Gson();
		ErrorResponse errorResponse = null;
		try {
			errorResponse = gson.fromJson(EntityUtils.toString(entity), ErrorResponse.class);
		} catch (JsonSyntaxException | org.apache.http.ParseException | IOException e) {
			e.getMessage();
		}
		if (status >= 200 & status < 205) {
			return status;
		}
		return status;
		// return errorResponse.getMsg();
	}

	/**
	 * Method to add event Template to given Product Line
	 * 
	 * @throws IOException
	 * @throws ParseException
	 * @throws IllegalStateException
	 */

	public int addTemplate(String cuid, String sku, String name, int deliveryId, int localId, int eventAction,
			String mfgId, String priority, String opType) {
		String apiUrl = Constants.NOTIFICATION_SERVICE + "events/templates";
		List<Integer> deliveryMethod = new ArrayList<Integer>();
		// deliveryMethod.add(1);
		deliveryMethod.add(5);

		List<Integer> role = new ArrayList<Integer>();
		role.add(4);
		AddTemplate addTemplate = new AddTemplate();
		addTemplate.setCuid(cuid);
		addTemplate.setSku(sku);
		addTemplate.setName(name);
		addTemplate.setMessage(name);
		addTemplate.setUsers("2");
		addTemplate.setRoles(role);
		addTemplate.setDeliveryMethod(deliveryMethod);
		addTemplate.setOutputType(opType);
		addTemplate.setTemplateType("1");
		addTemplate.setLocalId(localId);
		addTemplate.setEventAction(eventAction);
		addTemplate.setMfgId(mfgId);
		if (priority == "Low") {
			addTemplate.setPriority("0");
		} else {
			addTemplate.setPriority("1");
		}
		addTemplate.setHeader(new ArrayList<String>());
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = null;
		try {
			jsonStr = mapper.writeValueAsString(addTemplate);
		} catch (JsonProcessingException e) {
			log.debug("Error while creating notification template of " + name);
		}
		HttpResponse response = rest.postRequestNotification(apiUrl, jsonStr, getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		try {
			templateId = EntityUtils.toString(entity);
		} catch (org.apache.http.ParseException | IOException e) {
			log.debug("Error while converting notification template Id to string " + templateId);
		}
		templateId = templateId.replace("\"", "");
		return status;
	}

	/**
	 * Method to Subscribe Template
	 */
	public int subscribeTemplate(String skuId, String cuid, int deliveryId) {
		String apiUrl = Constants.NOTIFICATION_SERVICE + "template/" + templateId + "/subscribe";
		Subscribe subscribe = new Subscribe();
		List<Integer> deliveryMethod = new ArrayList<Integer>();
		// deliveryMethod.add(1);
		deliveryMethod.add(5);
		subscribe.setDeliveryMethods(deliveryMethod);
		subscribe.setUserEmail(testNg.getUserName());
		subscribe.setCuId(cuid);
		subscribe.setProductLineSku(skuId);
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = null;
		try {
			jsonStr = mapper.writeValueAsString(subscribe);
		} catch (JsonProcessingException e) {
			log.debug("Error while subscribe notification template " + templateId);
		}
		HttpResponse response = rest.postRequestNotification(apiUrl, jsonStr, getToken());
		int status = response.getStatusLine().getStatusCode();
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
			br.close();
		} catch (UnsupportedOperationException | IOException e) {
			log.debug("Error while closing subscribe notification InputStreamReader ");
		}

		return status;
	}

	/**
	 * Method To set User Preference
	 * 
	 * @param useremail
	 * @param cuid
	 * @paramm webHookUri
	 * @return status
	 * @throws Exception///POST /
	 */
	public int setUserPreference(String cuid, String userEmail, String webHookUrl, String authentication,
			String authUri) {
		String apiUrl = Constants.NOTIFICATION_SERVICE + "events/userpreference";
		URIBuilder uRIBuilder;
		String url = null;
		try {
			uRIBuilder = new URIBuilder(apiUrl);
			uRIBuilder.addParameter("userEmail", userEmail);
			uRIBuilder.addParameter("cuId", cuid);
			url = uRIBuilder.build().toURL().toString();
		} catch (URISyntaxException | MalformedURLException e) {
			log.debug("UserPreference url error ");
		}

		SetUserPreference userpreference = new SetUserPreference();
		userpreference.setPhoneNo("4562136987");
		userpreference.setWebhookUri(webHookUrl);
		userpreference.setWebhookAuthencationTypeId(authentication);
		userpreference.setAuthUri(authUri);
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = null;
		try {
			jsonStr = mapper.writeValueAsString(userpreference);
		} catch (JsonProcessingException e) {
			log.debug("Error while creating UserPreference json");
		}
		HttpResponse response = rest.putRequest(url, jsonStr, getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		String setUserPreferenceResponse;
		try {
			setUserPreferenceResponse = EntityUtils.toString(entity);
			setUserPreferenceResponse = setUserPreferenceResponse.replace("\"", "");
		} catch (org.apache.http.ParseException | IOException e) {
			log.debug("Error while creating UserPreference");
		}

		return status;
	}

	/**
	 * Method to Add Product Attribute
	 * 
	 * @param plId
	 * @param localId
	 * @return
	 * @throws Exception
	 * @throws ParseException
	 */
	public String addProductAttribute(String plId, int localId, String dataType) throws ParseException, Exception {
		String apiUrl1 = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + plId
				+ "/attributes";
		String status = addAttribute(apiUrl1, localId, dataType);
		return status;
	}

	/**
	 * Method to Add Dynamic EP Attribute
	 * 
	 * @param plId
	 * @param localId
	 * @return
	 * @throws Exception
	 * @throws ParseException
	 */
	public String addPeripheralAttribute(String plId, int localId, String dataType) throws ParseException, Exception {
		String apiUrl1 = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + plId + "/endpoints/"
				+ MfgId + "/attributes";
		String status = addAttribute(apiUrl1, localId, dataType);
		return status;
	}

	/**
	 * Method to Add Product Attribute
	 * 
	 * @throws Exception
	 * @throws ParseException
	 */
	public String addAttribute(String URL, int localId, String dataType)
			throws IllegalStateException, IOException, ParseException, Exception {
		ConfigureAttribute productLineAttribute = new ConfigureAttribute();
		String dataTypeId = getDataTypeId(dataType);
		List<Attributes> list = new ArrayList<Attributes>();
		Attributes attributes = new Attributes();
		String AttributeName = dataType + " Attr_" + cu.randomName();
		attributes.setName(AttributeName);
		attributes.setGroupName(dataType);
		attributes.setDescription(AttributeName);
		attributes.setDataType(dataTypeId);
		attributes.setLocalId(localId);
		List<Constraints> listNew = new ArrayList<Constraints>();
		Constraints constraints = new Constraints();
		listNew.add(constraints);
		attributes.setConstraints(null);
		list.add(attributes);
		productLineAttribute.setAttributes(list);
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(productLineAttribute);
		HttpResponse response = rest.postRequest(URL, jsonStr, getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		String addAttributeResponse = EntityUtils.toString(entity);
		addAttributeResponse = addAttributeResponse.replace("\"", "");
		return status + "," + addAttributeResponse;
	}

	/**
	 * Method to Add Product Attribute
	 * 
	 * @throws URISyntaxException
	 * @throws ParseException
	 */
	public int addAttributeWithConstarintsProduct(String plId, int localId, String dataType)
			throws IllegalStateException, IOException, ParseException, URISyntaxException {
		String apiUrl1 = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + plId
				+ "/attributes";
		ConfigureAttribute productLineAttribute = new ConfigureAttribute();
		String dataTypeId = getDataTypeId(dataType);
		List<Attributes> list = new ArrayList<Attributes>();
		Attributes attributes = new Attributes();
		String AttributeName = dataType + "_Attr_" + cu.randomName();
		attributes.setName(AttributeName);
		attributes.setGroupName(dataType);
		attributes.setDescription(AttributeName);
		attributes.setDataType(dataTypeId);
		attributes.setLocalId(localId);
		List<Constraints> listNew = new ArrayList<Constraints>();
		Constraints constraints = new Constraints();
		constraints.setType(Constants.MAX);
		constraints.setValue("100");
		listNew.add(constraints);
		// attributes.setConstraints(listNew);
		list.add(attributes);
		productLineAttribute.setAttributes(list);
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(productLineAttribute);
		HttpResponse response = rest.postRequest(apiUrl1, jsonStr, getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		String addAttributeResponse = EntityUtils.toString(entity);
		addAttributeResponse = addAttributeResponse.replace("\"", "");
		return status;
	}

	/**
	 * Method to Update Product Attribute details
	 * 
	 * @throws URISyntaxException
	 * @throws ParseException
	 */
	public int updateProductAttribute(String plId, int localId, String datatype)
			throws IllegalStateException, IOException, ParseException, URISyntaxException {
		String apiUrl1 = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + plId
				+ "/attributes/" + localId + "";
		String dataTypeId = getDataTypeId(datatype);
		Attributes attributes = new Attributes();
		String AttributeName = datatype + "_Attr_" + cu.randomName();
		attributes.setName(AttributeName);
		attributes.setGroupName(AttributeName);
		attributes.setDescription(AttributeName);
		attributes.setDataType(dataTypeId);
		attributes.setConstraints(null);
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(attributes);
		HttpResponse response = rest.putRequestUpdate(apiUrl1, jsonStr, getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		String updateProductAttribute = EntityUtils.toString(entity);
		updateProductAttribute = updateProductAttribute.replace("\"", "");
		return status;
	}

	/**
	 * Verify added setting
	 */
	public boolean verifyAddedSettings(String productLineId, int localId) throws Exception {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + productLineId
				+ "/settings";
		Gson gson = new Gson();
		ProductMasterSetting details = gson.fromJson(rest.getJson(apiUrl, getToken()), ProductMasterSetting.class);
		Settings[] data = details.getSettings();
		for (Settings s : data) {
			if (s.getFid() == localId) {
				return true;
			}
		}
		return false;

	}

	/**
	 * Verify added setting
	 */
	public boolean verifyPeripheralSettings(String productLineId, int localId) {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + productLineId
				+ "/endpoints/" + MfgId + "/settings";
		Gson gson = new Gson();
		ProductMasterSetting details = gson.fromJson(rest.getJson(apiUrl, getToken()), ProductMasterSetting.class);
		Settings[] data = details.getSettings();
		for (Settings s : data) {
			if (s.getFid() == localId) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Verify added Attribute
	 * 
	 * @throws ExceptionGET /api/v1/company/{companyId}/productlines/{productLineId}/attributes
	 */
	public boolean verifyAddedAttribute(String productLineId, int localId) throws Exception {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + productLineId
				+ "/attributes";
		Gson gson = new Gson();
		ProductMasterAttributes details = gson.fromJson(rest.getJson(apiUrl, getToken()),
				ProductMasterAttributes.class);
		Attributes[] data = details.getAttributes();
		for (Attributes s : data) {
			if (s.getLocalId() == localId) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Verify added Peripheral Attribute
	 * 
	 * @throws ExceptionGET /api/v1/company/{companyId}/productlines/{productLineId}/attributes
	 */
	public boolean verifyAddedPeripheralAttribute(String productLineId, int localId) throws Exception {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + productLineId
				+ "/endpoints/" + MfgId + "/attributes";
		Gson gson = new Gson();
		ProductMasterAttributes details = gson.fromJson(rest.getJson(apiUrl, getToken()),
				ProductMasterAttributes.class);
		Attributes[] data = details.getAttributes();
		for (Attributes s : data) {
			if (s.getLocalId() == localId) {
				return true;
			}
		}
		return false;
	}

	/** Method to Add Reporting Group */
	public String addReportingGroup(String reportingGrpName) throws IllegalStateException, IOException {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/groups/";
		GroupDetails reportingGroups = new GroupDetails();
		reportingGroups.setName(reportingGrpName);
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(reportingGroups);
		HttpResponse response = rest.postRequest(apiUrl, jsonStr, getToken());
		HttpEntity entity = response.getEntity();
		String groupId = EntityUtils.toString(entity).replace("\"", "");
		return groupId;
	}

	/**
	 * Method to get Field Id of Custom fields added
	 */
	public String getReportingGroup(String groupId) throws IOException, ParseException {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/groups/" + groupId;
		Gson gson = new Gson();
		GroupDetails groupDetails = gson.fromJson(rest.getJson(apiUrl, getToken()), GroupDetails.class);
		return groupDetails.getName();
	}

	/** Method to update Reporting Group */
	public int updateReportingGroup(String groupId) throws IllegalStateException, IOException {
		String apiUrl1 = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/groups/" + groupId;
		String updatedGroupName = "updatePL " + cu.generateRandomNumber();
		GroupDetails reportingGroups = new GroupDetails();
		reportingGroups.setName(updatedGroupName);
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(reportingGroups);
		HttpResponse response = rest.putRequestUpdate(apiUrl1, jsonInString, getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		Gson gson = new Gson();
		ErrorResponse errorResponse = gson.fromJson(EntityUtils.toString(entity), ErrorResponse.class);
		if (status >= 200 & status < 205) {
			return status;
		}
		log.debug(errorResponse.getMsg() + status);
		return status;
	}

	/** Method to Add Reporting Group Custom Field */
	public int addReportingGroupCustomField(String name, String order) throws IllegalStateException, IOException {
		String apiUrl1 = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/groups/customfields";
		String userFieldName = "UserFieldsGRP_" + cu.randomName();
		String apiKey = "API_" + cu.randomName();
		GroupCustomFields groupCustomFields = new GroupCustomFields();
		groupCustomFields.setName(userFieldName);
		groupCustomFields.setDescription("Desc_" + userFieldName);
		groupCustomFields.setOrder(order);
		groupCustomFields.setDataType("df7fa1bf-be62-4d2e-8ac5-72913ebc1042");
		groupCustomFields.setApiKey(apiKey);
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(groupCustomFields);
		HttpResponse response = rest.postRequest(apiUrl1, jsonStr, getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		String addGRPCustomFieldResponse = EntityUtils.toString(entity);
		addGRPCustomFieldResponse = addGRPCustomFieldResponse.replace("\"", "");
		return status;

	}

	/** Method to update Reporting Group custom Field */
	public int updateReportingGroupCustomFieldValue(String name, String groupId)
			throws IllegalStateException, IOException, Exception {
		String getIdURL = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/groups/" + groupId
				+ "/customfields";
		String ID = getCustomFieldID(getIdURL, name);
		UserFieldValue fieldValue = new UserFieldValue();
		List<UserFieldValue> list = new ArrayList<UserFieldValue>();
		fieldValue.setId(ID);
		fieldValue.setValue("123");
		list.add(fieldValue);
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(list);
		HttpResponse response = rest.putRequestUpdate(getIdURL, jsonInString, getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		String updateCustomFieldValue = EntityUtils.toString(entity);
		updateCustomFieldValue = updateCustomFieldValue.replace("\"", "");
		return status;

	}

	/**
	 * Method to get Field Id of Custom fields added
	 */
	public String getCustomFieldID(String URL, String name) throws IOException, ParseException {
		Map<String, String> map = new HashMap<String, String>();
		String Id = null;
		Gson gson = new Gson();
		UserFieldID[] userfield = gson.fromJson(rest.getJson(URL, getToken()), UserFieldID[].class);
		for (UserFieldID s : userfield) {
			if (s.getName().equals(name)) {
				Id = s.getId();
				map.put(s.getName(), s.getId());
			}
		}
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (entry.getKey().equals(name)) {
				break;
			}
		}
		return Id;
	}

	/**
	 * Method to get Command Id of the added commandsfor the given Command name
	 */
	public String getCommandID(String URL, String name, String token1) throws IOException, ParseException {
		Map<String, String> map = new HashMap<String, String>();
		String Id = null;
		Gson gson = new Gson();
		GelAllCommands commandDetails = gson.fromJson(rest.getJson(URL, getToken()), GelAllCommands.class);
		CommandGroups[] commandGroups = commandDetails.getGroups();
		for (CommandGroups p : commandGroups) {
			CommandDetails[] cmd = p.getCommands();
			for (CommandDetails c : cmd) {
				map.put(c.getOnScreenDisplay(), c.getId());
				if (c.getOnScreenDisplay().equals(name)) {
					Id = c.getId();
				}

			}
		}
		return Id;
	}

	/**
	 * Method to get Uder Field Id for the user field with given Name
	 */
	public String getUserFieldID(String URL, String order, String token1) throws IOException, ParseException {
		Map<String, String> map = new HashMap<String, String>();
		String Id = null;
		Gson gson = new Gson();
		UserFieldList userfield = gson.fromJson(rest.getJson(URL, getToken()), UserFieldList.class);
		UserFields[] userfield1 = userfield.getUserFields();
		for (UserFields s : userfield1) {
			map.put(s.getOrder(), s.getFieldId());
			if (s.getOrder().equals(order)) {
				Id = s.getFieldId();
			}
		}
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (entry.getKey().equals(order)) {
				break;
			}
		}
		return Id;
	}

	/** Method to Delete Product Attribute */
	public int deleteAttribute(int localId, String plId) throws IllegalStateException, IOException {
		String deleteAttributeURL = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + plId
				+ "/attributes/" + localId + "";
		return rest.delete(deleteAttributeURL, getToken());
	}

	/**
	 * Method to Add Product Settings
	 * 
	 * @throws URISyntaxException
	 * @throws ParseException
	 */
	public String addProductsetting(String plId, int fid, String dataType, int formType)
			throws IllegalStateException, IOException, ParseException, URISyntaxException {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + plId + "/settings";
		String status = addsetting(apiUrl, fid, dataType, formType);
		return status;

	}

	/**
	 * Method to Add DEP Settings
	 * 
	 * @throws URISyntaxException
	 * @throws ParseException
	 */
	public String addPeripheralSetting(String plId, int fid, String dataType, int formType) {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + plId + "/endpoints/"
				+ MfgId + "/settings";
		String status = null;
		try {
			status = addsetting(apiUrl, fid, dataType, formType);
		} catch (IllegalStateException e) {
			log.error("Error ehile creating Peripheral Setting template for " + dataType);
		}
		return status;
	}

	/**
	 * Method to Add Settings
	 * 
	 * @throws URISyntaxException
	 * @throws ParseException
	 */
	public String addsetting(String URL, int fid, String dataType, int formType) {
		String settingName = "Setting_" + cu.randomName();
		Setting setting = new Setting();
		String dataTypeId = getDataTypeId(dataType);
		List<Settings> settingDetails = new ArrayList<Settings>();
		Settings details = new Settings();
		details.setName(dataType + " " + settingName);
		details.setGroupname(dataType);
		details.setDatatype(dataTypeId);
		details.setFid(fid);
		if (dataType.equals("Json")) {
			details.setDefaultvalue("{}");
		} else {
			details.setDefaultvalue("1");
		}
		details.setFormType(formType);
		List<Constraints> list = new ArrayList<Constraints>();
		Constraints constraints = new Constraints();
		/*
		 * constraints.setType("Max"); constraints.setValue("1000");
		 */ list.add(constraints);
		details.setConstraints(null);
		List<ListOfPossibleValues> listOfValue = new ArrayList<ListOfPossibleValues>();
		ListOfPossibleValues possibleValues = new ListOfPossibleValues();
		if (dataType.equals("Json")) {
			possibleValues.setValue("{}");
			possibleValues.setDefault(true);
		} else {
			possibleValues.setValue("1");
			possibleValues.setDefault(true);
		}
		listOfValue.add(possibleValues);
		details.setListOfPossibleValues(listOfValue);
		settingDetails.add(details);
		setting.setSettings(settingDetails);
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = null;
		try {
			jsonStr = mapper.writeValueAsString(setting);
		} catch (JsonProcessingException e) {
			log.error("Error while creating json for settings template");
		}

		HttpResponse response = rest.postRequest(URL, jsonStr, getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		String addSettingResponse = null;
		try {
			addSettingResponse = EntityUtils.toString(entity).replace("\"", "");
		} catch (org.apache.http.ParseException | IOException e) {
			log.error("create settings template failed");
		}

		return status + "," + addSettingResponse;
	}

	/**
	 * Method to configure LocationManager Settings Method to Add Settings
	 * 
	 * @throws URISyntaxException
	 * @throws ParseException
	 */
	public int addLocationManagersetting(String plId, String settingName, String groupName, int fid, String dataType,
			int formType, String defalutVal)
			throws IllegalStateException, IOException, ParseException, URISyntaxException {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + plId + "/settings";
		String dataTypeId = getDataTypeId(dataType);
		Setting setting = new Setting();
		List<Settings> settingDetails = new ArrayList<Settings>();
		Settings details = new Settings();
		details.setName(settingName);
		details.setGroupname(groupName);
		details.setDatatype(dataTypeId);
		details.setFid(fid);
		details.setDefaultvalue(defalutVal);
		details.setFormType(formType);
		details.setConstraints(null);
		settingDetails.add(details);
		setting.setSettings(settingDetails);
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(setting);
		HttpResponse response = rest.postRequest(apiUrl, jsonStr, getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		String addSettingResponse = EntityUtils.toString(entity);
		addSettingResponse = addSettingResponse.replace("\"", "");
		return status;
	}

	/** Method to update Product Settings */
	public int updateProductsetting(String plId, int fid) throws IllegalStateException, IOException {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + plId + "/settings";
		String settingName = "Setting_" + cu.randomName();
		Setting setting = new Setting();
		List<Settings> settingDetails = new ArrayList<Settings>();
		Settings details = new Settings();
		details.setName(settingName);
		details.setGroupname(settingName);
		details.setDatatype("2cd5d39f-4b39-4690-b201-8126b33ca71e");
		details.setFid(fid);
		details.setDefaultvalue("1");
		details.setFormType(1);
		List<Constraints> list = new ArrayList<Constraints>();
		Constraints constraints = new Constraints();
		list.add(constraints);
		details.setConstraints(null);
		List<ListOfPossibleValues> listOfValue = new ArrayList<ListOfPossibleValues>();
		ListOfPossibleValues possibleValues = new ListOfPossibleValues();
		listOfValue.add(possibleValues);
		details.setListOfPossibleValues(null);
		settingDetails.add(details);
		setting.setSettings(settingDetails);
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(setting);
		HttpResponse response = rest.putRequestUpdate(apiUrl, jsonStr, getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		String updateSettingResponse = EntityUtils.toString(entity);
		updateSettingResponse = updateSettingResponse.replace("\"", "");
		return status;
	}

	/**
	 * Method to delete setting Product
	 * 
	 * @return response status
	 */
	public int deleteProductsetting(String plId, int fid) throws IllegalStateException, IOException {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + plId + "/settings/"
				+ fid + "";
		int status = rest.delete(apiUrl, getToken());
		return status;
	}

	/**
	 * Method to Add Product Commands
	 * 
	 * @param plId
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 * @throws URISyntaxException
	 * @throws ParseException
	 */
	public String addProductCommands(String name, String plId, int fomType, String dataType)
			throws IllegalStateException, IOException, ParseException, URISyntaxException {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + plId + "/Commands";
		dataType = getDataTypeId(dataType);
		String commandId = addCommands(name, apiUrl, plId, fomType, dataType);
		return commandId;
	}

	/**
	 * Method to Add Dynamic EP Commands
	 * 
	 * @param plId
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public String addPeripheralCommands(String name, String plId, int fomType, String dataType) throws Exception {
		String apiUrl1 = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + plId + "/endpoints/"
				+ MfgId + "/Commands";
		dataType = getDataTypeId(dataType);
		String commandId = addCommands(name, apiUrl1, plId, fomType, dataType);
		return commandId;
	}

	/** method to add product line command */
	public String addCommands(String name, String URL, String plId, int formType, String dataType)
			throws IllegalStateException, IOException {
		Commands commands = new Commands();
		commands.setOnScreenDisplay(name);
		commands.setDisplayGroupName(name);
		commands.setDeviceCommand(name);
		List<Parameters> parameters = new ArrayList<Parameters>();
		Parameters param = new Parameters();
		param.setConstraint(null);
		param.setDataType(dataType);
		param.setFormType(formType);
		List<ListOfPossibleValues> listOfValue = new ArrayList<ListOfPossibleValues>();
		ListOfPossibleValues possibleValues = new ListOfPossibleValues();
		listOfValue.add(possibleValues);

		if (name.contains("DropDownCommandForString") || name.contains("DropDownCommandForJson")) {
			List<ListOfPossibleValues> list = new ArrayList<>();
			ListOfPossibleValues lpv = new ListOfPossibleValues();
			lpv.setDefault(false);
			lpv.setValue("{\"A\":\"1\"}");
			list.add(lpv);
			lpv.setDefault(false);
			lpv.setValue("{\"B\":\"2\"}");
			list.add(lpv);
			param.setListOfPossibleValues(list);
		} else if (name.contains("DropDownCommandForBoolean") || name.contains("DropDownCommandForInt")) {
			List<ListOfPossibleValues> list = new ArrayList<>();
			ListOfPossibleValues lpv = new ListOfPossibleValues();
			lpv.setDefault(false);
			lpv.setValue("0");
			list.add(lpv);
			lpv.setDefault(false);
			lpv.setValue("1");
			list.add(lpv);
			param.setListOfPossibleValues(list);
		}

		param.setName(name);
		parameters.add(param);
		commands.setParameters(parameters);
		commands.setRr(true);
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(commands);
		HttpResponse response = rest.postRequest(URL, jsonStr, getToken());
		HttpEntity entity = response.getEntity();
		String commandResponse = EntityUtils.toString(entity).replace("\"", "");
		return commandResponse;
	}

	/** method to add product line command */
	public int sendCommands(String vpId, String pmId, String name, String type, String value)
			throws IllegalStateException, IOException {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/products/" + vpId + "/command";
		SendCommand command = new SendCommand();
		command.setPlId(pmId);
		command.setEpId(getAllEndPoint(vpId, type));
		command.setCmdname(name);
		command.setCnsr("3");
		command.setCmtId(getAllPMCommand(pmId, name));
		command.setFce(true);
		command.setVer("1.0");
		command.setRr(true);
		List<SendCommandParameter> list = new ArrayList<SendCommandParameter>();
		SendCommandParameter param = new SendCommandParameter();
		param.setName(name);
		param.setValue(value);
		list.add(param);
		if (!name.contains("NA")) {
			command.setParam(list);
		}

		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(command);
		HttpResponse response = rest.postRequest(apiUrl, jsonStr, getToken());
		int status = response.getStatusLine().getStatusCode();
		EntityUtils.toString(response.getEntity());
		return status;
	}

	/**
	 * method to update product line command
	 * 
	 * @throws Exception
	 */
	public int updateProductCommands(String plId, String name) throws IllegalStateException, IOException, Exception {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + plId + "/Commands";
		String ID = getCommandID(apiUrl, name, getToken());
		String apiUrlCommands = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + plId
				+ "/Commands/" + ID + "";
		String commandName = "command-" + cu.randomName();
		Commands commands = new Commands();
		commands.setOnScreenDisplay(commandName);
		commands.setDisplayGroupName(commandName);
		commands.setDeviceCommand("cmd" + cu.generateRandomID());
		List<Parameters> parameters = new ArrayList<Parameters>();
		Parameters param = new Parameters();
		param.setConstraint(null);
		param.setDataType("2cd5d39f-4b39-4690-b201-8126b33ca71e");
		param.setFormType(1);
		List<ListOfPossibleValues> listOfValue = new ArrayList<ListOfPossibleValues>();
		ListOfPossibleValues possibleValues = new ListOfPossibleValues();
		listOfValue.add(possibleValues);
		param.setListOfPossibleValues(null);
		param.setName(commandName);
		parameters.add(param);
		commands.setParameters(parameters);
		commands.setRr(true);
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(commands);
		HttpResponse response = rest.putRequestUpdate(apiUrlCommands, jsonStr, getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		String updateCommandResponse = EntityUtils.toString(entity);
		updateCommandResponse = updateCommandResponse.replace("\"", "");
		return status;
	}

	/**
	 * Method to delete Product command
	 * 
	 * @return response status
	 * @throws Exception
	 */
	public int deleteProductcommand(String plId, String name) throws IllegalStateException, IOException, Exception {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + plId + "/Commands";
		String ID = getCommandID(apiUrl, name, getToken());
		String apiUrlCommands = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + plId
				+ "/Commands/" + ID + "";
		int status = rest.delete(apiUrlCommands, getToken());
		return status;
	}

	/**
	 * Method to add User Field details to Endpoint
	 * 
	 * @param plId
	 * @param order
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public int addPeripheralUserfield(String plId, String name, String order, String dataType) {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + plId + "/endpoints/"
				+ MfgId + "/customfields";
		int fid = 0;
		try {
			fid = addUserfield(apiUrl, name, order, dataType);
		} catch (IllegalStateException e) {
			e.getMessage();
		}
		return fid;
	}

	/**
	 * Method to add User Field details to Product
	 * 
	 * @param plId
	 * @param order
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 * @throws URISyntaxException
	 * @throws ParseException
	 */
	public int addProductUserfield(String plId, String name, String order, String dataTypeName) {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + plId
				+ "/product/userfield";
		String dataType = getDataTypeId(dataTypeName);
		int fid = addUserfield(apiUrl, dataTypeName, order, dataType);
		return fid;
	}

	public int addUserfield(String url, String name, String order, String dataType) {

		List<UserField> userfield1 = new ArrayList<UserField>();
		UserField userField = new UserField();
		userField.setName(name);
		userField.setDataType(dataType);
		userField.setOrder(order);
		userField.setDescription(name);
		userField.setApiKey(name);
		userfield1.add(userField);
		ObjectMapper mapper = new ObjectMapper();
		String userFieldid = null;
		int status = 0;
		try {
			String jsonStr = mapper.writeValueAsString(userfield1);
			HttpResponse response = rest.postRequest(url, jsonStr, getToken());
			status = response.getStatusLine().getStatusCode();
			HttpEntity entity = response.getEntity();
			userFieldid = EntityUtils.toString(entity).replace("\"", "");
		} catch (org.apache.http.ParseException | IOException e) {
			log.error("User field template not created");
		}
		return status;
	}

	/**
	 * Method to add Location Manager UserField
	 * 
	 * @param userFieldName
	 * @param description
	 * @param order
	 * @param dataType
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 * @throws ParseException
	 * @throws URISyntaxException
	 */
	public int addLocationManagerUserfield(String plId, String userFieldName, String description, String value,
			String order, String dataType) throws Exception {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/customfields";
		String dataTYpeId = getDataTypeId(dataType);
		List<UserField> userfield1 = new ArrayList<UserField>();
		UserField userField = new UserField();
		userField.setName(userFieldName);
		userField.setDataType(dataTYpeId);
		userField.setOrder(order);
		userField.setDescription(description);
		userField.setApiKey(order);
		userField.setValue(value);
		userfield1.add(userField);
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(userfield1);
		HttpResponse response = rest.postRequest(apiUrl, jsonStr, getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		String userFieldResponse = EntityUtils.toString(entity);
		userFieldResponse = userFieldResponse.replace("\"", "");
		setProductLineCustomFieldValue(userFieldName, plId, value);
		addProductUserfield(plId, userFieldName, value, order, dataType);

		return status;
	}

	public int addProductUserfield(String plId, String userFieldName, String value, String order, String dataType)
			throws IllegalStateException, IOException {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + plId
				+ "/product/userfield";
		int status = addUserfield(apiUrl, userFieldName, value, order, dataType);
		return status;
	}

	public int addUserfield(String url, String userFieldName, String value, String order, String dataType)
			throws IllegalStateException, IOException {
		List<UserField> userfield1 = new ArrayList<UserField>();
		UserField userField = new UserField();
		userField.setName(userFieldName);
		userField.setDataType(dataType);
		userField.setOrder(order);
		userField.setDescription(userFieldName);
		userField.setApiKey(value);
		userfield1.add(userField);
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(userfield1);
		HttpResponse response = rest.postRequest(url, jsonStr, getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		String userFieldResponse = EntityUtils.toString(entity);
		userFieldResponse = userFieldResponse.replace("\"", "");
		return status;
	}

	public int setProductLineCustomFieldValue(String name, String plId, String value)
			throws IllegalStateException, IOException, Exception {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + plId
				+ "/customfields";
		String ID = getCustomFieldID(apiUrl, name);
		UserFieldValue fieldValue = new UserFieldValue();
		List<UserFieldValue> list = new ArrayList<UserFieldValue>();
		fieldValue.setId(ID);
		fieldValue.setValue(value);
		list.add(fieldValue);
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(list);
		HttpResponse response = rest.putRequest(apiUrl, jsonInString, getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		String updateCustomFieldValue = EntityUtils.toString(entity);
		updateCustomFieldValue = updateCustomFieldValue.replace("\"", "");
		return status;

	}

	/**
	 * Method to add custom Field to ProductLine
	 * 
	 * @param name
	 * @param order of custom field
	 * @return status
	 */

	public int addProductMasterCustomField(String name, String order, String datatype)
			throws IllegalStateException, IOException {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/customfields";
		String apiKey = "api" + cu.generateRandomID();
		List<UserField> userfield1 = new ArrayList<UserField>();
		UserField userField = new UserField();
		userField.setName(name);
		userField.setDataType(datatype);
		userField.setOrder(order);
		userField.setDescription("UserField_" + cu.randomName());
		userField.setApiKey(apiKey);
		userfield1.add(userField);
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(userfield1);
		HttpResponse response = rest.postRequest(apiUrl, jsonStr, getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		String userFieldResponse = EntityUtils.toString(entity);
		userFieldResponse = userFieldResponse.replace("\"", "");
		return status;
	}

	/**
	 * Method to update custom Field to ProductLine
	 * 
	 * @param name
	 * @param order of custom field
	 * @return status
	 * @throws Exception
	 */

	public int updateProductMasterCustomField(String order, String datatype)
			throws IllegalStateException, IOException, Exception {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/customfields";
		int status = updateCustomField(order, apiUrl);
		return status;
	}

	/**
	 * Method to Update Product User Field details
	 * 
	 * @param name
	 * @param plId
	 * @return Status
	 */
	public int updateProductCustomField(String order, String plId)
			throws IllegalStateException, IOException, Exception {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + plId
				+ "/product/userfield";
		int status = updateCustomField(order, apiUrl);
		return status;
	}

	public int updatePeripheralCustomField(String order, String plId) {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + plId + "/endpoints/"
				+ MfgId + "/customfields";
		int status = updateCustomField(order, apiUrl);
		return status;
	}

	public int updateCustomField(String order, String url) {
		String apiKey = "api" + cu.generateRandomID();
		String id = null;
		try {
			id = getUserFieldID(url, order, getToken());
		} catch (IOException | ParseException e) {
			log.error("get userfield Id error ");
		}
		String apiUrlNew = url + "/" + id + "";
		UpdateUserField userField = new UpdateUserField();
		userField.setName("update" + cu.randomName());
		userField.setDescription("UserField_" + cu.randomName());
		userField.setApiKey(apiKey);
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = null;
		try {
			jsonStr = mapper.writeValueAsString(userField);
		} catch (JsonProcessingException e) {
			log.error("json error");
		}
		HttpResponse response = rest.putRequestUpdate(apiUrlNew, jsonStr, getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		try {
			EntityUtils.toString(entity).replace("\"", "");
		} catch (org.apache.http.ParseException | IOException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return status;
	}

	public String addPackageGroups(String plId, String name, String type, String ver)
			throws IllegalStateException, IOException, Exception {
		String url = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + plId + "/packagegroup";
		Thread.sleep(60000);
		PackageGroup packageGroup = new PackageGroup();
		packageGroup.setName(name + cu.randomName());
		packageGroup.setDescription(name + " description about " + cu.randomName());
		packageGroup.setType(type);
		packageGroup.setHardwareVersion("2.0.1");
		packageGroup.setVersion(ver);
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(packageGroup);
		HttpResponse response = rest.postRequest(url, jsonStr, getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		String addPackageResponse = EntityUtils.toString(entity).replace("\"", "");
		log.error("addPackageGroups " + status + " " + addPackageResponse + jsonStr);
		return status + "," + addPackageResponse;
	}

	/**
	 * Method to delete Product CustomField
	 * 
	 * @return response status
	 * @throws Exception
	 */
	public int deleteProductCustomField(String plId, String order)
			throws IllegalStateException, IOException, Exception {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + plId
				+ "/product/userfield";
		String ID = getUserFieldID(apiUrl, order, getToken());
		String apiUrlNew = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + plId
				+ "/product/userfield/" + ID + "";
		int status = rest.delete(apiUrlNew, getToken());
		return status;
	}

	/**
	 * Method to Forcedeactivate Product
	 * 
	 * @param virtualID
	 * @return response status
	 */
	public int forceDeactivateProduct(String virtualID) throws IllegalStateException, IOException {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/products/" + virtualID
				+ "/forceactivate";
		int status = rest.delete(apiUrl, getToken());
		return status;
	}

	/**
	 * Method to Update ProductLine customFiled value
	 * 
	 * @param name
	 * @param plId
	 */
	public int setProductMasterCustomFieldValue(String name, String plId)
			throws IllegalStateException, IOException, Exception {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + plId
				+ "/customfields";
		String ID = getCustomFieldID(apiUrl, name);
		UserFieldValue fieldValue = new UserFieldValue();
		List<UserFieldValue> list = new ArrayList<UserFieldValue>();
		fieldValue.setId(ID);
		fieldValue.setValue("123");
		list.add(fieldValue);
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(list);
		HttpResponse response = rest.putRequestUpdate(apiUrl, jsonInString, getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		String updateCustomFieldValue = EntityUtils.toString(entity);
		updateCustomFieldValue = updateCustomFieldValue.replace("\"", "");
		return status;

	}

	/**
	 * Method to update Activated Dynamic Endpoint
	 * 
	 * @param virtualID
	 * @param localID
	 * @return response status
	 * @throws Exception
	 */
	public int updateActivatedDynamicEP(String virtualID, int localID)
			throws IllegalStateException, IOException, Exception {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/products/" + virtualID + "/endpoints/"
				+ localID + "";
		UpdateEP endpointUpdate = new UpdateEP();
		endpointUpdate.setName("UpdateDEP");
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(endpointUpdate);
		HttpResponse response = rest.putRequestUpdate(apiUrl, jsonInString, getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		String updateActivatedDynamicEP = EntityUtils.toString(entity);
		updateActivatedDynamicEP = updateActivatedDynamicEP.replace("\"", "");
		return status;
	}

	/**
	 * Method to get endpoint Attribute value
	 * 
	 * @throws InterruptedException
	 */
	public String getProductAttributeValue(String virtualproductId, int attriId) {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/products/" + virtualproductId
				+ "/attributes";
		return getAttributeValue(apiUrl, attriId);
	}

	public String getEndpointAttributeValue(String virtualproductId, int localId, int attriId)
			throws JsonSyntaxException, IllegalStateException, IOException, InterruptedException {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/products/" + virtualproductId
				+ "/endpoints/" + localId + "/attributes";
		return getAttributeValue(apiUrl, attriId);
	}

	/**
	 * Method to get endpoint Attribute value
	 */
	public String getProductSettingValue(String virtualproductId, int settingId) {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/products/" + virtualproductId
				+ "/settings/" + settingId;
		return getSettingValue(apiUrl, settingId);
	}

	/**
	 * Method to get Product Attribute Value
	 * 
	 * @throws IOException
	 * @throws IllegalStateException
	 * @throws JsonSyntaxException
	 */

	public String getSettingValue(String url, int settingId) {
		String value = null;
		Gson gson = new Gson();
		String s1 = rest.getJson(url, getToken());
		SettingsDetail prodSett = gson.fromJson(s1, SettingsDetail.class);
		value = prodSett.getFieldvalue();
		return value;

	}

	/**
	 * Method to get Product Attribute Value
	 * 
	 * @throws IOException
	 * @throws IllegalStateException
	 * @throws JsonSyntaxException
	 * @throws InterruptedException
	 */
	public String getAttributeValue(String url, int attriId) {
		Map<String, String> map = new HashMap<String, String>();
		String value = null;
		Gson gson = new Gson();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		AttributeDetails[] prodAttr = gson.fromJson(rest.getJsonWithToken(url, getToken()), AttributeDetails[].class);
		for (AttributeDetails details : prodAttr) {
			map.put(details.getLocalId(), details.getValue());
			if (Integer.parseInt(details.getLocalId()) == attriId) {
				value = details.getValue();
				break;
			}
		}
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (entry.getKey().equals(value)) {
				break;
			}
		}
		return value;

	}

	/**
	 * Method to get productId
	 * 
	 * @throws IOException
	 * @throws IllegalStateException
	 * @throws JsonSyntaxException
	 */
	public String getProductId(String deviceId) {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/products/" + deviceId;
		String prodId = null;
		Gson gson = new Gson();
		ProductDetails product = gson.fromJson(rest.getJsonWithToken(apiUrl, getToken()), ProductDetails.class);
		prodId = product.getProductId();
		return prodId;

	}

	/**
	 * Method to add Product to given Product Line
	 * 
	 * @param cuid
	 * @param sku
	 * @return
	 * @throws URISyntaxException
	 * @throws InterruptedException
	 */

	public int addProduct(String cuid, String sku, String deviceId, String serialId) {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/product";
		writeJsonFile(deviceId, serialId);
		URIBuilder b;
		URL url = null;
		try {
			b = new URIBuilder(apiUrl);
			b.addParameter("productKey", "0");
			b.addParameter("cuId", cuid);
			b.addParameter("sku", sku);
			url = b.build().toURL();

		} catch (URISyntaxException | MalformedURLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		HttpResponse response = rest.postRequestFileUpload(url, absolutePath(), getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity responseEntity = response.getEntity();
		String responseString = null;
		try {
			responseString = EntityUtils.toString(responseEntity, "UTF-8");
		} catch (org.apache.http.ParseException | IOException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		Gson gson = new Gson();
		java.lang.reflect.Type mapType = new TypeToken<Map<String, Object>>() {
		}.getType();
		Map<String, Object> categoryicons = gson.fromJson(responseString, mapType);
		Set<Entry<String, Object>> set = categoryicons.entrySet();
		for (Entry object : set) {
			String bunchId = object.getValue().toString();
			confirmImportProduct(cuid, bunchId);
		}
		return status;
	}

	public int activateDeviceUsingAPI(String cuid, String deviceId, String serialNo) throws Exception {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/product/" + deviceId + "/activate";
		ActivateProduct productDetails = new ActivateProduct();
		productDetails.setSerialNumber(serialNo);
		productDetails.setCuId(cuid);
		productDetails.setBuildDate("2018-12-03T06:00:00.000Z");
		productDetails.setRmaDate("2016-12-05T06:00:00.000Z");
		productDetails.setSwVersion("6.6.6");
		productDetails.setHwVersion("2.0.1");
		productDetails.setMac("00:00:00:00:00:00");
		productDetails.setOs("LINUX");
		productDetails.setOsVersion("3.5.2");
		productDetails.setAgentType("Agent");
		productDetails.setAgentVersion("1810.03.28.00-FX.PC.L");
		productDetails.setApiVersion("1.62.1.0");
		productDetails.setBatch("100");
		productDetails.setHwName("VM");
		productDetails.setPlatformArch("x86");
		productDetails.setRma("123");
		productDetails.setStatus("0X10");
		productDetails.setSwName("eApp");
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(productDetails);
		HttpResponse response = rest.postRequest(apiUrl, jsonStr, getToken());
		int status = response.getStatusLine().getStatusCode();
		EntityUtils.toString(response.getEntity());
		return status;

	}

	public int deviceSyncUsingApi(String cuid, String deviceId, String serialNo) throws Exception {
		String apiUrl = Constants.AGENT_CORE_SERVICE + "api/v1/company/" + tenantId + "/products/" + deviceId + "/sync";
		ProductSync sync = new ProductSync();
		sync.setPd_serialnumber(serialNo);
		sync.setPd_uniqdevid(deviceId);
		sync.setCuid(cuid);
		sync.setPd_builddate("2018-12-03T06:00:00.000Z");
		sync.setPd_rmadate("2016-12-05T06:00:00.000Z");
		sync.setPd_swver("3.5.2");
		sync.setPd_hwver("2.0.1");
		sync.setPd_mac("00-00-00-00-00-00");
		sync.setPd_os("Linux");
		sync.setPd_osver("1.0.0");
		sync.setPd_agenttype("Agent");
		sync.setPd_agentver("1807.03.28.00-FX.PC.L");
		sync.setPd_apiver("1.62.1.0");
		sync.setPd_batch("100");
		sync.setPd_hwname("VM");
		sync.setPd_platformarch("x86");
		sync.setPd_rma("123");
		sync.setPd_status("0x00");
		sync.setPd_swname("eApp");
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(sync);
		HttpResponse response = rest.agentPostRequest(apiUrl, jsonStr, testNg.getApim());
		int status = response.getStatusLine().getStatusCode();
		EntityUtils.toString(response.getEntity());

		return status;

	}

	public int deActivateDeviceUsingAPI(String deviceId) throws Exception {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/product/" + deviceId + "/activate";
		return rest.delete(apiUrl, getToken());

	}

	/**
	 * confirmImportProduct
	 * 
	 * @param cuid
	 * @param bunchId
	 * @return
	 */
	public int confirmImportProduct(String cuid, String bunchId) {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/product/" + bunchId + "/confirm";
		URL url = null;
		try {
			URIBuilder b = new URIBuilder(apiUrl);
			b.addParameter("cuId", cuid);
			url = b.build().toURL();
		} catch (MalformedURLException | URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.getMessage();
		}
		HttpResponse response = rest.postRequest(url.toString(), "", getToken());
		int status = response.getStatusLine().getStatusCode();
		try {
			EntityUtils.toString(response.getEntity());
		} catch (org.apache.http.ParseException | IOException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		log.debug("confirmImportProduct " + status);
		return status;
	}

	/**
	 * Method for User LOgin
	 * 
	 * @param useremail
	 * @param cuid
	 * @return status
	 * @throws Exception
	 */
	public int userLogin(String useremail, String cuid) throws Exception, IOException {
		String loginAPI = Constants.NOTIFICATION_SERVICE + "/api/v1/user/{userEmail}/login";
		HttpResponse response = rest.postRequest(loginAPI);
		int status = response.getStatusLine().getStatusCode();
		return status;

	}

	/**
	 * Method for User Logout
	 * 
	 * @param useremail
	 * @param cuid
	 * @return status
	 * @throws Exception
	 */
	public int userLogout(String useremail, String cuid) throws Exception, IOException {
		String logoutAPI = Constants.NOTIFICATION_SERVICE + "/api/v1/user/{userEmail}/logout";
		HttpResponse response = rest.postRequest(logoutAPI);
		int status = response.getStatusLine().getStatusCode();
		return status;
	}

	/**
	 * Method to write Json file
	 * 
	 * @throws                      java.text.ParseException
	 * @throws InterruptedException
	 */
	@SuppressWarnings("unchecked")
	public void writeJsonFile(String deviceId, String serialNumber) {
		JSONObject obj = new JSONObject();
		LocalDateTime ldt = LocalDateTime.now();
		obj.put("RUNDATE", ldt + "");
		obj.put("SITE", "ATL");
		JSONObject productPropetiesObj = new JSONObject();
		productPropetiesObj.put("Status", "0X10");
		productPropetiesObj.put("MAC", "00:00:00:00:00:00");
		productPropetiesObj.put("OS", "LINUX");
		productPropetiesObj.put("OSVersion", "3.5.2");
		productPropetiesObj.put("ApiVersion", "1.62.1.1");
		productPropetiesObj.put("HwVersion", "2.0.1");
		productPropetiesObj.put("HwName", "Amsterdam");
		productPropetiesObj.put("Builddate", ldt + "");
		productPropetiesObj.put("Batch", "100");
		productPropetiesObj.put("RMA", "123");
		productPropetiesObj.put("RmaDate", ldt + "");
		productPropetiesObj.put("SN", serialNumber);
		productPropetiesObj.put("SwVersion", "3.5.2");
		productPropetiesObj.put("SwName", "eApp");
		productPropetiesObj.put("DeviceId", deviceId);
		JSONArray list = new JSONArray();
		list.add(productPropetiesObj);
		obj.put("PRODUCT", list);
		try {
			FileWriter file = new FileWriter(absolutePath());
			file.write(obj.toJSONString());
			file.flush();
			file.close();
		} catch (IOException e) {
			e.getMessage();
		}
	}

	public String absolutePath() {
		File f = new File("");
		String path = "";
		path = f.getAbsolutePath();
		return path + ".json";
	}

	public int deleteProductMaster(String productlines) {
		String deleteCascade = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + productlines
				+ "/cascade";
		return rest.delete(deleteCascade, getToken());
	}

	/**
	 * WEBSOCKET method to get the Notification alert messages
	 * 
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws Exception
	 */
	public String websocket() throws IOException, InterruptedException, Exception {
		Thread.sleep(40000);
		String text = w.getText(CssLocators.websocketNotification).toString();
		int index = text.indexOf("{");
		String jsonvalue = text.substring(index);
		org.json.JSONObject obj = new org.json.JSONObject(jsonvalue);
		String message = obj.getString("message");
		return message;

	}

	/**
	 * Method to get Company configuration id
	 * 
	 * @throws IOException
	 * @throws IllegalStateException
	 * @throws JsonSyntaxException
	 */

	public String getCompanyConfigId(String configName) throws JsonSyntaxException, IllegalStateException, IOException {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/configurations";
		Map<String, String> map = new HashMap<String, String>();
		String configId = null;
		Gson gson = new Gson();
		ComapnyConfiguration[] companyConfig = gson.fromJson(rest.getJsonWithToken(apiUrl, getToken()),
				ComapnyConfiguration[].class);
		for (ComapnyConfiguration s : companyConfig) {
			map.put(s.getDisplayName(), s.getId());
			if (s.getDisplayName().equals(configName)) {
				configId = s.getId();
			}
		}
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (entry.getKey().equals(configName)) {
				break;
			}
		}
		return configId;
	}

	/**
	 * Method to add company
	 * 
	 * @param cuid
	 * @param name
	 * @return recently added companyid 
	 */
	public String addTenant(String cuid, String name, String authenticationType)
			throws IllegalStateException, IOException {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company";
		String configId = getCompanyConfigId("Authentication Type");
		CompanyDetails companyDetails = new CompanyDetails();
		companyDetails.setCUID(cuid);
		companyDetails.setName(name);
		companyDetails.setCompanyEmail(testNg.getUserName());
		companyDetails.setDescription("tenant created by API automation");
		companyDetails.setLogoUrl(
				"https://devcloudcoreuse001st.blob.core.windows.net/images/SmartNexus%20by%20Flex%20-%20PNG.png");
		companyDetails.setEnvironmentUrl(Constants.CORE_SERVICE);
		companyDetails.setUrl("https://itest.portal.smartnexus.io/");
		List<Options> OptionDetails = new ArrayList<Options>();
		Options configOptions = new Options();
		configOptions.setKey(configId);
		configOptions.setValue(authenticationType);
		OptionDetails.add(configOptions);
		companyDetails.setOptions(OptionDetails);
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(companyDetails);
		HttpResponse response = rest.postRequest(apiUrl, jsonStr, getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		String addTenantResponse = EntityUtils.toString(entity);
		String companyId = addTenantResponse.replace("\"", "");
		return status + "," + companyId;
	}

	public int updateTenant(String tenantId, String name) throws IllegalStateException, IOException {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId;
		CompanyDetails companyDetails = new CompanyDetails();
		companyDetails.setName(name);
		companyDetails.setCompanyEmail(testNg.getUserName());
		companyDetails.setDescription("tenant updated by API automation");
		companyDetails.setLogoUrl("www.flex.com");
		companyDetails.setEnvironmentUrl(Constants.CORE_SERVICE);
		companyDetails.setUrl("https://itest.portal.smartnexus.io/");
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(companyDetails);
		HttpResponse response = rest.putRequestUpdate(apiUrl, jsonStr, getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		EntityUtils.toString(entity);
		return status;
	}

	/**
	 * Edit Company Options//PUT /api/v1/company/{companyId}/configuration
	 */
	public int updateTenantOptions(String tenantId, String key, String value)
			throws IllegalStateException, IOException {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/configuration";
		String configId = getCompanyConfigId(key);
		CompanyOptions companyOptn = new CompanyOptions();
		List<Options> OptionDetails = new ArrayList<Options>();
		Options options = new Options();
		options.setKey(configId);
		options.setValue(value);
		OptionDetails.add(options);
		companyOptn.setOptions(OptionDetails);
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(companyOptn);
		HttpResponse response = rest.putRequestUpdate(apiUrl, jsonStr, getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		EntityUtils.toString(entity);
		return status;
	}

	/**
	 * Edit Company Options//get /api/v1/company/{companyId}/configuration
	 */
	public Options[] getTenantOptionsDetails(String tenantId) {
		Options details[] = null;
		try {
			Thread.sleep(1000);
			String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/configuration";
			Gson gson = new Gson();
			details = gson.fromJson(rest.getJson(apiUrl, getToken()), Options[].class);
		} catch (InterruptedException e) {
			log.debug("get Tenant Options Details failed ");
		}
		return details;
	}

	/**
	 * Method to get Company detials
	 * 
	 * @return
	 */
	public CompanyDetails getTenantDetails(String cuId) throws IllegalStateException, IOException {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + cuId;
		Gson gson = new Gson();
		CompanyDetails details = gson.fromJson(rest.getJsonWithToken(apiUrl, getToken()), CompanyDetails.class);
		return details;
	}

	/**
	 * Method to get All Company List
	 * 
	 * @return
	 */
	public int getAllTenantList() throws IllegalStateException, IOException {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company";
		int statusCode = rest.getStatusCode(apiUrl, getToken());
		return statusCode;
	}

	/**
	 * Method to User profile
	 * 
	 * @return
	 */
	public int getUserProfile() throws IllegalStateException, IOException {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/user/okta/profile?userEmail=" + testNg.getUserName();
		int statusCode = rest.getStatusCode(apiUrl, getToken());
		return statusCode;
	}

	/**
	 * Method to Is Admin
	 * 
	 * @return
	 */
	public int isAdmin() throws IllegalStateException, IOException {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/user/flexadmin";
		int statusCode = rest.getStatusCode(apiUrl, getToken());
		return statusCode;
	}

	/**
	 * Method To get Setting History
	 * 
	 * @throws IOException
	 * @throws IllegalStateException
	 * @throws JsonSyntaxException
	 */
	public String settingHistory(String virtualproductId, int fId) {
		String apiUrl = Constants.CORE_SERVICE + "/api/v1/company/" + tenantId + "/products/" + virtualproductId
				+ "/fid/" + fId + "/settinghistory";
		String createdBy = null;
		String fieldValue = null;
		String status = null;
		Gson gson = new Gson();
		ProductSettingHistory productSetting = gson.fromJson(rest.getJsonWithToken(apiUrl, getToken()),
				ProductSettingHistory.class);
		SettingHistory[] settingHistory = productSetting.getData();
		String count = productSetting.getCount();
		if (!count.equals("0")) {
			for (SettingHistory s : settingHistory) {
				fieldValue = s.getFieldValue();
				createdBy = s.getCreatedBy();
				status = s.getStatus();
				break;
			}
		}
		return fieldValue + "," + createdBy + "," + status;
	}

	/**
	 * Method To get Setting History
	 * 
	 * @throws IOException
	 * @throws IllegalStateException
	 * @throws JsonSyntaxException
	 */
	public int sendSettingValues(String virtualproductId, String fId, String value) {
		String apiUrl = Constants.CORE_SERVICE + "/api/v1/company/" + tenantId + "/products/" + virtualproductId
				+ "/settings";
		SettingValue settingValue = new SettingValue();
		List<SettingValue> settings = new ArrayList<SettingValue>();
		settingValue.setFId(fId);
		settingValue.setValue(value);
		settings.add(settingValue);
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = null;
		int status = 0;
		try {
			jsonStr = mapper.writeValueAsString(settings);
			HttpResponse response = rest.postRequest(apiUrl, jsonStr, getToken());
			status = response.getStatusLine().getStatusCode();
			HttpEntity entity = response.getEntity();
			EntityUtils.toString(entity);
		} catch (org.apache.http.ParseException | IOException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return status;
	}

	public String getSettingValueEphemerisData(String vpId, int fId) throws JsonSyntaxException, IOException {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/products/" + vpId + "/fid/" + fId
				+ "/settinghistory";
		Map<String, String> map = new HashMap<String, String>();
		Gson gson = new Gson();
		String s1 = rest.getJson(apiUrl, getToken());
		EphemerisData data = gson.fromJson(s1, EphemerisData.class);
		SettingsData[] value = data.getData();
		String response = null;
		if (value != null) {
			for (SettingsData settingsData : value) {
				map.put(settingsData.getStatus(), settingsData.getFieldValue());
				response = settingsData.getStatus();
			}
		}
		log.debug("Value " + response + " ");
		return response;
	}

	public int deleteCompany() {
		String getProductsUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId;
		// deleteWebhookNotification();
		return rest.delete(getProductsUrl, getToken());
	}
	
	/*
	 * Generate token Using AzureAD
	 *  This token we are using for API Authentication in each API
	 * 
	 */
	
	public String getToken() {
		try {
			Thread.sleep(60);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.getMessage();
		}

		OkHttpClient client = new OkHttpClient();
		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");

		RequestBody body = RequestBody.create(mediaType,
				"grant_type=client_credentials&client_id=bcdd03d0-7ee6-4348-997f-713d56afda00&client_secret=bLfcl144b[sf@ixEWx/tLApF@HIHbh5R&resource=dc9509ff-d435-4495-8fa8-6baa775982f5");
		Request request = new Request.Builder().url("https://login.microsoftonline.com/smartnexus.io/oauth2/token")
				.method("POST", body).addHeader("Accept", " application/json ")
				.addHeader("Content-Type", "application/x-www-form-urlencoded").build();

		Gson gson = new Gson();
		Token jsonToken = null;
		ResponseBody response;
		try {
			response = client.newCall(request).execute().body();
			jsonToken = gson.fromJson(response.string(), Token.class);
			return jsonToken.getAccess_token();
		} catch (IOException e) {
			e.getMessage();
		}
		return null;
	}

	public Set<String> getWebhookNotification(String sku) {
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			e.getMessage();
		}
		Gson gson = new Gson();
		Set<String> value = new HashSet<>();
		WebhookResponse res = gson.fromJson(rest.getWebhook(Constants.WEBHOOK_SERVER), WebhookResponse.class);
		NotificationResponse[] document = res.getDocuments();
		for (NotificationResponse obj : document) {
			if (obj.getData().getSku().equals(sku)) {
				value.add(obj.getMessage());
			}
		}
		log.debug("Notification message List " + value);
		return value;
	}

	public Set<Object> getDTSWebhookNotification(String cuid) throws Exception {
		Thread.sleep(30000);
		Gson gson = new Gson();
		Set<Object> value = new HashSet<>();
		WebhookResponse res = gson.fromJson(rest.getWebhook(Constants.WEBHOOK_SERVER), WebhookResponse.class);
		NotificationResponse[] document = res.getDocuments();
		for (NotificationResponse webhookResponse : document) {
			if (webhookResponse.getCuId().equals(cuid)) {
				if (webhookResponse.getData().getValue() != null) {
					value.add(webhookResponse.getData().getValue());
				}
			}
		}
		log.debug("Notification message List " + value);
		return value;
	}

	public Set<String> getGeofenceNotification(String cuid) {
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		Gson gson = new Gson();
		Set<String> value = new HashSet<>();
		WebhookResponse res = gson.fromJson(rest.getWebhook(Constants.WEBHOOK_SERVER), WebhookResponse.class);
		NotificationResponse[] document = res.getDocuments();
		for (NotificationResponse webhookResponse : document) {
			if (webhookResponse.getCuId().equals(cuid)) {
				value.add(webhookResponse.getData().getViolationType());
			}
		}
		log.debug(value);
		return value;
	}

	public String getConstraint(String name) throws IOException, ParseException, URISyntaxException {
		String dataTypeId = null;
		String apiUrl = Constants.CORE_SERVICE + "/api/v1/company/" + tenantId + "/constraints";
		Gson gson = new Gson();
		Constraints[] dataType = gson.fromJson(rest.getJson(apiUrl, getToken()), Constraints[].class);
		for (Constraints c : dataType) {
			if (c.getName().equals(name)) {
				dataTypeId = c.getId();
				break;
			}
		}
		return dataTypeId;
	}

	public void deleteWebhookNotification() {
		Gson gson = new Gson();
		WebhookResponse[] obj;
		try {
			obj = gson.fromJson(new Rest().getWebhook(Constants.WEBHOOK_SERVER), WebhookResponse[].class);
			for (WebhookResponse webhookResponse : obj) {
				// new Rest().deleteWebhook(Constants.WEBHOOK_SERVER + "/" +
				// webhookResponse.get_id());
			}
		} catch (JsonSyntaxException | IllegalStateException e) {
			log.debug("deleteWebhookNotification failed... ");
		}
	}

	public void deactivate(String deviceId) {
		String url = Constants.CORE_SERVICE + "api/v1/product/" + deviceId + "/activate";
		rest.delete(url, getToken());
	}

	public int uploadDeviceLogfile(String cuid, String deviceId) {
		String apiUrl = Constants.AGENT_CORE_SERVICE + "api/v1/company/" + cuid + "/products/" + deviceId + "/log";
		int status = 0;
		try {
			URL url = new URIBuilder(apiUrl).build().toURL();
			HttpResponse response = rest.agentFileUpload(url, absolutePath(), testNg.getApim());
			status = response.getStatusLine().getStatusCode();
			HttpEntity responseEntity = response.getEntity();
		} catch (MalformedURLException | URISyntaxException e) {
			log.debug("upload DeviceLogfile failed... ");
		}
		return status;
	}

	/**
	 * Method to add Site config
	 * 
	 * @throws URISyntaxException
	 * @throws Exception
	 * @throws IOException
	 * @throws                    java.text.ParseException
	 * 
	 */
	public int addSiteConfig(String deviceId, String serialNumber, String reportingGroupName, String mfgId)
			throws URISyntaxException, java.text.ParseException, IOException, Exception {
		Base64.Encoder encoder = Base64.getEncoder();
		String bunchId = null;
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/siteconfig";
		URIBuilder uRIBuilder = new URIBuilder(apiUrl);
		URL url = uRIBuilder.build().toURL();
		writeJsonFileSiteConfig(deviceId, serialNumber, reportingGroupName, mfgId);

		String data = readFileAsString(absolutePath());
		String str = encoder.encodeToString(data.getBytes());
		enCodeJsonfile(str);
		HttpResponse response = rest.postRequestFileUpload(url, absolutePath(), getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity responseEntity = response.getEntity();
		String responseString = EntityUtils.toString(responseEntity, "UTF-8");
		Gson gson = new Gson();
		java.lang.reflect.Type mapType = new TypeToken<Map<String, Object>>() {
		}.getType();
		Map<String, Object> categoryicons = gson.fromJson(responseString, mapType);
		Set<Entry<String, Object>> set = categoryicons.entrySet();
		for (Entry object : set) {
			bunchId = object.getValue().toString();
			log.debug(object.getKey() + " is  " + bunchId);
		}
		int status1 = siteConfigBunchIDConfirm(bunchId);
		return status1;
	}

	@SuppressWarnings("unchecked")
	public void writeJsonFileSiteConfig(String deviceId, String serialNumber, String reportingGroupName, String mfgId)
			throws java.text.ParseException, IOException, InterruptedException {
		log.debug("writeJsonFileSiteConfig method invoked...");

		JSONObject productObj = new JSONObject();
		productObj.put("name", " " + deviceId);
		productObj.put("sn", serialNumber);
		productObj.put("deviceid", deviceId);

		JSONObject endpointPropetiesObj1 = new JSONObject();
		endpointPropetiesObj1.put("name", "Ep " + cu.randomName());
		endpointPropetiesObj1.put("mfgid", mfgId);
		endpointPropetiesObj1.put("serialNo", serialNumber + cu.generateRandomNumber());
		JSONObject endpointPropetiesObj2 = new JSONObject();
		endpointPropetiesObj2.put("name", "Ep " + cu.randomName());
		endpointPropetiesObj2.put("mfgid", mfgId);
		endpointPropetiesObj2.put("serialNo", serialNumber + cu.generateRandomNumber());
		JSONObject endpointPropetiesObj3 = new JSONObject();
		endpointPropetiesObj3.put("name", "Ep " + cu.randomName());
		endpointPropetiesObj3.put("mfgid", mfgId);
		endpointPropetiesObj3.put("serialNo", serialNumber + cu.generateRandomNumber());

		JSONArray endpointList = new JSONArray();
		endpointList.add(endpointPropetiesObj1);
		endpointList.add(endpointPropetiesObj2);
		endpointList.add(endpointPropetiesObj3);

		productObj.put("endpoints", endpointList);

		JSONArray productList = new JSONArray();
		productList.add(productObj);

		JSONObject customFieldsObj = new JSONObject();
		customFieldsObj.put("key", "Field 1");
		customFieldsObj.put("value", "Test value");
		JSONArray customFieldsList = new JSONArray();
		customFieldsList.add(customFieldsObj);

		JSONObject reportingGroupObj = new JSONObject();
		reportingGroupObj.put("products", productList);
		reportingGroupObj.put("customfields", customFieldsList);
		reportingGroupObj.put("groupname", reportingGroupName);

		JSONObject finalObj = new JSONObject();
		finalObj.put("ReportingGroup", reportingGroupObj);
		try {

			FileWriter file = new FileWriter(absolutePath());
			file.write(finalObj.toJSONString());
			file.flush();
			file.close();

		} catch (IOException e) {
			e.getMessage();
		}
	}

	/**
	 * Mrthod to confirm bunchId
	 * 
	 * @throws URISyntaxException
	 * @throws IOException
	 * 
	 */
	public int siteConfigBunchIDConfirm(String bunchId) throws URISyntaxException, IOException {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/siteconfig/" + bunchId + "/confirm";
		;
		HttpResponse response = rest.postRequest(apiUrl, "", getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		String exportConfigResponse = EntityUtils.toString(entity);
		log.debug(exportConfigResponse + "  " + status);
		return status;
	}

	/**
	 * Mathod to add OTA groups
	 * 
	 * @throws Exception
	 * @throws URISyntaxException
	 * 
	 */

	public String addOTAGroup(String packageGroupId, boolean time) throws URISyntaxException, Exception {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/groups/OTA";
		OTAgroups otsGroup = new OTAgroups();
		otsGroup.setForceUpdate(true);
		otsGroup.setName("OAT-" + System.nanoTime());
		otsGroup.setPackageGroupId(packageGroupId);
		DayOfWeek dayOfWeek = new DayOfWeek();
		if (time) {
			otsGroup.setStartTime("01:00");
			otsGroup.setEndTime("11:59");
			dayOfWeek.setFriday(time);
			dayOfWeek.setMonday(time);
			otsGroup.setName("OAT WithSchedule_" + System.nanoTime());
		}
		otsGroup.setDayOfWeek(dayOfWeek);
		otsGroup.setPackageType("app");
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(otsGroup);
		HttpResponse response = rest.postRequest(apiUrl, jsonStr, getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		String addOTAgroupResponse = EntityUtils.toString(entity);
		addOTAgroupResponse = addOTAgroupResponse.replace("\"", "");
		log.debug("addOTAgroupResponse " + addOTAgroupResponse);
		return status + "," + addOTAgroupResponse;

	}

	/**
	 * Mathod to Update OTA groups
	 * 
	 */

	public String updateOTAGroup(String cuId, String packageGroupId, String otaGroupId)
			throws URISyntaxException, Exception {
		String apiUrl = Constants.CORE_SERVICE + "group/" + otaGroupId;
		OTAgroups otsGroup = new OTAgroups();
		otsGroup.setForceUpdate(true);
		otsGroup.setName("OAT_Updated" + cu.randomName());
		otsGroup.setPackageGroupId(packageGroupId);
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(otsGroup);
		HttpResponse response = rest.putRequest(apiUrl, jsonStr, getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		String updateOTAgroupResponse = EntityUtils.toString(entity);
		updateOTAgroupResponse = updateOTAgroupResponse.replace("\"", "");
		log.debug("updateOTAgroupResponse " + updateOTAgroupResponse);
		return status + "," + updateOTAgroupResponse;

	}

	/**
	 * Method to add Products to OTA group
	 */
	public String addProductsToOTAGroup(String cuId, String otaGroupId, String deviceId)
			throws URISyntaxException, Exception {
		String apiUrl = Constants.CORE_SERVICE + "group/" + otaGroupId + "/products";
		AddProductsToOTA otsGroup = new AddProductsToOTA();
		otsGroup.setCuId(cuId);
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(otsGroup);
		HttpResponse response = rest.postRequest(apiUrl, jsonStr);
		int status = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		String AddProductOTAgroupResponse = EntityUtils.toString(entity);
		AddProductOTAgroupResponse = AddProductOTAgroupResponse.replace("\"", "");
		log.debug("AddProductOTAgroupResponse " + AddProductOTAgroupResponse);
		return status + "," + AddProductOTAgroupResponse;

	}

	/**
	 * Method to get Package Type Id
	 */
	public String getPackageTypeId(String typeName) throws IOException, ParseException {
		String packageTypesUrl = Constants.CORE_SERVICE + "api/v1/company/packagetypes";
		Map<String, String> map = new HashMap<String, String>();
		String id = null;
		Gson gson = new Gson();
		PackageTypes[] packageTypes = gson.fromJson(rest.getJson(packageTypesUrl, getToken()), PackageTypes[].class);
		for (PackageTypes s : packageTypes) {
			if (s.getName().equals(typeName)) {
				id = s.getId();
				map.put(s.getName(), s.getId());
			}
		}
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (entry.getKey().equals(typeName)) {
				break;
			}
		}
		return id;
	}

	/**
	 * addPackage
	 */
	public String addPackage(String pmId, String packageGroupId, String typeId, String imageId)
			throws IllegalStateException, IOException, Exception {
		String apiUrl1 = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + pmId
				+ "/packagegroup/" + packageGroupId + "/packages";
		PackageGroup packageDetails = new PackageGroup();
		packageDetails.setTypeId(typeId);
		packageDetails.setImageId(imageId);
		packageDetails.setName("package" + cu.randomName());
		packageDetails.setDescription("Desc" + cu.randomName());
		packageDetails.setVersion("9.9.9");
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(packageDetails);
		HttpResponse response = rest.postRequest(apiUrl1, jsonStr, getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		String addPackageResponse = EntityUtils.toString(entity).replace("\"", "");
		log.debug("add package details " + addPackageResponse);
		return status + "," + addPackageResponse;
	}

	public String addPackageImage(String typeId) throws URISyntaxException, org.apache.http.ParseException, IOException,
			java.text.ParseException, InterruptedException {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/packages/type/" + typeId + "/image";
		URL url = new URIBuilder(apiUrl).build().toURL();
		HttpResponse response = rest.postRequestFileUpload(url, absolutePath(), getToken());
		HttpEntity responseEntity = response.getEntity();
		String responseString = EntityUtils.toString(responseEntity, "UTF-8");
		Gson gson = new Gson();
		ImageResponse imageResponse = gson.fromJson(responseString, ImageResponse.class);
		return imageResponse.getId();
	}

	public String importProductMaster() {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId
				+ "/productlines/ImportConfiguration?hasAttributes=true&hasSettings=true&hasCommands=true&hasUserFields=true&hasNotifications=true";
		HttpResponse response = null;
		String responseString = null;
		Gson gson = new Gson();
		try {
			URL url = new URIBuilder(apiUrl).build().toURL();
			response = rest.postRequestFileUpload(url, path + "/flexFileStore/productConfiguration.json", getToken());
			HttpEntity responseEntity = response.getEntity();
			responseString = EntityUtils.toString(responseEntity, "UTF-8");
		} catch (URISyntaxException | org.apache.http.ParseException | IOException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		APIResponse imageResponse = gson.fromJson(responseString, APIResponse.class);
		return response.getStatusLine().getStatusCode() + "," + imageResponse.getResponse();
	}

	public String exportProductMaster(String pmid) {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + pmid
				+ "/ExportConfiguration";
		HttpResponse response = rest.postRequest(apiUrl,
				"{\"hasAttributes\":true,\"hasSettings\":true,\"hasCommands\":true,\"hasUserFields\":true,\"hasNotifications\":true}",
				getToken());
		HttpEntity responseEntity = response.getEntity();
		String responseString = null;
		try {
			responseString = EntityUtils.toString(responseEntity, "UTF-8");
		} catch (org.apache.http.ParseException | IOException e) {
			e.getMessage();
			log.debug("exportProductMaster failed due to " + responseString);
		}
		return responseString;
	}

	public boolean getCommandTemplate(String pmId, String cId) throws JsonSyntaxException, IOException {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + pmId + "/commands/"
				+ cId;
		Gson gson = new Gson();
		String response = rest.getJson(apiUrl, getToken());
		CommandDetails commandDetails = gson.fromJson(response, CommandDetails.class);
		String id = commandDetails.getId();
		if (cId.equals(id)) {
			return true;
		} else {
			return false;
		}

	}

	public String getAllPMCommand(String pmId, String commandname) throws JsonSyntaxException, IOException {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + pmId + "/commands";
		Gson gson = new Gson();
		String response = rest.getJson(apiUrl, getToken());
		GelAllCommands commandDetails = gson.fromJson(response, GelAllCommands.class);
		CommandGroups[] groups = commandDetails.getGroups();
		for (CommandGroups commandGroups : groups) {
			CommandDetails[] command = commandGroups.getCommands();
			for (CommandDetails obj : command) {
				if (commandname.equals(obj.getDeviceCommand())) {
					return obj.getId();
				}
			}
		}
		return "";

	}

	public boolean getCommandTemplateForPeriphal(String pmId, String cId) {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + pmId + "/endpoints/"
				+ MfgId + "/commands/" + cId;
		Gson gson = new Gson();
		String response = rest.getJson(apiUrl, getToken());
		CommandDetails commandDetails = gson.fromJson(response, CommandDetails.class);
		String id = commandDetails.getId();
		if (cId.equals(id)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean getUserFieldTemplate(String pmId, String name) {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + pmId
				+ "/product/userfield";
		Gson gson = new Gson();
		boolean status = false;
		String response = rest.getJson(apiUrl, getToken());
		UserFieldList userField = gson.fromJson(response, UserFieldList.class);
		UserFields[] field = userField.getUserFields();
		for (UserFields userFields : field) {
			if (name.equals(userFields.getName())) {
				status = true;
				break;
			}
		}
		return status;
	}

	public boolean getPeriphalUserFieldTemplate(String pmId, String name) {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + pmId + "/endpoints/"
				+ MfgId + "/customfields";
		boolean status = false;
		Gson gson = new Gson();
		String response = rest.getJson(apiUrl, getToken());
		UserFieldList userField = gson.fromJson(response, UserFieldList.class);
		UserFields[] field = userField.getUserFields();
		for (UserFields userFields : field) {
			if (name.equals(userFields.getName())) {
				status = true;
				break;
			}
		}
		return status;

	}

	@SuppressWarnings("unchecked")
	public void enCodeJsonfile(String encodefile) {
		JSONObject reportingGroupObj = new JSONObject();
		reportingGroupObj.put("FileType", 1);
		reportingGroupObj.put("FileName", "importsitconfig.json");
		reportingGroupObj.put("FileContent", encodefile);
		try {
			FileWriter file = new FileWriter(absolutePath());
			file.write(reportingGroupObj.toJSONString());
			file.flush();
			file.close();
		} catch (IOException e) {
			e.getMessage();
		}
	}

	public String readFileAsString(String fileName) throws Exception {
		String data = "";
		data = new String(Files.readAllBytes(Paths.get(fileName)));
		return data;
	}

	public String getPackageGroups(String plId) throws IllegalStateException, IOException, Exception {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + plId
				+ "/packagegroup";
		String response = rest.getJson(apiUrl, getToken());
		Gson gson = new Gson();
		GetPackageBundle bundle = gson.fromJson(response, GetPackageBundle.class);
		PackageBundle[] pac = bundle.getData();
		String menifest = null;
		for (PackageBundle packageBundle : pac) {
			menifest = packageBundle.getManifestFileUrl();
		}
		return menifest;
	}

	public void downloadMenifestFile(String urlStr) throws IOException {
		URL url = new URL(urlStr);
		ReadableByteChannel rbc = Channels.newChannel(url.openStream());
		FileOutputStream fos = new FileOutputStream(path + "_manifest.json");
		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		fos.close();
		rbc.close();
	}

	public String signedMenifestFileAndUpload(String urlStr) throws IOException {
		String[] cmdScript = new String[] { "/bin/bash", "/home/agent/git/signed.sh" };
		Process procScript = Runtime.getRuntime().exec(cmdScript);
		// https://api.smartnexus.io/tst/core/api/v1/company/d08c4de3-d7cd-49e2-ac8e-b52db315cea0/productlines/57338a7b-5d3c-434f-b1dc-014609f833f1/packagegroup/91b04e9f-12a2-40c4-b76f-4176ff9f6d83/manifest
		return urlStr;
	}

	public String uploadSignedMenifestFile(String plId, String packageGroupId)
			throws IllegalStateException, IOException, Exception {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + plId
				+ "/packagegroup/" + packageGroupId + "/manifest";
		URL url = new URIBuilder(apiUrl).build().toURL();
		String fileLocation = path.replace("qa-apitest", "signed_manifest.json");
		HttpResponse response = rest.postRequestFileUpload(url, fileLocation, getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		String addPackageResponse = EntityUtils.toString(entity).replace("\"", "");
		return status + "," + addPackageResponse;
	}

	public String addPeripheralCommandsDropdown(String plId, int formType, String dataType) throws Exception {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + plId + "/endpoints/"
				+ MfgId + "/Commands";
		dataType = getDataTypeId(dataType);
		String commandName = "Command_" + cu.randomName() + cu.randomName();
		Commands commands = new Commands();
		commands.setOnScreenDisplay(commandName);
		commands.setDisplayGroupName(commandName);
		commands.setDeviceCommand("cm" + cu.generateRandomID() + cu.randomName());
		List<Parameters> parameters = new ArrayList<Parameters>();
		Parameters param = new Parameters();
		param.setConstraint(null);
		param.setDataType(dataType);
		param.setFormType(formType);
		List<ListOfPossibleValues> listOfValue = new ArrayList<ListOfPossibleValues>();
		ListOfPossibleValues possibleValues = new ListOfPossibleValues();
		listOfValue.add(possibleValues);
		List<ListOfPossibleValues> list = new ArrayList<>();
		ListOfPossibleValues value = new ListOfPossibleValues();
		value.setDefault(true);
		value.setValue("1");
		list.add(value);
		ListOfPossibleValues value2 = new ListOfPossibleValues();
		value2.setDefault(true);
		value2.setValue("0");
		list.add(value);
		param.setListOfPossibleValues(list);
		param.setName(commandName);
		parameters.add(param);
		commands.setParameters(parameters);
		commands.setRr(true);
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(commands);
		HttpResponse response = rest.postRequest(apiUrl, jsonStr, getToken());
		HttpEntity entity = response.getEntity();
		return EntityUtils.toString(entity).replace("\"", "");
	}

	public boolean approveManifes(String pmId, String packageGroupId) {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + pmId
				+ "/packagegroup/approve?packageGroupId=" + packageGroupId;
		return Boolean.parseBoolean(rest.getJson(apiUrl, getToken()));
	}

	public int addProductToOTAGroup(String groupId, String deviceId)
			throws IllegalStateException, IOException, Exception {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/groups/" + groupId + "/OTA/products";
		String jsonStr = "{\"ProductIds\" :" + "\"" + getProductList(deviceId) + "\"" + "}";
		HttpResponse response = rest.postRequest(apiUrl, jsonStr, getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		EntityUtils.toString(entity);
		log.debug("addProductToOTAGroup details " + jsonStr + apiUrl);
		return status;
	}

	public int removeProductFromOTAGroup(String groupId, String deviceId)
			throws IllegalStateException, IOException, Exception {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/groups/" + groupId + "/OTA/products";
		String jsonStr = "{\"ProductIds\" :" + "\"" + getProductList(deviceId) + "\"" + "}";
		OkHttpClient client = new OkHttpClient();
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, jsonStr);
		Request request = new Request.Builder().url(apiUrl).delete(body).addHeader("Content-Type", "application/json")
				.addHeader("Authorization", "Bearer " + getToken()).build();
		Response response = client.newCall(request).execute();
		log.debug("removeProductFromOTAGroup details " + response);
		return response.code();
	}

	public int deleteOTA(String groupId) {
		String deleteCascade = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/groups/" + groupId + "/OTA";
		return rest.delete(deleteCascade, getToken());
	}

	public int deleteFullBundle(String pmId, String packageGroupId) {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/productlines/" + pmId
				+ "/packagegroup/" + packageGroupId;
		return rest.delete(apiUrl, getToken());
	}

	public int addMultipleProduct(String cuid, String sku, String deviceId, String serialId) {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/product";
		writeMultipledeviceJsonFile(deviceId, serialId);
		URIBuilder b;
		URL url = null;
		try {
			b = new URIBuilder(apiUrl);
			b.addParameter("productKey", "0");
			b.addParameter("cuId", cuid);
			b.addParameter("sku", sku);
			url = b.build().toURL();

		} catch (URISyntaxException | MalformedURLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		HttpResponse response = rest.postRequestFileUpload(url, absolutePath(), getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity responseEntity = response.getEntity();
		String responseString = null;
		try {
			responseString = EntityUtils.toString(responseEntity, "UTF-8");
		} catch (org.apache.http.ParseException | IOException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		Gson gson = new Gson();
		java.lang.reflect.Type mapType = new TypeToken<Map<String, Object>>() {
		}.getType();
		Map<String, Object> categoryicons = gson.fromJson(responseString, mapType);
		Set<Entry<String, Object>> set = categoryicons.entrySet();
		for (Entry object : set) {
			String bunchId = object.getValue().toString();
			confirmImportProduct(cuid, bunchId);
		}
		return status;
	}

	public void writeMultipledeviceJsonFile(String deviceId, String serialNumber) {
		JSONObject obj = new JSONObject();
		LocalDateTime ldt = LocalDateTime.now();
		obj.put("RUNDATE", ldt + "");
		obj.put("SITE", "ATL");
		JSONArray list = new JSONArray();
		JSONObject productPropetiesObj = null;
		for (int i = 1; i <= 3; i++) {
			productPropetiesObj = new JSONObject();
			productPropetiesObj.put("Status", "0X10");
			productPropetiesObj.put("MAC", "00:00:00:00:00:00");
			productPropetiesObj.put("OS", "LINUX");
			productPropetiesObj.put("OSVersion", "3.5.2");
			productPropetiesObj.put("ApiVersion", "1.62.1.1");
			productPropetiesObj.put("HwVersion", "2.0.1");
			productPropetiesObj.put("HwName", "Amsterdam");
			productPropetiesObj.put("Builddate", ldt + "");
			productPropetiesObj.put("Batch", "100");
			productPropetiesObj.put("RMA", "123");
			productPropetiesObj.put("RmaDate", ldt + "");
			productPropetiesObj.put("SN", serialNumber + i);
			productPropetiesObj.put("SwVersion", "3.5.2");
			productPropetiesObj.put("SwName", "eApp");
			productPropetiesObj.put("DeviceId", deviceId + i);

			list.add(productPropetiesObj);
			obj.put("PRODUCT", list);
			multiDeviceList.add(deviceId + i);
		}

		try {
			FileWriter file = new FileWriter(absolutePath());
			file.write(obj.toJSONString());
			file.flush();
			file.close();
		} catch (IOException e) {
			e.getMessage();
		}
	}

	public List<String> getCommandHistory(String pmId, String vpId, String commandName)
			throws IllegalStateException, IOException, Exception {
		List<String> list = new ArrayList<>();
		String commandId = getAllPMCommand(pmId, commandName);
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/products/" + vpId + "/command/"
				+ commandId + "/commandhistory";
		String response = rest.getJson(apiUrl, getToken());
		Gson gson = new Gson();
		CommandHistory history = gson.fromJson(response, CommandHistory.class);
		CommandData[] pac = history.getData();
		for (CommandData cd : pac) {
			list.add(cd.getStatus());
			list.add(cd.getCreatedBy());
			list.add(cd.getDeviceCommand());
			SendCommandParameter[] parm = cd.getParameters();
			for (SendCommandParameter obj : parm) {
				list.add(obj.getValue());
			}
		}
		return list;
	}

	public List<Object> getWebhookNotificationWithHighPriority(String cuid) throws Exception {
		Thread.sleep(70000);
		Gson gson = new Gson();
		List<Object> value = new ArrayList();
		WebhookResponse res = gson.fromJson(rest.getWebhook(Constants.WEBHOOK_SERVER), WebhookResponse.class);
		NotificationResponse[] document = res.getDocuments();
		for (NotificationResponse webhookResponse : document) {
			if (webhookResponse.getCuId().equals(cuid)) {
				if (webhookResponse.getPriority() == 1) {
					value.add(webhookResponse.getMessage());
				}
			}
		}
		log.debug("High Notification message List " + value);
		return value;
	}

	public int addSettingsProfile(String pmId, String name) throws Exception {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/public/company/products/saveSettingsProfile";
		CreateSettingProfile profile = new CreateSettingProfile();
		profile.setCompanyId(tenantId);
		profile.setProductLineId(pmId);
		profile.setSettingsProfileArray(new String[0]);
		SettingProfileNames profileNames = new SettingProfileNames();
		profileNames.setId("");
		profileNames.setProfileName("");
		profile.setSettingProfileNames(profileNames);
		profile.setProfileName(name);
		SettingProfileValues[] age = new SettingProfileValues[1];
		SettingProfileValues val = new SettingProfileValues();
		val.setFid("9");
		val.setValue("{}");
		age[0] = val;
		profile.setSettingProfileValues(age);
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(profile);
		HttpResponse response = rest.postRequest(apiUrl, jsonStr, getToken());
		HttpEntity entity = response.getEntity();
		int status = response.getStatusLine().getStatusCode();
		System.out.println(apiUrl + " " + jsonStr);
		EntityUtils.toString(entity);
		return status;
	}

	public int sendiENBLMessage(String cuid, String deviceId, String name) throws Exception {
		// String apiUrl = Constants.CORE_SERVICE +
		// "api/v1/public/company/products/saveSettingsProfile" ;
		String apiUrl = "https://preview-ienbl-us-e-001-func.azurewebsites.net/api/sendattribute?code=pTymai4wyITDSeDx0Ydw0L5SslH6xz5B2orHCatgLMtFnWH6v45ddQ==";
		Ienbl ienbl = new Ienbl();
		ienbl.setCuid(cuid);
		ienbl.setDid(deviceId);
		ienbl.setPhid("");
		ienbl.setType("a2.0");
		ienbl.setName(name);
		ienbl.setDt("2018-11-16T21:11:38.0000000Z");
		DataiENBL data = new DataiENBL();
		data.setAccX(48);
		data.setAccY(-16);
		data.setAccZ(1072);
		data.setHall(0);
		data.setBattery(82.3529411);
		data.setPressure(4586.3);
		data.setLuminosity(0);
		data.setHumidity(46);
		data.setTemperature(605.7);
		data.setNumWifi(5);
		data.setWifi1("90724014FE64:-57");
		data.setWifi2("90840DEC7461:-76");
		data.setWifi3("AC5D1060E5A9:-77");
		data.setLockStatus("Unlocked");
		ienbl.setData(data);
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(ienbl);
		HttpResponse response = rest.postRequest(apiUrl, jsonStr, getToken());
		HttpEntity entity = response.getEntity();
		int status = response.getStatusLine().getStatusCode();
		System.out.println(status + EntityUtils.toString(entity));
		return status;
	}

	public String getWHNotificationForAttrValue(String sku, int priority) throws InterruptedException {
		Thread.sleep(6000);
		String value = "";
		Gson gson = new Gson();
		WebhookResponse res = gson.fromJson(rest.getWebhook(Constants.WEBHOOK_SERVER), WebhookResponse.class);
		NotificationResponse[] document = res.getDocuments();

		for (NotificationResponse obj : document) {
			if (obj.getData().getSku().equals(sku) && obj.getMessageType() == 0 && obj.getPriority() == priority) {
				// value.add(webhookResponse.getDocuments().getData().getName());
				value = obj.getData().getName();
			}
		}
		log.debug("Attr Notification message Name " + value);
		return value;
	}

	public int getDeviceLogfile(String vpId) {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/products/" + vpId + "/log";
		Gson gson = new Gson();
		GetLogDetails log = gson.fromJson(rest.getJsonWithToken(apiUrl, getToken()), GetLogDetails.class);
		int count = log.getCount();
		LogData[] str = log.getData();
		for (LogData logData : str) {
			log_id = logData.getId();

		}
		return count;
	}

	public int downloadLogfile(String vpId) {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/products/" + vpId + "/log/" + log_id;
		int status = rest.getStatusCode(apiUrl, getToken());
		System.out.println(status);
		return status;
	}

	public int deleteLogfile(String vpId) {
		String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/products/" + vpId + "/log/" + log_id
				+ "/delete";
		int status = rest.delete(apiUrl, getToken());
		System.out.println(status);
		return status;
	}

	public int deleteDevice(String deviceId) {
		int status=0;

		if (multiDeviceList != null) {
			Iterator<String> it = multiDeviceList.iterator();
	        while (it.hasNext()) {
	        deviceId=it.next();
			String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/products/" + deviceId + "/delete";
			status = rest.delete(apiUrl, getToken());
			
					}
		}
		return status;
	}


	
	public int bulkDevice(String deviceId) {
		int status=0;
		if (multiDeviceList != null) {
			Iterator<String> it = multiDeviceList.iterator();
	        while (it.hasNext()) {
	        deviceId=it.next();
			String apiUrl = Constants.CORE_SERVICE + "api/v1/company/" + tenantId + "/products/" + deviceId + "/delete";
			status = rest.delete(apiUrl, getToken());
			
					}
		}
		return status;
	}
	

	public static void main(String[] args) throws Exception {

		NorthBoundInterface nbi = new NorthBoundInterface();
		int id = nbi.deleteDevice("ID15810799490221460");
		// nbi.sendiENBLMessage("","LOAD01", "NoSpaceJSON");
		System.out.println(id);
	}

}