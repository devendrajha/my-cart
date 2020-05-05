package io.smartnexus.ats.pojo;

public class AttributeDetails {
	private String timestamp;
	private String deviceTimestamp;
	private String dataType;
	private String description;
	private String attibId;
	private String name;
	private String enctype;
	private String value;
	private String localId;
	private String dataTypeName;

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getDeviceTimestamp() {
		return deviceTimestamp;
	}

	public void setDeviceTimestamp(String deviceTimestamp) {
		this.deviceTimestamp = deviceTimestamp;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAttibId() {
		return attibId;
	}

	public void setAttibId(String attibId) {
		this.attibId = attibId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnctype() {
		return enctype;
	}

	public void setEnctype(String enctype) {
		this.enctype = enctype;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getLocalId() {
		return localId;
	}

	public void setLocalId(String localId) {
		this.localId = localId;
	}

	public String getDataTypeName() {
		return dataTypeName;
	}

	public void setDataTypeName(String dataTypeName) {
		this.dataTypeName = dataTypeName;
	}

	@Override
	public String toString() {
		return "ClassPojo [timestamp = " + timestamp + ", deviceTimestamp = " + deviceTimestamp + ", dataType = " + dataType + ", description = " + description
			+ ", attibId = " + attibId + ", name = " + name + ", enctype = " + enctype + ", value = " + value + ", localId = " + localId + ", dataTypeName = "
			+ dataTypeName + "]";
	}
}