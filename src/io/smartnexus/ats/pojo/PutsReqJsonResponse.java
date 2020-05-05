package io.smartnexus.ats.pojo;

public class PutsReqJsonResponse {
	private String message;
	private String priority;
	private String cuId;
	private PutsReqJsonResponseData data;
	private String messageType;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getCuId() {
		return cuId;
	}

	public void setCuId(String cuId) {
		this.cuId = cuId;
	}

	public PutsReqJsonResponseData getData() {
		return data;
	}

	public void setData(PutsReqJsonResponseData data) {
		this.data = data;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	@Override
	public String toString() {
		return "PutsReqJsonResponse [message = " + message + ", TimeStamp = " + ", priority = " + priority + ", cuId = " + cuId + ", data = " + data
			+ ", messageType = " + messageType + "]";
	}
}