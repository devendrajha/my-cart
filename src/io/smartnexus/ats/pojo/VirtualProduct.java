package io.smartnexus.ats.pojo;

public class VirtualProduct {
	private String ProductMasterId;
	private String UserId;
	private String ProductId;
	private String VirtualProductName;

	public String getProductLineId() {
		return ProductMasterId;
	}

	public void setProductLineId(String ProductLineId) {
		this.ProductMasterId = ProductLineId;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String UserId) {
		this.UserId = UserId;
	}

	public String getProductId() {
		return ProductId;
	}

	public void setProductId(String ProductId) {
		this.ProductId = ProductId;
	}

	public String getVirtualProductName() {
		return VirtualProductName;
	}

	public void setVirtualProductName(String VirtualProductName) {
		this.VirtualProductName = VirtualProductName;
	}

	@Override
	public String toString() {
		return "VirtualProduct  [ProductLineId = " + ProductMasterId + ", UserId = " + UserId + ", ProductId = " + ProductId + ", VirtualProductName = "
			+ VirtualProductName + "]";
	}

}