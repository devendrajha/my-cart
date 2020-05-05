package io.smartnexus.ats.pojo;

public class QueueFieldValues {
	private String timestamp;

	private String fieldvalue;

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getFieldvalue() {
		return fieldvalue;
	}

	public void setFieldvalue(String fieldvalue) {
		this.fieldvalue = fieldvalue;
	}

	@Override
	public String toString() {
		return "QueueFieldValues [timestamp = " + timestamp + ", fieldvalue = " + fieldvalue + "]";
	}
}
