package io.smartnexus.ats.pojo;

public class ProductSetting {
	private String count;
	private ProductSettingData data;

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public ProductSettingData getData() {
		return data;
	}

	public void setData(ProductSettingData data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ClassPojo [count = " + count + ", data = " + data + "]";
	}
}