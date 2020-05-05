package io.smartnexus.ats.pojo;

import java.util.List;

public class Setting {
	private List<Settings> settings;

	public List<Settings> getSettings() {
		return settings;
	}

	public void setSettings(List<Settings> settings) {
		this.settings = settings;
	}

	@Override
	public String toString() {
		return "Setting [settings = " + settings + "]";
	}
}
