package io.smartnexus.ats.pojo;

public class ProductSettingHistory {
	private String count;
	private SettingHistory[] data;

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public SettingHistory[] getData() {
		return data;
	}

	public void setData(SettingHistory[] data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ClassPojo [count = " + count + ", data = " + data + "]";
	}
}