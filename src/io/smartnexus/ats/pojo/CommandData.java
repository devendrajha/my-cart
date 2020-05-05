package io.smartnexus.ats.pojo;

import java.util.Arrays;

public class CommandData {
	private String createdBy;
	private String statusTime;
	private SendCommandParameter[] parameters;
	private String confirmed;
	private String deviceCommand;
	private String sendTime;
	private String status;
	public String getCreatedBy() {
		return createdBy;
	}
	public String getStatusTime() {
		return statusTime;
	}
	public SendCommandParameter[] getParameters() {
		return parameters;
	}
	public String getConfirmed() {
		return confirmed;
	}
	public String getDeviceCommand() {
		return deviceCommand;
	}
	public String getSendTime() {
		return sendTime;
	}
	public String getStatus() {
		return status;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CommandData [createdBy=").append(createdBy).append(", statusTime=").append(statusTime).append(", parameters=")
			.append(Arrays.toString(parameters)).append(", confirmed=").append(confirmed).append(", deviceCommand=").append(deviceCommand).append(", sendTime=")
			.append(sendTime).append(", status=").append(status).append("]");
		return builder.toString();
	}
	
	

}
