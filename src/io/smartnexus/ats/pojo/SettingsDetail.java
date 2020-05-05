package io.smartnexus.ats.pojo;

public class SettingsDetail {
	private String fieldvalue;
	private ListOfPossibleValues[] listOfPossibleValues;
	private String formType;
	private String modifieddate;
	private QueueFieldValues[] queueFieldValues;
	private String[] constraints;
	private String fId;
	private String deviceTimestamp;
	private String name;
	private String enctype;
	private String datatype;
	private String defaultvalue;
	private String datatypename;

	public String getFieldvalue() {
		return fieldvalue;
	}

	public void setFieldvalue(String fieldvalue) {
		this.fieldvalue = fieldvalue;
	}

	public ListOfPossibleValues[] getListOfPossibleValues() {
		return listOfPossibleValues;
	}

	public void setListOfPossibleValues(ListOfPossibleValues[] listOfPossibleValues) {
		this.listOfPossibleValues = listOfPossibleValues;
	}

	public String getFormType() {
		return formType;
	}

	public void setFormType(String formType) {
		this.formType = formType;
	}

	public String getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(String modifieddate) {
		this.modifieddate = modifieddate;
	}

	public QueueFieldValues[] getQueueFieldValues() {
		return queueFieldValues;
	}

	public void setQueueFieldValues(QueueFieldValues[] queueFieldValues) {
		this.queueFieldValues = queueFieldValues;
	}

	public String[] getConstraints() {
		return constraints;
	}

	public void setConstraints(String[] constraints) {
		this.constraints = constraints;
	}

	public String getFId() {
		return fId;
	}

	public void setFId(String fId) {
		this.fId = fId;
	}

	public String getDeviceTimestamp() {
		return deviceTimestamp;
	}

	public void setDeviceTimestamp(String deviceTimestamp) {
		this.deviceTimestamp = deviceTimestamp;
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

	public String getDatatype() {
		return datatype;
	}

	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}

	public String getDefaultvalue() {
		return defaultvalue;
	}

	public void setDefaultvalue(String defaultvalue) {
		this.defaultvalue = defaultvalue;
	}

	public String getDatatypename() {
		return datatypename;
	}

	public void setDatatypename(String datatypename) {
		this.datatypename = datatypename;
	}

	@Override
	public String toString() {
		return "ClassPojo [fieldvalue = " + fieldvalue + ", listOfPossibleValues = " + listOfPossibleValues + ", formType = " + formType + ", modifieddate = "
			+ modifieddate + ", queueFieldValues = " + queueFieldValues + ", constraints = " + constraints + ", fId = " + fId + ", deviceTimestamp = " + deviceTimestamp
			+ ", name = " + name + ", enctype = " + enctype + ", datatype = " + datatype + ", defaultvalue = " + defaultvalue + ", datatypename = " + datatypename + "]";
	}
}