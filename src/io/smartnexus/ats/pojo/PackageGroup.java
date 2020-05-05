package io.smartnexus.ats.pojo;

public class PackageGroup {
	private String description;
	private String name;
	private String version;
	private String hardwareVersion;

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

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getHardwareVersion() {
		return hardwareVersion;
	}

	public void setHardwareVersion(String hardwareVersion) {
		this.hardwareVersion = hardwareVersion;
	}

	@Override
	public String toString() {
		return "ClassPojo [description = " + description + ", name = " + name + ", version = " + version + ", hardwareVersion = " + hardwareVersion + "]";
	}
}
