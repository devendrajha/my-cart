package io.smartnexus.ats.pojo;

public class ProductMaster {
	private String count;
	private ProductMasterData[] data;

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public ProductMasterData[] getData() {
		return data;
	}

	public void setData(ProductMasterData[] data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ProductMaster [count = " + count + ", data = " + data + "]";
	}
}
