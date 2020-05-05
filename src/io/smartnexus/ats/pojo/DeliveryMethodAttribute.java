package io.smartnexus.ats.pojo;

public class DeliveryMethodAttribute {
	private DeliveryAttributeData[] DeliveryAttributeData;
	private String DeliveryMethod;

	public DeliveryAttributeData[] getDeliveryAttributeData() {
		return DeliveryAttributeData;
	}

	public void setDeliveryAttributeData(DeliveryAttributeData[] DeliveryAttributeData) {
		this.DeliveryAttributeData = DeliveryAttributeData;
	}

	public String getDeliveryMethod() {
		return DeliveryMethod;
	}

	public void setDeliveryMethod(String DeliveryMethod) {
		this.DeliveryMethod = DeliveryMethod;
	}

	@Override
	public String toString() {
		return "ClassPojo [DeliveryAttributeData = " + DeliveryAttributeData + ", DeliveryMethod = " + DeliveryMethod + "]";
	}
}