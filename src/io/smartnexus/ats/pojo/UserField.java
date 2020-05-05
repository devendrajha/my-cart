package io.smartnexus.ats.pojo;

public class UserField {
	private String dataType;
	private String order;
	private String Value;
	private String Id;
	private String description;
	private String name;
	private String apiKey;
	private String dataTypeName;
	private String fieldId;

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getValue() {
		return Value;
	}

	public void setValue(String Value) {
		this.Value = Value;
	}

	public String getId() {
		return Id;
	}

	public void setId(String Id) {
		this.Id = Id;
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

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
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
	/*
	 * @Override public String toString() { return
	 * "ClassPojo [dataType = "+dataType+", order = "+order+", description = "
	 * +description+", name = "+name+", apiKey = " +apiKey+"]"; }
	 */

	/*
	 * @Override public String toString() { return
	 * "ClassPojo [dataType = "+dataType+", order = "+order+", description = "
	 * +description+", name = "
	 * +name+", dataTypeName = "+dataTypeName+", fieldId = "+fieldId+", apiKey = "
	 * +apiKey+"]"; }
	 */
}
