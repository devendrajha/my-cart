package io.smartnexus.ats.pojo;

public class NotificationResponse {
	private String message;
	private String timeStamp;
	private int priority;
	private String cuId;
	private NotificationData data;
	private int messageType;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getCuId() {
		return cuId;
	}

	public void setCuId(String cuId) {
		this.cuId = cuId;
	}

	public int getMessageType() {
		return messageType;
	}

	public void setMessageType(int messageType) {
		this.messageType = messageType;
	}

	public NotificationData getData() {
		return data;
	}

	public void setData(NotificationData data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "NotificationResponse [message = " + message + ", timeStamp = " + timeStamp + ", priority = " + priority + ", cuId = " + cuId + ", data = " + data
			+ ", messageType = " + messageType + "]";
	}
}