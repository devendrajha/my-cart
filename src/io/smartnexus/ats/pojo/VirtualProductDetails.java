package io.smartnexus.ats.pojo;

public class VirtualProductDetails {
	private String Telephone;
	private String VirtualProductId;
	private String NickName;
	private String FirstName;
	private String ProductName;
	private String SecondaryEmail;
	private String UserEmail;
	private String UserId;
	private String LastName;
	private String ProductId;
	private String IsPrimaryVirtualProduct;
	private String VirtualProductName;

	public String getTelephone() {
		return Telephone;
	}

	public void setTelephone(String Telephone) {
		this.Telephone = Telephone;
	}

	public String getVirtualProductId() {
		return VirtualProductId;
	}

	public void setVirtualProductId(String VirtualProductId) {
		this.VirtualProductId = VirtualProductId;
	}

	public String getNickName() {
		return NickName;
	}

	public void setNickName(String NickName) {
		this.NickName = NickName;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String ProductName) {
		this.ProductName = ProductName;
	}

	public String getSecondaryEmail() {
		return SecondaryEmail;
	}

	public void setSecondaryEmail(String SecondaryEmail) {
		this.SecondaryEmail = SecondaryEmail;
	}

	public String getUserEmail() {
		return UserEmail;
	}

	public void setUserEmail(String UserEmail) {
		this.UserEmail = UserEmail;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String UserId) {
		this.UserId = UserId;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String LastName) {
		this.LastName = LastName;
	}

	public String getProductId() {
		return ProductId;
	}

	public void setProductId(String ProductId) {
		this.ProductId = ProductId;
	}

	public String getIsPrimaryVirtualProduct() {
		return IsPrimaryVirtualProduct;
	}

	public void setIsPrimaryVirtualProduct(String IsPrimaryVirtualProduct) {
		this.IsPrimaryVirtualProduct = IsPrimaryVirtualProduct;
	}

	public String getVirtualProductName() {
		return VirtualProductName;
	}

	public void setVirtualProductName(String VirtualProductName) {
		this.VirtualProductName = VirtualProductName;
	}

	@Override
	public String toString() {
		return "VirtualProductDetails [Telephone = " + Telephone + ", VirtualProductId = " + VirtualProductId + ", NickName = " + NickName + ", FirstName = "
			+ FirstName + ", ProductName = " + ProductName + ", SecondaryEmail = " + SecondaryEmail + ", UserEmail = " + UserEmail + ", UserId = " + UserId
			+ ", LastName = " + LastName + ", ProductId = " + ProductId + ", IsPrimaryVirtualProduct = " + IsPrimaryVirtualProduct + ", VirtualProductName = "
			+ VirtualProductName + "]";
	}
}
