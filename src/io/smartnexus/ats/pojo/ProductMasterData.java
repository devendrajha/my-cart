package io.smartnexus.ats.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProductMasterData {
	private String Name;
	private String Description;
	private String ProductLineId;
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

	public String getProductLineId() {
		return ProductLineId;
	}

	public void setProductLineId(String productLineId) {
		ProductLineId = productLineId;
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

	@Override
	public String toString() {
		return "ClassPojo [Name = " + Name + ", Description = " + Description + ", ProductLineId = " + ProductLineId + ", IndustryId = " + IndustryId + ", Sku = "
			+ Sku + "]";
	}
}