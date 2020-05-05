package io.smartnexus.ats.pojo;

public class Product {
	private String count;
	private ProductList[] data;

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public ProductList[] getData() {
		return data;
	}

	public void setData(ProductList[] data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ClassPojo [count = " + count + ", data = " + data + "]";
	}
}