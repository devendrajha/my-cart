package io.smartnexus.ats.pojo;

public class SettingValue {
	private String value;
	private String fId;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getFId() {
		return fId;
	}

	public void setFId(String fId) {
		this.fId = fId;
	}

	@Override
	public String toString() {
		return "ClassPojo [value = " + value + ", fId = " + fId + "]";
	}
}