package io.smartnexus.ats.pojo;

public class ProductSettingData {
	private SettingGroups[] groups;
	public SettingGroups[] getGroups() {
		return groups;
	}

	public void setGroups(SettingGroups[] groups) {
		this.groups = groups;
	}

	@Override
	public String toString() {
		return "ClassPojo [groups = " + groups + "]";
	}
}