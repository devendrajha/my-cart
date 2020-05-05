package io.smartnexus.ats.dts;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import io.smartnexus.ats.utils.Constants;
import io.smartnexus.ats.utils.NorthBoundInterface;
import io.smartnexus.ats.utils.Rest;
import io.smartnexus.ats.utils.TestNgParameters;

public class RestTemplateDTS {

	private static final Logger log = Logger.getLogger(RestTemplateDTS.class.getName());
	private Rest rest = new Rest();
	private TestNgParameters testNg = new TestNgParameters();
	Gson gson = new Gson();
	String tranformation;
	NorthBoundInterface nbi = new NorthBoundInterface();

	public String renameProperty(String cuid, String sku, int localId, String propertyName, String newPropertyName)
			throws IllegalStateException, IOException {
		String apiUrl = Constants.DTS_SERVICE + "transformation/" + localId + "/renameproperty";
		RenamePropertyObject obj = new RenamePropertyObject();
		obj.setCuId(cuid);
		obj.setSku(sku);
		obj.setPropertyName(propertyName);
		obj.setNewPropertyName(newPropertyName);
		obj.setMfgId("");
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(obj);
		HttpResponse response = rest.postRequest(apiUrl, jsonStr, nbi.getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		String propertyId = EntityUtils.toString(entity).replace("\"", "");
		return status + "," + propertyId;
	}

	public String removeProperty(String cuid, String sku, int localId, String propertyName)
			throws IllegalStateException, IOException {
		String apiUrl = Constants.DTS_SERVICE + "transformation/" + localId + "/removeproperty";
		RenamePropertyObject obj = new RenamePropertyObject();
		obj.setCuId(cuid);
		obj.setSku(sku);
		obj.setPropertyName(propertyName);
		obj.setMfgId("");
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = null;
		HttpResponse response;
		jsonStr = mapper.writeValueAsString(obj);
		response = rest.postRequest(apiUrl, jsonStr, nbi.getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		String rmPropertyId = EntityUtils.toString(entity).replace("\"", "");
		return status + "," + rmPropertyId;
	}

	public String addExternalApi(String cuid, String sku, int localId, String methodType, String url)
			throws IllegalStateException, IOException {
		String apiUrl = Constants.DTS_SERVICE + "transformation/" + localId + "/externalapi";
		ExternalPropertyObject obj = new ExternalPropertyObject();
		obj.setCuid(cuid);
		obj.setSku(sku);
		obj.setMfgId("");
		obj.setPropertyName(Constants.PROPERTY_NAME + System.currentTimeMillis());
		obj.setMethodType(methodType);
		obj.setUrl(url);
		obj.setHeaders("");
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(obj);
		HttpResponse response = rest.postRequest(apiUrl, jsonStr, nbi.getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		tranformation = EntityUtils.toString(entity).replace("\"", "");
		return status + "," + tranformation;
	}

	public String addCustomDataTransformation(String cuid, String sku, int localId)
			throws IllegalStateException, IOException {
		String apiUrl = Constants.DTS_SERVICE + "transformation/" + localId + "/customdata";
		String[] myArray = new String[] { getCustomPropertyId("name") };
		ExternalPropertyObject obj = new ExternalPropertyObject();
		obj.setCuid(cuid);
		obj.setSku(sku);
		obj.setMfgId("");
		obj.setCustomProperty(myArray);
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(obj);
		HttpResponse response = rest.postRequest(apiUrl, jsonStr, nbi.getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		String externalapi = EntityUtils.toString(entity).replace("\"", "");
		// externalapi = externalapi.replace("\"", "");
		return status + "," + externalapi;
	}

	public String addStripDiagnosticTransformation(String cuid, String sku, String name, int localId) throws Exception {
		String apiUrl = Constants.DTS_SERVICE + "transformation/" + localId + "/stripdiagnostics";
		ExternalPropertyObject obj = new ExternalPropertyObject();
		obj.setCuid(cuid);
		obj.setSku(sku);
		obj.setMfgId("");
		obj.setPropertyName(name);
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(obj);
		HttpResponse response = rest.postRequest(apiUrl, jsonStr, nbi.getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		String stripdiagnostics = EntityUtils.toString(entity).replace("\"", "");
		return status + "," + stripdiagnostics;
	}

	public String addUnitConversionTransformation(String cuid, String sku, String name, int localId, String id)
			throws Exception {
		String apiUrl = Constants.DTS_SERVICE + "transformation/" + localId + "/unitconversion";
		ExternalPropertyObject obj = new ExternalPropertyObject();
		obj.setCuid(cuid);
		obj.setSku(sku);
		obj.setMfgId("");
		obj.setPropertyName(name);
		obj.setConversionId(getConversionId(id));
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(obj);
		HttpResponse response = rest.postRequest(apiUrl, jsonStr, nbi.getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		String unitconversion = EntityUtils.toString(entity).replace("\"", "");
		return status + "," + unitconversion;
	}

	public String addDataTypeTransformation(String cuid, String sku, String name, int localId, int conversionTypeId)
			throws IllegalStateException, IOException {
		String apiUrl = Constants.DTS_SERVICE + "transformation/" + localId + "/datatypeconvert";
		ExternalPropertyObject obj = new ExternalPropertyObject();
		obj.setCuid(cuid);
		obj.setSku(sku);
		obj.setMfgId("");
		obj.setPropertyName(name);
		obj.setConversionTypeId(conversionTypeId);
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(obj);
		HttpResponse response = rest.postRequest(apiUrl, jsonStr, nbi.getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		String id = EntityUtils.toString(entity).replace("\"", "");
		// stripdiagnostics = stripdiagnostics.replace("\"", "");
		return status + "," + id;
	}

	public String addSortTransformation(String cuid, String sku, int localId)
			throws IllegalStateException, IOException {
		String apiUrl = Constants.DTS_SERVICE + "transformation/" + localId + "/sort";
		ExternalPropertyObject obj = new ExternalPropertyObject();
		obj.setCuid(cuid);
		obj.setSku(sku);
		obj.setMfgId("");
		obj.setHeaders("");
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(obj);
		HttpResponse response = rest.postRequest(apiUrl, jsonStr, nbi.getToken());
		int status = response.getStatusLine().getStatusCode();
		HttpEntity entity = response.getEntity();
		String id = EntityUtils.toString(entity);
		// stripdiagnostics = stripdiagnostics.replace("\"", "");
		return status + "," + id;
	}

	public int deletePropertyTransformation(String cuid, String id) throws IOException {
		String url = Constants.DTS_SERVICE + "transformation/" + id + "?cuId=" + cuid;
		int response = rest.delete(url, nbi.getToken());
		return response;
	}

	public String getMethodType(String type) {
		String url = Constants.DTS_SERVICE + "methodtype";
		MethodType[] response = null;
		String id = null;
		try {
			response = gson.fromJson(rest.getJson(url, nbi.getToken()), MethodType[].class);
		} catch (JsonSyntaxException | IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (MethodType methodType : response) {
			if (methodType.getName().equals(type)) {
				return methodType.getId();
			}
		}
		return id;
	}

	public String getCustomPropertyId(String type) {
		String url = Constants.DTS_SERVICE + "customproperty";
		MethodType[] response = null;
		String id = null;
		try {
			response = gson.fromJson(rest.getJson(url, nbi.getToken()), MethodType[].class);
		} catch (JsonSyntaxException | IllegalStateException e) {
			e.printStackTrace();
		}
		for (MethodType methodType : response) {
			if (methodType.getValue().equals(type)) {
				return methodType.getKey();
			}
		}
		return id;
	}

	public String getConversionId(String id) {
		String url = Constants.DTS_SERVICE + "transformation/unitconversion/all";
		ConversionId[] response = null;
		String cId = null;
		try {
			response = gson.fromJson(rest.getJson(url, nbi.getToken()), ConversionId[].class);
		} catch (JsonSyntaxException | IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (ConversionId methodType : response) {
			if (methodType.getConversionType().equals(id)) {
				return methodType.getId();
			}
		}
		return cId;
	}
	
}
