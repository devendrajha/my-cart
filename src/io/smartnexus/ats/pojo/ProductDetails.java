package io.smartnexus.ats.pojo;

public class ProductDetails {
	private String AgentVersion;
	private String DeviceId;
	private String Builddate;
	private String connectionState;
	private String OSVersion;
	private String lastActiveTime;
	private String AgentType;
	private String OS;
	private String SwVersion;
	private String SN;
	private String PlatformArch;
	private String ProductId;
	private String SwName;
	private String ApiVersion;
	private String HwVersion;
	private String Status;
	private String IoTDeviceId;
	private String Batch;
	private String lastSyncDate;
	private String ProductlineId;
	private String HwName;
	private String RMA;
	private String MAC;
	private String RmaDate;

	public String getAgentVersion() {
		return AgentVersion;
	}

	public void setAgentVersion(String AgentVersion) {
		this.AgentVersion = AgentVersion;
	}

	public String getDeviceId() {
		return DeviceId;
	}

	public void setDeviceId(String DeviceId) {
		this.DeviceId = DeviceId;
	}

	public String getBuilddate() {
		return Builddate;
	}

	public void setBuilddate(String Builddate) {
		this.Builddate = Builddate;
	}

	public String getConnectionState() {
		return connectionState;
	}

	public void setConnectionState(String connectionState) {
		this.connectionState = connectionState;
	}

	public String getOSVersion() {
		return OSVersion;
	}

	public void setOSVersion(String OSVersion) {
		this.OSVersion = OSVersion;
	}

	public String getLastActiveTime() {
		return lastActiveTime;
	}

	public void setLastActiveTime(String lastActiveTime) {
		this.lastActiveTime = lastActiveTime;
	}

	public String getAgentType() {
		return AgentType;
	}

	public void setAgentType(String AgentType) {
		this.AgentType = AgentType;
	}

	public String getOS() {
		return OS;
	}

	public void setOS(String OS) {
		this.OS = OS;
	}

	public String getSwVersion() {
		return SwVersion;
	}

	public void setSwVersion(String SwVersion) {
		this.SwVersion = SwVersion;
	}

	public String getSN() {
		return SN;
	}

	public void setSN(String SN) {
		this.SN = SN;
	}

	public String getPlatformArch() {
		return PlatformArch;
	}

	public void setPlatformArch(String PlatformArch) {
		this.PlatformArch = PlatformArch;
	}

	public String getProductId() {
		return ProductId;
	}

	public void setProductId(String ProductId) {
		this.ProductId = ProductId;
	}

	public String getSwName() {
		return SwName;
	}

	public void setSwName(String SwName) {
		this.SwName = SwName;
	}

	public String getApiVersion() {
		return ApiVersion;
	}

	public void setApiVersion(String ApiVersion) {
		this.ApiVersion = ApiVersion;
	}

	public String getHwVersion() {
		return HwVersion;
	}

	public void setHwVersion(String HwVersion) {
		this.HwVersion = HwVersion;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String Status) {
		this.Status = Status;
	}

	public String getIoTDeviceId() {
		return IoTDeviceId;
	}

	public void setIoTDeviceId(String IoTDeviceId) {
		this.IoTDeviceId = IoTDeviceId;
	}

	public String getBatch() {
		return Batch;
	}

	public void setBatch(String Batch) {
		this.Batch = Batch;
	}

	public String getLastSyncDate() {
		return lastSyncDate;
	}

	public void setLastSyncDate(String lastSyncDate) {
		this.lastSyncDate = lastSyncDate;
	}

	public String getProductlineId() {
		return ProductlineId;
	}

	public void setProductlineId(String ProductlineId) {
		this.ProductlineId = ProductlineId;
	}

	public String getHwName() {
		return HwName;
	}

	public void setHwName(String HwName) {
		this.HwName = HwName;
	}

	public String getRMA() {
		return RMA;
	}

	public void setRMA(String RMA) {
		this.RMA = RMA;
	}

	public String getMAC() {
		return MAC;
	}

	public void setMAC(String MAC) {
		this.MAC = MAC;
	}

	public String getRmaDate() {
		return RmaDate;
	}

	public void setRmaDate(String RmaDate) {
		this.RmaDate = RmaDate;
	}

	@Override
	public String toString() {
		return "ClassPojo [AgentVersion = " + AgentVersion + ", DeviceId = " + DeviceId + ", Builddate = " + Builddate + ", connectionState = " + connectionState
			+ ", OSVersion = " + OSVersion + ", lastActiveTime = " + lastActiveTime + ", AgentType = " + AgentType + ", OS = " + OS + ", SwVersion = " + SwVersion
			+ ", SN = " + SN + ", PlatformArch = " + PlatformArch + ", ProductId = " + ProductId + ", SwName = " + SwName + ", ApiVersion = " + ApiVersion
			+ ", HwVersion = " + HwVersion + ", Status = " + Status + ", IoTDeviceId = " + IoTDeviceId + ", Batch = " + Batch + ", lastSyncDate = " + lastSyncDate
			+ ", ProductlineId = " + ProductlineId + ", HwName = " + HwName + ", RMA = " + RMA + ", MAC = " + MAC + ", RmaDate = " + RmaDate + "]";
	}
}