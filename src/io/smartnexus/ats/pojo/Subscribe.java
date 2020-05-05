package io.smartnexus.ats.pojo;

import java.util.List;

public class Subscribe {
	private String cuId;
	private String userEmail;
	private List deliveryMethods;
	private String productMasterSku;

	public String getCuId() {
		return cuId;
	}

	public void setCuId(String cuId) {
		this.cuId = cuId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public List getDeliveryMethods() {
		return deliveryMethods;
	}

	public void setDeliveryMethods(List deliveryMethods) {
		this.deliveryMethods = deliveryMethods;
	}

	public String getProductLineSku() {
		return productMasterSku;
	}

	public void setProductLineSku(String productLineSku) {
		this.productMasterSku = productLineSku;
	}

	@Override
	public String toString() {
		return "Subscribe [cuId = " + cuId + ", userEmail = " + userEmail + ", deliveryMethods = " + deliveryMethods + ", productLineSku = " + productMasterSku + "]";
	}
}