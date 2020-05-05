package io.smartnexus.ats.pojo;

import java.util.List;

public class Settings {
	private int fid;
	private List<ListOfPossibleValues> listOfPossibleValues;
	private int formType;
	private String name;
	private List<Constraints> constraints;
	private String groupname;
	private String datatype;
	private String settingid;
	private String defaultvalue;
	private String datatypename;

	public int getFid() {
		return fid;
	}

	public String getSettingid() {
		return settingid;
	}

	public String getDatatypename() {
		return datatypename;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public List<ListOfPossibleValues> getListOfPossibleValues() {
		return listOfPossibleValues;
	}

	public void setListOfPossibleValues(List<ListOfPossibleValues> listOfPossibleValues) {
		this.listOfPossibleValues = listOfPossibleValues;
	}

	public int getFormType() {
		return formType;
	}

	public void setFormType(int formType) {
		this.formType = formType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Constraints> getConstraints() {
		return constraints;
	}

	public void setConstraints(List<Constraints> constraints) {
		this.constraints = constraints;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
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

	@Override
	public String toString() {
		return "ClassPojo [fid = " + fid + ", listOfPossibleValues = " + listOfPossibleValues + ", formType = " + formType + ", name = " + name + ", constraints = "
			+ constraints + ", groupname = " + groupname + ", datatype = " + datatype + ", defaultvalue = " + defaultvalue + "]";
	}
}