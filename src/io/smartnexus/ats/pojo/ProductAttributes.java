package io.smartnexus.ats.pojo;

public class ProductAttributes {
	private String count;
	private AttributeDetails[] data;

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public AttributeDetails[] getData() {
		return data;
	}

	public void setData(AttributeDetails[] data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ClassPojo [count = " + count + ", data = " + data + "]";
	}
}