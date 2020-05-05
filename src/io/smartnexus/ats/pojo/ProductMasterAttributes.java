package io.smartnexus.ats.pojo;

public class ProductMasterAttributes {
	private Attributes[] attributes;

	public Attributes[] getAttributes() {
		return attributes;
	}

	public void setAttributes(Attributes[] attributes) {
		this.attributes = attributes;
	}

	@Override
	public String toString() {
		return "ProductMasterAttributes [attributes = " + attributes + "]";
	}

}
