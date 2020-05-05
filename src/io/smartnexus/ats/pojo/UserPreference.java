package io.smartnexus.ats.pojo;

public class UserPreference {

	private String deliverymethodid;
	private String value;
	private String attributeId;

	public String getDeliverymethodid() {
		return deliverymethodid;
	}

	public void setDeliverymethodid(String deliverymethodid) {
		this.deliverymethodid = deliverymethodid;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(String attributeId) {
		this.attributeId = attributeId;
	}

	@Override
	public String toString() {
		return "ClassPojo [deliverymethodid = " + deliverymethodid + ", value = " + value + ", attributeId = " + attributeId + "]";
	}
}