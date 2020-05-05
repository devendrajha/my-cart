package io.smartnexus.ats.pojo;

import java.util.List;

public class Commands {
	private String displayGroupName;

	private String onScreenDisplay;

	private String deviceCommand;

	private boolean rr;

	private List<Parameters> parameters;

	public String getDisplayGroupName() {
		return displayGroupName;
	}

	public void setDisplayGroupName(String displayGroupName) {
		this.displayGroupName = displayGroupName;
	}

	public String getOnScreenDisplay() {
		return onScreenDisplay;
	}

	public void setOnScreenDisplay(String onScreenDisplay) {
		this.onScreenDisplay = onScreenDisplay;
	}

	public String getDeviceCommand() {
		return deviceCommand;
	}

	public void setDeviceCommand(String deviceCommand) {
		this.deviceCommand = deviceCommand;
	}

	public boolean getRr() {
		return rr;
	}

	public void setRr(boolean b) {
		this.rr = b;
	}

	public List<Parameters> getParameters() {
		return parameters;
	}

	public void setParameters(List<Parameters> parameters) {
		this.parameters = parameters;
	}

	@Override
	public String toString() {
		return "[displayGroupName = " + displayGroupName + ", onScreenDisplay = " + onScreenDisplay
				+ ", deviceCommand = " + deviceCommand + ", rr = " + rr + ", parameters = " + parameters + "]";
	}
}