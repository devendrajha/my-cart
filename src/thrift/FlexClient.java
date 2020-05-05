package io.smartnexus.ats.thrift;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import io.smartnexus.ats.utils.PropertiesUtils;

public class FlexClient {
	static String agent_host = "127.0.0.1";
	static int agent_port = 9999;

	String MAC = "00-00-00-00-00-00";
	String OS = "RTOS";
	String OSVersion = "3.2.8";
	String ApiVersion = "1.0";
	String Batch = "100";
	String RMA = "123";
	String RmaDate = "2016-05-05T06:00:00.000Z";
	String HwVersion = "1.0.0";
	String Builddate = "2014-05-05T06:00:00.000Z";
	String SN = "1540815996906";
	String SwVersion = "1.0.1";
	String SwName = "eApp";
	String HwName = "IP Blub";
	String Status = "0x10 (Product is activated)";
	String DeviceId = "1540815996906";
	String CustomerUniqueId = "";
	String PlatformArch = "x86";
	String AgentType = "Linux";
	DeviceInfoStruct deviceInfoStruct = new DeviceInfoStruct();
	List<Integer> list = new ArrayList<Integer>();
	EpCreateStruct epStruct;
	PropertiesUtils propertieUtil = new PropertiesUtils();
	Properties properties = propertieUtil.loadProps();
	// String CustomerUniqueId=properties.getProperty("cUId");
	int epStartId = 0;

	public static void main(String[] args) throws InterruptedException {
		TTransport transport = new TSocket(agent_host, agent_port);
		try {
			transport.open();
			TProtocol protocol = new TBinaryProtocol(transport);
			AgentService.Client client = new AgentService.Client(protocol);
			new FlexClient().callingAgent(client);

		} catch (TException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Inside Catch");
		}
	}

	public void callingAgent(AgentService.Client client) throws TException, InterruptedException {
		System.out.println("Client..............");

		DeviceInfoStruct deviceInfoStruct = new DeviceInfoStruct();
		deviceInfoStruct.setMAC(MAC);
		deviceInfoStruct.setOS(OS);
		deviceInfoStruct.setOSVersion(OSVersion);
		deviceInfoStruct.setApiVersion(ApiVersion);
		deviceInfoStruct.setBatch(Batch);
		deviceInfoStruct.setRMA(PlatformArch);
		deviceInfoStruct.setRmaDate(RmaDate);
		deviceInfoStruct.setHwVersion(HwVersion);
		deviceInfoStruct.setBuilddate(Builddate);
		deviceInfoStruct.setSN(SN);
		deviceInfoStruct.setSwVersion(SwVersion);
		deviceInfoStruct.setSwName(SwName);
		deviceInfoStruct.setHwName(HwName);
		deviceInfoStruct.setStatus(Status);
		deviceInfoStruct.setDeviceId(DeviceId);

		deviceInfoStruct.setCustomerUniqueId(CustomerUniqueId);
		deviceInfoStruct.setPlatformArch(PlatformArch);
		deviceInfoStruct.setAgentType(AgentType);

		client.Init(deviceInfoStruct);
		Result r1 = client.GetConfigStatus();
		System.out.println("GetConfigStatus " + r1);
		Result r2 = client.GetConfig();
		System.out.println("GetConfig " + r2);
		Result r3 = client.GetActivationStatus();
		System.out.println("GetActivationStatus " + r3);
		client.GetConfig();
		Result activate = client.Activate();
		Result sync1 = client.Sync(0);
		System.out.println("activate " + activate);
		System.out.println("sync " + sync1);
		Result conn = client.Connect();
		System.out.println("Connect " + conn);

		MultiEpCreateStruct epCreateStruct = new MultiEpCreateStruct();
		List<MultiEpCreateStruct> list = new ArrayList<MultiEpCreateStruct>();

		epCreateStruct.setManufacturerId("mfg0E31");
//		epCreateStruct.setName("dep-" + new BigInteger(32, new SecureRandom()).toString(32));
		list.add(epCreateStruct);
		/*
		 * MultiEpCreateStruct epCreateStruct2 = new MultiEpCreateStruct();
		 * epCreateStruct2.setManufacturerId("mfg0E31");
		 * epCreateStruct2.setName("dep-" + new BigInteger(32, new
		 * SecureRandom()).toString(32)); epCreateStruct2.setUserField("id-2" +
		 * 12313); list.add(epCreateStruct2);
		 */
		EpCreateStruct localEpId = client.AddDynamicEndpoint(list);
		client.Sync(0);
		epStartId = localEpId.getEp_create_id();
		System.out.println("epStartId "+epStartId);
		String value = "{\"name\":\"John\",\"age\":30,\"cars\":[ \"Ford\", \"BMW\", \"Fiat\" ]}";

		DataElementStruct dataElementStruct = new DataElementStruct();
		dataElementStruct.setType(DataElementType.DATA_TYPE_JSON);
		StringArrayType stringtype = new StringArrayType();
		stringtype.setBuffer(value.toString());
		stringtype.setLength(value.length());

		dataElementStruct.setJsonDataElement(stringtype);
		Result res = client.SendAttributeMessage(0, 10, dataElementStruct,0);
/*
		DataElementStruct str = new DataElementStruct();
		StringArrayType arrayType = new StringArrayType();
		arrayType.setBuffer(value.toString());
		arrayType.setLength(value.length());
		str.setType(DataElementType.DATA_TYPE_JSON);
		str.setJsonDataElement(arrayType);
		Result res6 = client.SendAttributeMessage(0, 10, str,0);
*/
		//////////////////////////////////////////////////////////////////////////////////////////////////////////
		/*String value2="post";
		
		DataElementStruct str9 = new DataElementStruct();
		StringArrayType arrayType9 = new StringArrayType();
		arrayType9.setBuffer(value2.toString());
		arrayType9.setLength(value2.length());
		str9.setType(DataElementType.DATA_TYPE_STRING);
		str9.setStringDataElement(arrayType9);
		Result res9 = client.SendAttributeMessage(0, 6, str9,0);

		System.out.println(res+" "+res6+ " "+res9);
		
		updateAttrValueForStringDataType(client, 0, 10, value2);
	*/
		
		updateAttrValueForStringDataType(client, 0, 1, "");
	
	}

	public String updateAttrValueForStringDataType(AgentService.Client client, int epid, int attrid, String value)
			throws TException {
		
		value="{\r\n  \"mac\": \"string\",\r\n  \"os\": \"string\",\r\n  \"osVersion\": \"string\",\r\n  \"apiVersion\": \"string\",\r\n  \"batch\": \"string\",\r\n  \"rma\": \"string\",\r\n  \"rmaDate\": \"2017-12-18T06:17:42.545Z\",\r\n  \"hwVersion\": \"string\",\r\n  \"builddate\": \"2017-12-18T06:17:42.545Z\",\r\n  \"sn\": \"string\",\r\n  \"swVersion\": \"string\",\r\n  \"swName\": \"string\",\r\n  \"hwName\": \"string\",\r\n  \"agentVersion\": \"string\",\r\n  \"platformArch\": \"Mac\",\r\n  \"agentType\": \"Mac\"\r\n}";
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
		
		String value2="{\r\n  \"mac\": \"string\",\r\n  \"os\": \"string\",\r\n  \"osVersion\": \"string\",\r\n  \"apiVersion\": \"string\",\r\n  \"batch\": \"string\",\r\n  \"rma\": \"string\",\r\n  \"rmaDate\": \"2017-12-18T06:17:42.545Z\",\r\n  \"hwVersion\": \"string\",\r\n  \"builddate\": \"2017-12-18T06:17:42.545Z\",\r\n  \"sn\": \"string\",\r\n  \"swVersion\": \"string\",\r\n  \"swName\": \"string\",\r\n  \"hwName\": \"string\",\r\n  \"agentVersion\": \"string\",\r\n  \"platformArch\": \"Linux\",\r\n  \"agentType\": \"Linux\"\r\n}";
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
		
	
		
		client.InitEndpointMessage();
		client.UpdateEndpointMessage(epid, list);
		Result res = client.SendEndpointMessage(0);

		return res.toString();

	}
}