package io.smartnexus.ats.pojo;

public class ActivateProduct {

	private String apiVersion;
	private String os;
	private String rmaDate;
	private String osVersion;
	private String status;
	private String serialNumber;
	private String mac;
	private String hwVersion;
	private String swName;
	private String batch;
	private String rma;
	private String cuId;
	private String agentType;
	private String buildDate;
	private String platformArch;
	private String agentVersion;
	private String hwName;
	private String swVersion;

	public String getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getRmaDate() {
		return rmaDate;
	}

	public void setRmaDate(String rmaDate) {
		this.rmaDate = rmaDate;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getHwVersion() {
		return hwVersion;
	}

	public void setHwVersion(String hwVersion) {
		this.hwVersion = hwVersion;
	}

	public String getSwName() {
		return swName;
	}

	public void setSwName(String swName) {
		this.swName = swName;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getRma() {
		return rma;
	}

	public void setRma(String rma) {
		this.rma = rma;
	}

	public String getCuId() {
		return cuId;
	}

	public void setCuId(String cuId) {
		this.cuId = cuId;
	}

	public String getAgentType() {
		return agentType;
	}

	public void setAgentType(String agentType) {
		this.agentType = agentType;
	}

	public String getBuildDate() {
		return buildDate;
	}

	public void setBuildDate(String buildDate) {
		this.buildDate = buildDate;
	}

	public String getPlatformArch() {
		return platformArch;
	}

	public void setPlatformArch(String platformArch) {
		this.platformArch = platformArch;
	}

	public String getAgentVersion() {
		return agentVersion;
	}

	public void setAgentVersion(String agentVersion) {
		this.agentVersion = agentVersion;
	}

	public String getHwName() {
		return hwName;
	}

	public void setHwName(String hwName) {
		this.hwName = hwName;
	}

	public String getSwVersion() {
		return swVersion;
	}

	public void setSwVersion(String swVersion) {
		this.swVersion = swVersion;
	}

	@Override
	public String toString() {
		return "ActivateProduct [apiVersion = " + apiVersion + ", os = " + os + ", rmaDate = " + rmaDate + ", osVersion = " + osVersion + ", status = " + status
			+ ", serialNumber = " + serialNumber + ", mac = " + mac + ", hwVersion = " + hwVersion + ", swName = " + swName + ", batch = " + batch + ", rma = " + rma
			+ ", cuId = " + cuId + ", agentType = " + agentType + ", buildDate = " + buildDate + ", platformArch = " + platformArch + ", agentVersion = " + agentVersion
			+ ", hwName = " + hwName + ", swVersion = " + swVersion + "]";
	}
}