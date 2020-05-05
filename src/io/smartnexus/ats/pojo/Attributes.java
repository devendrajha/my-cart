package io.smartnexus.ats.pojo;

import java.util.List;

public class Attributes {
	private String dataType;
	private String groupName;
	private String attibId;
	private String description;
	private String name;
	private List<Constraints> constraints;
	private int localId;

	private String dataTypeName;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Constraints> getConstraints() {
		return constraints;
	}

	public void setConstraints(List<Constraints> list) {
		this.constraints = list;
	}

	public int getLocalId() {
		return localId;
	}

	public void setLocalId(int localId) {
		this.localId = localId;
	}

	public String getDataTypeName() {
		return dataTypeName;
	}

	public void setDataTypeName(String dataTypeName) {
		this.dataTypeName = dataTypeName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getAttibId() {
		return attibId;
	}

	public void setAttibId(String attibId) {
		this.attibId = attibId;
	}

}
