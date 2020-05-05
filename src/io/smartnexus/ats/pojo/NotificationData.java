package io.smartnexus.ats.pojo;

public class NotificationData {
	private String mfgId;
	private String name;
	private Object value;
	private String localId;
	private String sku;
	private String deviceId;
	private String violationType;

	public String getMfgId() {
		return mfgId;
	}

	public void setMfgId(String mfgId) {
		this.mfgId = mfgId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getLocalId() {
		return localId;
	}

	public void setLocalId(String localId) {
		this.localId = localId;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getViolationType() {
		return violationType;
	}

	public void setViolationType(String violationType) {
		this.violationType = violationType;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "[sku=" + sku + "_ value=" + value + "]";
	}

}