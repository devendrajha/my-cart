package io.smartnexus.ats.pojo;

import java.util.List;

public class AddTemplate {
	private String users;
	private List deliveryMethod;
	private int localId;
	private String sku;
	private List header;
	private int eventAction;
	private String message;
	private String cuid;
	private String templateType;
	private String mfgId;
	private String name;
	private List roles;
	private String outputType;
	private String priority;

	public String getUsers() {
		return users;
	}

	public void setUsers(String users) {
		this.users = users;
	}

	public List getDeliveryMethod() {
		return deliveryMethod;
	}

	public void setDeliveryMethod(List deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}

	public int getLocalId() {
		return localId;
	}

	public void setLocalId(int localId) {
		this.localId = localId;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public List getHeader() {
		return header;
	}

	public void setHeader(List header) {
		this.header = header;
	}

	public int getEventAction() {
		return eventAction;
	}

	public void setEventAction(int eventAction) {
		this.eventAction = eventAction;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCuid() {
		return cuid;
	}

	public void setCuid(String cuid) {
		this.cuid = cuid;
	}

	public String getTemplateType() {
		return templateType;
	}

	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}

	public String getMfgId() {
		return mfgId;
	}

	public void setMfgId(String mfgId) {
		this.mfgId = mfgId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List getRoles() {
		return roles;
	}

	public void setRoles(List roles) {
		this.roles = roles;
	}

	public String getOutputType() {
		return outputType;
	}

	public void setOutputType(String outputType) {
		this.outputType = outputType;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "AddTemplate [users = " + users + ", deliveryMethod = " + deliveryMethod + ", localId = " + localId + ", sku = " + sku + ", header = " + header
			+ ", eventAction = " + eventAction + ", message = " + message + ", cuid = " + cuid + ", templateType = " + templateType + ", mfgId = " + mfgId + ", name = "
			+ name + ", roles = " + roles + ", outputType = " + outputType + "]";
	}
}
