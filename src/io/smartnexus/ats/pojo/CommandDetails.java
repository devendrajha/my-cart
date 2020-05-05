package io.smartnexus.ats.pojo;

public class CommandDetails {
	private String id;
	private String onScreenDisplay;
	private String deviceCommand;
	private String rr;
	private String addToProductPage;
	private Parameters[] parameters;
	private String addToOTAGroupProfilePage;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getRr() {
		return rr;
	}

	public void setRr(String rr) {
		this.rr = rr;
	}

	public String getAddToProductPage() {
		return addToProductPage;
	}

	public void setAddToProductPage(String addToProductPage) {
		this.addToProductPage = addToProductPage;
	}

	public Parameters[] getParameters() {
		return parameters;
	}

	public void setParameters(Parameters[] parameters) {
		this.parameters = parameters;
	}

	public String getAddToOTAGroupProfilePage() {
		return addToOTAGroupProfilePage;
	}

	public void setAddToOTAGroupProfilePage(String addToOTAGroupProfilePage) {
		this.addToOTAGroupProfilePage = addToOTAGroupProfilePage;
	}

	@Override
	public String toString() {
		return "ClassPojo [id = " + id + ", onScreenDisplay = " + onScreenDisplay + ", deviceCommand = " + deviceCommand + ", rr = " + rr + ", addToProductPage = "
			+ addToProductPage + ", parameters = " + parameters + ", addToOTAGroupProfilePage = " + addToOTAGroupProfilePage + "]";
	}
}
