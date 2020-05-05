package io.smartnexus.ats.pojo;

import java.util.Arrays;

public class GetAllEndPoint {
	private Settings[] settings;
 private String ver;
 private String endpointType;
 private String mfgId;
 private String epTmplId;
 private String epId;
 private String en;
 private String lastactivedate;
 private String serialNo;
 private String lastupdateddate;
 private String name;
 private String cmdTmplId;
 private String epLocalId;
 private Attr[] attr;
 private String status;
	public Settings[] getSettings() {
		return settings;
	}
	public String getVer() {
		return ver;
	}
	public String getEndpointType() {
		return endpointType;
	}
	public String getMfgId() {
		return mfgId;
	}
	public String getEpTmplId() {
		return epTmplId;
	}
	public String getEpId() {
		return epId;
	}
	public String getEn() {
		return en;
	}
	public String getLastactivedate() {
		return lastactivedate;
	}
	public String getSerialNo() {
		return serialNo;
	}
	public String getLastupdateddate() {
		return lastupdateddate;
	}
	public String getName() {
		return name;
	}
	public String getCmdTmplId() {
		return cmdTmplId;
	}
	public String getEpLocalId() {
		return epLocalId;
	}
	public Attr[] getAttr() {
		return attr;
	}
	public String getStatus() {
		return status;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GetAllEndPoint [settings=").append(Arrays.toString(settings)).append(", ver=").append(ver).append(", endpointType=").append(endpointType)
			.append(", mfgId=").append(mfgId).append(", epTmplId=").append(epTmplId).append(", epId=").append(epId).append(", en=").append(en)
			.append(", lastactivedate=").append(lastactivedate).append(", serialNo=").append(serialNo).append(", lastupdateddate=").append(lastupdateddate)
			.append(", name=").append(name).append(", cmdTmplId=").append(cmdTmplId).append(", epLocalId=").append(epLocalId).append(", attr=")
			.append(Arrays.toString(attr)).append(", status=").append(status).append("]");
		return builder.toString();
	}

 
 
}
