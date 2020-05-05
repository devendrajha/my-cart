package io.smartnexus.ats.pojo;

public class SettingGroups {
	private SettingsDetail[] settings;
	private String name;

	public SettingsDetail[] getSettings() {
		return settings;
	}

	public void setSettings(SettingsDetail[] settings) {
		this.settings = settings;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ClassPojo [settings = " + settings + ", name = " + name + "]";
	}
}
