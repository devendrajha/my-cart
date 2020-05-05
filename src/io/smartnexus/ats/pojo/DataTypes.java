package io.smartnexus.ats.pojo;

public class DataTypes {
	private String portalSupport;
	private String id;
	private String agentSupport;
	private String description;
	private String name;
	private String dataTypeId;
	private String isDeleted;
	private String displayName;

	public String getPortalSupport() {
		return portalSupport;
	}

	public void setPortalSupport(String portalSupport) {
		this.portalSupport = portalSupport;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAgentSupport() {
		return agentSupport;
	}

	public void setAgentSupport(String agentSupport) {
		this.agentSupport = agentSupport;
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

	public String getDataTypeId() {
		return dataTypeId;
	}

	public void setDataTypeId(String dataTypeId) {
		this.dataTypeId = dataTypeId;
	}

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@Override
	public String toString() {
		return "ClassPojo [portalSupport = " + portalSupport + ", id = " + id + ", agentSupport = " + agentSupport + ", description = " + description + ", name = "
			+ name + ", dataTypeId = " + dataTypeId + ", isDeleted = " + isDeleted + ", displayName = " + displayName + "]";
	}

}
