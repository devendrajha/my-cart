package io.smartnexus.ats.pojo;

public class CreateProductMaster {
	private String Name;
	private String Description;
	private String IndustryId;
	private String Sku;

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}

	public String getIndustryId() {
		return IndustryId;
	}

	public void setIndustryId(String IndustryId) {
		this.IndustryId = IndustryId;
	}

	public String getSku() {
		return Sku;
	}

	public void setSku(String Sku) {
		this.Sku = Sku;
	}

}
