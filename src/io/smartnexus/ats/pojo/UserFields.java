package io.smartnexus.ats.pojo;

public class UserFields {
	private String dataType;
	private String order;
	private String description;
	private String name;
	private String dataTypeName;
	private String fieldId;
	private String apiKey;

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDataTypeName() {
		return dataTypeName;
	}

	public void setDataTypeName(String dataTypeName) {
		this.dataTypeName = dataTypeName;
	}

	public String getFieldId() {
		return fieldId;
	}

	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	/*
	 * @Override public String toString() { return
	 * "ClassPojo [dataType = "+dataType+", order = "+order+", description = "
	 * +description+", name = "+name+", dataTypeName = "+dataTypeName+", fieldId = "
	 * +fieldId+", apiKey = "+apiKey+"]"; }
	 */
}
