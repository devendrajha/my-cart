package io.smartnexus.ats.pojo;

public class SettingsData {
	private String Status;
	private String FieldValue;
	private String CreatedBy;
	private String EncType;
	private String ConfirmedTime;
	private String DeviceTimestamp;
	private String Confirmed;

	public String getStatus() {
		return Status;
	}

	public void setStatus(String Status) {
		this.Status = Status;
	}

	public String getFieldValue() {
		return FieldValue;
	}

	public void setFieldValue(String FieldValue) {
		this.FieldValue = FieldValue;
	}

	public String getCreatedBy() {
		return CreatedBy;
	}

	public void setCreatedBy(String CreatedBy) {
		this.CreatedBy = CreatedBy;
	}

	public String getEncType() {
		return EncType;
	}

	public void setEncType(String EncType) {
		this.EncType = EncType;
	}

	public String getConfirmedTime() {
		return ConfirmedTime;
	}

	public void setConfirmedTime(String ConfirmedTime) {
		this.ConfirmedTime = ConfirmedTime;
	}

	public String getDeviceTimestamp() {
		return DeviceTimestamp;
	}

	public void setDeviceTimestamp(String DeviceTimestamp) {
		this.DeviceTimestamp = DeviceTimestamp;
	}

	public String getConfirmed() {
		return Confirmed;
	}

	public void setConfirmed(String Confirmed) {
		this.Confirmed = Confirmed;
	}

	@Override
	public String toString() {
		return "SettingsData [Status = " + Status + ", FieldValue = " + FieldValue + ", CreatedBy = " + CreatedBy + ", EncType = " + EncType + ", ConfirmedTime = "
			+ ConfirmedTime + ", DeviceTimestamp = " + DeviceTimestamp + ", Confirmed = " + Confirmed + "]";
	}
}
