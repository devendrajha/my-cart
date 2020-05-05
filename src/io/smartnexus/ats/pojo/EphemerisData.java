package io.smartnexus.ats.pojo;

public class EphemerisData {
	private String count;
	private SettingsData[] data;

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public SettingsData[] getData() {
		return data;
	}

	public void setData(SettingsData[] data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "SettingsHistory [count = " + count + ", data = " + data + "]";
	}
}