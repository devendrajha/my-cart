package io.smartnexus.ats.thrift;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.thrift.TException;


public class AgentClient {

	private static final Logger log = Logger.getLogger(AgentClient.class.getName());
	DeviceInfoStruct deviceInfoStruct = new DeviceInfoStruct();
	List<Integer> depLocalIdList = new ArrayList<Integer>();
	EpCreateStruct epStruct;

	
	
	public String activateProduct(AgentService.Client client, String serialNumber, String deviceId) {
		deviceInfoStruct.setMAC("1256-7889-0158-4090-1100");
		deviceInfoStruct.setOS("RTOS");
		deviceInfoStruct.setOSVersion("3.9.0");
		deviceInfoStruct.setApiVersion("3.8.0");
		deviceInfoStruct.setBatch("201");
		deviceInfoStruct.setRMA("708");
		deviceInfoStruct.setRmaDate("2017-06-06T06:00:00.000Z");
		deviceInfoStruct.setHwVersion("2.0.1");
		deviceInfoStruct.setBuilddate("2017-06-06T06:00:00.000Z");
		deviceInfoStruct.setSN(serialNumber);
		deviceInfoStruct.setSwVersion("4.8.0");
		deviceInfoStruct.setSwName("Wifi");
		deviceInfoStruct.setHwName("IP Bulb");
		deviceInfoStruct.setStatus("0x64 (Product is activated)");
		deviceInfoStruct.setDeviceId(deviceId);
		// deviceInfoStruct.setCustomerUniqueId(customerUniqueId);
		deviceInfoStruct.setPlatformArch("0x64");
		deviceInfoStruct.setAgentType("iOS");
		Result activate = null;
		try {
			client.Init(deviceInfoStruct);
			Result r1 = client.GetConfigStatus();
			log.debug("GetConfigStatus " + r1);
			Result r2 = client.GetConfig();
			log.debug("GetConfig " + r2);
			Result r3 = client.GetActivationStatus();
			log.debug("GetActivationStatus " + r3);
			client.GetConfig();
			activate = client.Activate();
			Thread.sleep(6000);
			Result sync = client.Sync(0);
			log.debug("activate " + activate);
			log.debug("sync " + sync);
		} catch (TException | InterruptedException e) {
			log.debug("Device is not activate ");
		}

		log.debug("Response of activate is " + activate);
		return activate.toString();

	}

	public String productConnect(AgentService.Client client) {
		Result connect = null;
		try {
			Thread.sleep(6000);
			connect = client.Connect();
			log.debug("Response of connect is " + connect);
		} catch (InterruptedException | TException e) {
			log.debug("Device not Connected ");
		}
		return connect.toString();
	}

	public String productConnect2(AgentService.Client client) {
		Result connect = null;
		try {
			Thread.sleep(6000);
			connect = client.Connect();
			log.debug("Response of connect is " + connect);
		} catch (InterruptedException | TException e) {
			log.debug("Device not Connected ");
		}
		return connect.toString();
	}


	public String Disconnect(AgentService.Client client)  {
		Result connect = null;
		try {
			connect = client.Disconnect();
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		log.debug("Disconnect " + connect);
		return connect.toString();
	}

	public String deactivate(AgentService.Client client)  {
		Result deavtivate = null;
		try {
			deavtivate = client.ForceDeactivate();
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		log.debug("Disconnect " + deavtivate);
		return deavtivate.toString();
	}

	public int addDynamicEndpoint(AgentService.Client client, String mfgid)  {

		MultiEpCreateStruct epCreateStruct = new MultiEpCreateStruct();
		List<MultiEpCreateStruct> list = new ArrayList<MultiEpCreateStruct>();

		epCreateStruct.setManufacturerId("mfg0E31");
		epCreateStruct.setName("dep-" + new BigInteger(32, new SecureRandom()).toString(32));
		epCreateStruct.setUserField("id-" + System.currentTimeMillis());
		list.add(epCreateStruct);
		/*
		 * MultiEpCreateStruct epCreateStruct2 = new MultiEpCreateStruct();
		 * epCreateStruct2.setManufacturerId("mfg0E31"); epCreateStruct2.setName("dep-"
		 * + new BigInteger(32, new SecureRandom()).toString(32));
		 * epCreateStruct2.setUserField("id-2" + 12313); list.add(epCreateStruct2);
		 */
		EpCreateStruct localEpId = null;
		try {
			localEpId = client.AddDynamicEndpoint(list);
			client.Sync(0);
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		return localEpId.getEp_create_id();

	}

	public String productSync(AgentService.Client client, int type) {
		Result result = null;
		try {
			result = client.Sync(type);
		} catch (TException e) {
			e.getMessage();
			log.error("Full Sync failed");
		}
		return result.toString();
	}

	public String deleteDynamicEndpoint(AgentService.Client client, int LocalEpId)  {
		Result result = null;
		try {
			result = client.DeleteDynamicEndpoint(LocalEpId);
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return result.toString();

	}

	public String sendAttrValueForBooleanDataType(AgentService.Client client, int epid, int attrid, int boolvalue)  {
		boolean value = false;
		if (boolvalue == 1)
			value = true;
		DataElementStruct dataElementStruct = new DataElementStruct();
		dataElementStruct.setType(DataElementType.DATA_TYPE_BOOL);
		dataElementStruct.setBoolDataElement(value);
		Result res = null;
		try {
			res = client.SendAttributeMessage(epid, attrid, dataElementStruct, 0);
			return res.toString();
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		log.debug("sendMessage from agent  " + res);
		return "";

	}

	public String sendAttrValueForIntegerDataType(AgentService.Client client, int epid, int attrid, int value)  {

		DataElementStruct dataElementStruct = new DataElementStruct();
		dataElementStruct.setType(DataElementType.DATA_TYPE_INTEGER);
		dataElementStruct.setIntegerDataElement(value);
		Result res = null;
		try {
			res = client.SendAttributeMessage(epid, attrid, dataElementStruct, 0);
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		log.debug("sendMessage from agent  " + res);
		return "";

	}

	public String sendAttrValueForByteDataType(AgentService.Client client, int epid, int attrid, int value)  {

		DataElementStruct dataElementStruct = new DataElementStruct();
		dataElementStruct.setType(DataElementType.DATA_TYPE_BYTE);
		dataElementStruct.setByteDataElement((short) value);
		Result res = null;
		try {
			res = client.SendAttributeMessage(epid, attrid, dataElementStruct, 0);
			return res.toString();
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		log.debug("sendMessage from agent  " + res);
		return "";

	}

	public String sendAttrValueForBigIntDataType(AgentService.Client client, int epId, int attrid, long value)  {
		DataElementStruct dataElementStruct = new DataElementStruct();
		dataElementStruct.setType(DataElementType.DATA_TYPE_BIGINT);
		dataElementStruct.setBigIntegerDataElement(value);
		Result res = null;
		try {
			res = client.SendAttributeMessage(epId, attrid, dataElementStruct, 0);
			return res.toString();
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		log.debug("sendMessage from agent  " + res);
		return "";

	}

	public String sendAttrValueForStringDataType(AgentService.Client client, int epid, int attrid, String value, int priority)  {

		DataElementStruct dataElementStruct = new DataElementStruct();
		StringArrayType stringtype = new StringArrayType();
		stringtype.setBuffer(value);
		stringtype.setLength(value.length());
		dataElementStruct.setType(DataElementType.DATA_TYPE_STRING);
		dataElementStruct.setStringDataElement(stringtype);
		Result res = null;
		try {
			res = client.SendAttributeMessage(epid, attrid, dataElementStruct, priority);
			return res.toString();
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}

		return "";

	}

	public String sendAttrValueFloatDataType(AgentService.Client client, int epid, int attrid, float value)  {

		DataElementStruct dataElementStruct = new DataElementStruct();
		dataElementStruct.setType(DataElementType.DATA_TYPE_FLOAT);
		dataElementStruct.setFloatDataElement(value);
		Result res = null;
		try {
			res = client.SendAttributeMessage(epid, attrid, dataElementStruct, 0);
			return res.toString();
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		log.debug("sendMessage from agent  " + res);
		return "";

	}

	public String sendAttrValueForDecimalDataType(AgentService.Client client, int epId, int attrid, double value)  {

		DataElementStruct dataElementStruct = new DataElementStruct();
		dataElementStruct.setType(DataElementType.DATA_TYPE_DECIMAL);
		dataElementStruct.setDecimalDataElement(value);
		Result res = null;
		try {
			res = client.SendAttributeMessage(epId, attrid, dataElementStruct, 0);
			return res.toString();
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		log.debug("sendMessage from agent  " + res);
		return "";

	}

	public String sendAttrValueForDoubleDataType(AgentService.Client client, int epid, int attrid, double value)  {

		DataElementStruct dataElementStruct = new DataElementStruct();
		dataElementStruct.setType(DataElementType.DATA_TYPE_DOUBLE);
		dataElementStruct.setDoubleDataElement(value);
		Result res = null;
		try {
			res = client.SendAttributeMessage(epid, attrid, dataElementStruct, 0);
			return res.toString();
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		log.debug("sendMessage from agent  " + res);
		return "";

	}

	public String sendAttrValueForLdoubleDataType(AgentService.Client client, int epId, int attrid, double value)  {

		DataElementStruct dataElementStruct = new DataElementStruct();
		dataElementStruct.setType(DataElementType.DATA_TYPE_LDOUBLE);
		dataElementStruct.setLdoubleDataElement(value);
		Result res = null;
		try {
			res = client.SendAttributeMessage(epId, attrid, dataElementStruct, 0);
			return res.toString();
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		log.debug("sendMessage from agent  " + res);
		return "";

	}

	public String sendSettValueForBooleanDataType(AgentService.Client client, int epid, int attrid, int boolvalue)  {
		boolean value = false;
		if (boolvalue == 1)
			value = true;
		DataElementStruct dataElementStruct = new DataElementStruct();
		dataElementStruct.setType(DataElementType.DATA_TYPE_BOOL);
		dataElementStruct.setBoolDataElement(value);
		Result res = null;
		try {
			res = client.SendSettingMessage(epid, attrid, dataElementStruct, 0);
			return res.toString();
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		log.debug("sendMessage from agent  " + res);
		return "";

	}

	public String sendSettValueForBigIntDataType(AgentService.Client client, int epId, int attrid, long value)  {
		DataElementStruct dataElementStruct = new DataElementStruct();
		dataElementStruct.setType(DataElementType.DATA_TYPE_BIGINT);
		dataElementStruct.setBigIntegerDataElement(value);
		Result res = null;
		try {
			res = client.SendSettingMessage(epId, attrid, dataElementStruct, 0);
			return res.toString();
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		log.debug("sendMessage from agent  " + res);
		return "";

	}

	public String sendSettValueForIntegerDataType(AgentService.Client client, int epid, int attrid, int value)  {

		DataElementStruct dataElementStruct = new DataElementStruct();
		dataElementStruct.setType(DataElementType.DATA_TYPE_INTEGER);
		dataElementStruct.setIntegerDataElement(value);
		Result res = null;
		try {
			res = client.SendSettingMessage(epid, attrid, dataElementStruct, 0);
			return res.toString();
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		log.debug("sendMessage from agent  " + res);
		return "";

	}

	public String sendSettValueForStringDataType(AgentService.Client client, int epid, int attrid, String value,int priority)  {

		DataElementStruct dataElementStruct = new DataElementStruct();

		StringArrayType arrayType = new StringArrayType();
		arrayType.setBuffer(value);
		arrayType.setLength(value.length());
		dataElementStruct.setType(DataElementType.DATA_TYPE_STRING);
		dataElementStruct.setStringDataElement(arrayType);
		Result res = null;
		try {
			res = client.SendSettingMessage(epid, attrid, dataElementStruct, priority);
			return res.toString();
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		log.debug("sendMessage from agent  " + res);
		return "";

	}

	public String sendSettValueForByteDataType(AgentService.Client client, int epid, int attrid, int value)  {

		DataElementStruct dataElementStruct = new DataElementStruct();
		dataElementStruct.setType(DataElementType.DATA_TYPE_BYTE);
		dataElementStruct.setByteDataElement((short) value);
		Result res = null;
		try {
			res = client.SendSettingMessage(epid, attrid, dataElementStruct, 0);
			return res.toString();
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		log.debug("sendMessage from agent  " + res);
		return "";

	}

	public String sendSettValueForDecimalDataType(AgentService.Client client, int epId, int attrid, double value)  {

		DataElementStruct dataElementStruct = new DataElementStruct();
		dataElementStruct.setType(DataElementType.DATA_TYPE_DECIMAL);
		dataElementStruct.setDecimalDataElement(value);
		Result res = null;
		try {
			res = client.SendSettingMessage(epId, attrid, dataElementStruct, 0);
			return res.toString();
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		log.debug("sendMessage from agent  " + res);
		return "";

	}

	public String sendSettValueFloatDataType(AgentService.Client client, int epId, int attrid, float value)  {

		DataElementStruct dataElementStruct = new DataElementStruct();
		dataElementStruct.setType(DataElementType.DATA_TYPE_FLOAT);
		dataElementStruct.setFloatDataElement(value);
		Result res = null;
		try {
			res = client.SendSettingMessage(epId, attrid, dataElementStruct, 0);
			return res.toString();
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		log.debug("sendMessage from agent  " + res);
		return "";

	}

	public String sendSettingValForDoubleDataType(AgentService.Client client, int epId, int attrid, double value)  {

		DataElementStruct dataElementStruct = new DataElementStruct();
		dataElementStruct.setType(DataElementType.DATA_TYPE_DOUBLE);
		dataElementStruct.setDoubleDataElement(value);
		Result res = null;
		try {
			res = client.SendSettingMessage(epId, attrid, dataElementStruct, 0);
			return res.toString();
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		log.debug("sendMessage from agent  " + res);
		return "";

	}

	public String sendSettingValForLdoubleDataType(AgentService.Client client, int epId, int attrid, double value)  {

		DataElementStruct dataElementStruct = new DataElementStruct();
		dataElementStruct.setType(DataElementType.DATA_TYPE_LDOUBLE);
		dataElementStruct.setLdoubleDataElement(value);
		Result res = null;
		try {
			res = client.SendSettingMessage(epId, attrid, dataElementStruct, 0);
			return res.toString();
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		log.debug("SendSettingMessag res  " + res);
		return "";

	}

	public String updateAttrValueForBooleanDataType(AgentService.Client client, int epid, int attrid, int boolvalue)  {
		boolean value = false;
		if (boolvalue == 1)
			value = true;

		List<AttributeStruct> list = new ArrayList<AttributeStruct>();
		AttributeStruct attr = new AttributeStruct();

		DataElementStruct dataElementStruct = new DataElementStruct();
		dataElementStruct.setType(DataElementType.DATA_TYPE_BOOL);
		dataElementStruct.setBoolDataElement(value);

		attr.setLocalAttrId(attrid);
		attr.setValue(dataElementStruct);

		list.add(attr);
		Result res = null;
		try {
			client.InitEndpointMessage();
			client.UpdateEndpointMessage(epid, list);
			res = client.SendEndpointMessage(0);
			return res.toString();
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}

		return "";

	}

	public String updateAttrValueForIntDataType(AgentService.Client client, int epid, int attrid, int value) {
		List<AttributeStruct> list = new ArrayList<AttributeStruct>();
		AttributeStruct attr = new AttributeStruct();

		DataElementStruct dataElementStruct = new DataElementStruct();
		dataElementStruct.setType(DataElementType.DATA_TYPE_INTEGER);
		dataElementStruct.setIntegerDataElement(value);

		attr.setLocalAttrId(attrid);
		attr.setValue(dataElementStruct);

		list.add(attr);
		Result res = null;
		try {
			client.InitEndpointMessage();
			client.UpdateEndpointMessage(epid, list);
			res = client.SendEndpointMessage(0);
			return res.toString();
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}

		return "";

	}

	public String updateAttrValueForByteDataType(AgentService.Client client, int epid, int attrid, int value)  {

		List<AttributeStruct> list = new ArrayList<AttributeStruct>();
		AttributeStruct attr = new AttributeStruct();

		DataElementStruct dataElementStruct = new DataElementStruct();
		dataElementStruct.setType(DataElementType.DATA_TYPE_BYTE);
		dataElementStruct.setByteDataElement((short) value);

		attr.setLocalAttrId(attrid);
		attr.setValue(dataElementStruct);

		list.add(attr);
		Result res = null;
		try {
			client.InitEndpointMessage();
			client.UpdateEndpointMessage(epid, list);
			res = client.SendEndpointMessage(0);
			return res.toString();
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}

		return "";

	}

	public String updateAttrValueForDecimalDataType(AgentService.Client client, int epid, int attrid, double value)  {

		List<AttributeStruct> list = new ArrayList<AttributeStruct>();
		AttributeStruct attr = new AttributeStruct();
		DataElementStruct dataElementStruct = new DataElementStruct();
		dataElementStruct.setType(DataElementType.DATA_TYPE_DECIMAL);
		dataElementStruct.setDecimalDataElement(value);

		attr.setLocalAttrId(attrid);
		attr.setValue(dataElementStruct);

		list.add(attr);
		Result res = null;
		try {
			client.InitEndpointMessage();
			client.UpdateEndpointMessage(epid, list);
			res = client.SendEndpointMessage(0);
			return res.toString();
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}

		return "";

	}

	public String updateAttrValueForBigIntDataType(AgentService.Client client, int epid, int attrid, long value)  {

		List<AttributeStruct> list = new ArrayList<AttributeStruct>();
		AttributeStruct attr = new AttributeStruct();
		DataElementStruct dataElementStruct = new DataElementStruct();
		dataElementStruct.setType(DataElementType.DATA_TYPE_BIGINT);
		dataElementStruct.setBigIntegerDataElement(value);

		attr.setLocalAttrId(attrid);
		attr.setValue(dataElementStruct);

		list.add(attr);
		Result res = null;
		try {
			client.InitEndpointMessage();
			client.UpdateEndpointMessage(epid, list);
			res = client.SendEndpointMessage(0);
			return res.toString();
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}

		return "";

	}

	public String updateAttrValueForStringDataType(AgentService.Client client, int epid, int attrid, String value) {
		DataElementStruct dataElementStruct = new DataElementStruct();

		StringArrayType arrayType = new StringArrayType();
		arrayType.setBuffer(value);
		arrayType.setLength(value.length());
		dataElementStruct.setType(DataElementType.DATA_TYPE_STRING);
		dataElementStruct.setStringDataElement(arrayType);

		List<AttributeStruct> list = new ArrayList<AttributeStruct>();
		AttributeStruct attr = new AttributeStruct();

		attr.setLocalAttrId(attrid);
		attr.setValue(dataElementStruct);

		list.add(attr);
		Result res = null;
		try {
			client.InitEndpointMessage();
			client.UpdateEndpointMessage(epid, list);

			res = client.SendEndpointMessage(0);
			return res.toString();
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}

		return "";

	}

	public String updateAttrValueForFloatDataType(AgentService.Client client, int epid, int attrid, float value)  {
		List<AttributeStruct> list = new ArrayList<AttributeStruct>();
		AttributeStruct attr = new AttributeStruct();
		DataElementStruct dataElementStruct = new DataElementStruct();
		dataElementStruct.setType(DataElementType.DATA_TYPE_FLOAT);
		dataElementStruct.setFloatDataElement(value);

		attr.setLocalAttrId(attrid);
		attr.setValue(dataElementStruct);

		list.add(attr);
		Result res = null;
		try {
			client.InitEndpointMessage();
			client.UpdateEndpointMessage(epid, list);
			res = client.SendEndpointMessage(0);
			return res.toString();
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}

		return "";

	}

	public String updateAttrValueForDoubleDataType(AgentService.Client client, int epid, int attrid, double value)  {
		List<AttributeStruct> list = new ArrayList<AttributeStruct>();
		AttributeStruct attr = new AttributeStruct();
		DataElementStruct dataElementStruct = new DataElementStruct();
		dataElementStruct.setType(DataElementType.DATA_TYPE_DOUBLE);
		dataElementStruct.setDoubleDataElement(value);

		attr.setLocalAttrId(attrid);
		attr.setValue(dataElementStruct);

		list.add(attr);
		Result res = null;
		try {
			client.InitEndpointMessage();
			client.UpdateEndpointMessage(epid, list);
			res = client.SendEndpointMessage(0);
			return res.toString();
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}

		return "";

	}

	public String updateAttrValueForLDoubleDataType(AgentService.Client client, int epid, int attrid, double value)  {

		List<AttributeStruct> list = new ArrayList<AttributeStruct>();
		AttributeStruct attr = new AttributeStruct();
		DataElementStruct dataElementStruct = new DataElementStruct();
		dataElementStruct.setType(DataElementType.DATA_TYPE_LDOUBLE);
		dataElementStruct.setLdoubleDataElement(value);

		attr.setLocalAttrId(attrid);
		attr.setValue(dataElementStruct);

		list.add(attr);
		Result res = null;
		try {
			client.InitEndpointMessage();
			client.UpdateEndpointMessage(epid, list);
			res = client.SendEndpointMessage(0);
			return res.toString();
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}

		return "";

	}

	public String updateSettings(AgentService.Client client, int epid, int attrid, int value) {
		List<SettingStruct> list = new ArrayList<SettingStruct>();
		SettingStruct attr = new SettingStruct();

		DataElementStruct data = new DataElementStruct();
		data.setType(DataElementType.DATA_TYPE_BOOL);
		data.setBoolDataElement(false);
		attr.setLocalSettingId(1);
		attr.setValue(data);

		SettingStruct attr2 = new SettingStruct();

		DataElementStruct data2 = new DataElementStruct();
		data2.setType(DataElementType.DATA_TYPE_INTEGER);
		data2.setIntegerDataElement(value);
		attr2.setLocalSettingId(2);
		attr2.setValue(data2);

		list.add(attr);
		list.add(attr2);
		Result res=null;
		try {
			client.InitSettingEndpointMessage();
			client.UpdateSettingEndpointMessage(epid, list);
			 res = client.SendSettingEndpointMessage(0);
			 return res.toString();


		} catch (TException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return "";

	}

	public String sendAttrValueForJsonDataType(AgentService.Client client, int epid, int attrid, String value,int priority) {

		DataElementStruct dataElementStruct = new DataElementStruct();
		StringArrayType stringtype = new StringArrayType();
		stringtype.setBuffer(value);
		stringtype.setLength(value.length());
		dataElementStruct.setType(DataElementType.DATA_TYPE_JSON);
		dataElementStruct.setJsonDataElement(stringtype);
		Result res = null;
		try {
			res = client.SendAttributeMessage(epid, attrid, dataElementStruct, priority);
			return res.toString();
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}

		return "";

	}

	public String sendSettValueForJsonDataType(AgentService.Client client, int epid, int attrid, String value,int priority){
		DataElementStruct dataElementStruct = new DataElementStruct();
		StringArrayType arrayType = new StringArrayType();
		arrayType.setBuffer(value);
		arrayType.setLength(value.length());
		dataElementStruct.setType(DataElementType.DATA_TYPE_JSON);
		dataElementStruct.setJsonDataElement(arrayType);
		Result res = null;
		try {
			res = client.SendSettingMessage(epid, attrid, dataElementStruct, priority);
			return res.toString();
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		log.debug("sendMessage from agent  " + res);
		return "";

	}

	public String updateAttrValueForJsonDataType(AgentService.Client client, int epid, int attrid, String value) {

		value = "{  \"swVersion\": \"1.63.0\",  \"swName\": \"Snp.io\",  \"hwName\": \"2.0.1\",  \"agentVersion\": \"1.29.0\",  \"platformArch\": \"linux\",  \"agentType\": \"Ubuntu\"}";
		DataElementStruct dataElementStruct = new DataElementStruct();

		StringArrayType arrayType = new StringArrayType();
		arrayType.setBuffer(value);
		arrayType.setLength(value.length());
		dataElementStruct.setType(DataElementType.DATA_TYPE_JSON);
		dataElementStruct.setJsonDataElement(arrayType);

		List<AttributeStruct> list = new ArrayList<AttributeStruct>();
		AttributeStruct attr = new AttributeStruct();
		attr.setLocalAttrId(attrid);
		attr.setValue(dataElementStruct);

		list.add(attr);
		Result res = null;
		try {
			client.InitEndpointMessage();
			client.UpdateEndpointMessage(epid, list);
			res = client.SendEndpointMessage(0);
			return res.toString();
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}

		return "";

	}

	public String sendAttrValueInQue(AgentService.Client client, int epid, int attrid){

		String value = "{\"A\":\"1\"}";
		DataElementStruct dataElementStruct = new DataElementStruct();

		StringArrayType arrayType = new StringArrayType();
		arrayType.setBuffer(value);
		arrayType.setLength(value.length());
		dataElementStruct.setType(DataElementType.DATA_TYPE_JSON);
		dataElementStruct.setJsonDataElement(arrayType);

		List<AttributeStruct> list = new ArrayList<AttributeStruct>();
		AttributeStruct attr = new AttributeStruct();

		attr.setLocalAttrId(attrid);
		attr.setValue(dataElementStruct);

		list.add(attr);

		String value2 ="{\"X\":\"101\"}" ;
		DataElementStruct dataElementStruct2 = new DataElementStruct();

		StringArrayType arrayType2 = new StringArrayType();
		arrayType2.setBuffer(value2);
		arrayType2.setLength(value2.length());
		dataElementStruct2.setType(DataElementType.DATA_TYPE_JSON);
		dataElementStruct2.setJsonDataElement(arrayType2);

		List<AttributeStruct> list2 = new ArrayList<AttributeStruct>();
		AttributeStruct attr2 = new AttributeStruct();

		attr2.setLocalAttrId(attrid);
		attr2.setValue(dataElementStruct2);

		list.add(attr2);
		Result res = null;
		try {
			client.InitEndpointMessage();
			client.UpdateEndpointMessage(epid, list);
			res = client.SendEndpointMessage(0);
			return res.toString();
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}

		return "";

	}
}
