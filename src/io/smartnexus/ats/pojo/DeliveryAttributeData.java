package io.smartnexus.ats.pojo;

public class DeliveryAttributeData {
	private String AttributeName;
	private String AttributeId;

	public String getAttributeName() {
		return AttributeName;
	}

	public void setAttributeName(String AttributeName) {
		this.AttributeName = AttributeName;
	}

	public String getAttributeId() {
		return AttributeId;
	}

	public void setAttributeId(String AttributeId) {
		this.AttributeId = AttributeId;
	}

	@Override
	public String toString() {
		return "ClassPojo [AttributeName = " + AttributeName + ", AttributeId = " + AttributeId + "]";
	}
}