package io.smartnexus.ats.pojo;

public class ListOfPossibleValues {
	private boolean defaultValue;
	private String value;

	public boolean getDefault() {
		return defaultValue;
	}

	public void setDefault(boolean defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "ListOfPossibleValues [default = " + defaultValue + ", value = " + value + "]";
	}
}
