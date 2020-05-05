package io.smartnexus.ats.pojo;

public class Options {
	private String value;
	private String key;

	public String getValue() {
		return value;
	}

	public void setValue(String Value) {
		this.value = Value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String Key) {
		this.key = Key;
	}

	@Override
	public String toString() {
		return "Options [Value = " + value + ", Key = " + key + "]";
	}
}
