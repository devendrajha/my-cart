package io.smartnexus.ats.pojo;

public class CreateSettingProfile {
	private String CompanyId;
	private SettingProfileNames SettingProfileNames;
	private String ProfileName;
	private String[] SettingsProfileArray;
	private SettingProfileValues[] SettingProfileValues;
	private String ProductLineId;

	public String getCompanyId() {
		return CompanyId;
	}

	public void setCompanyId(String companyId) {
		CompanyId = companyId;
	}

	public SettingProfileNames getSettingProfileNames() {
		return SettingProfileNames;
	}

	public void setSettingProfileNames(SettingProfileNames settingProfileNames) {
		SettingProfileNames = settingProfileNames;
	}

	public String getProfileName() {
		return ProfileName;
	}

	public void setProfileName(String profileName) {
		ProfileName = profileName;
	}

	public String[] getSettingsProfileArray() {
		return SettingsProfileArray;
	}

	public void setSettingsProfileArray(String[] settingsProfileArray) {
		SettingsProfileArray = settingsProfileArray;
	}

	public SettingProfileValues[] getSettingProfileValues() {
		return SettingProfileValues;
	}

	public void setSettingProfileValues(SettingProfileValues[] settingProfileValues) {
		SettingProfileValues = settingProfileValues;
	}

	public String getProductLineId() {
		return ProductLineId;
	}

	public void setProductLineId(String productLineId) {
		ProductLineId = productLineId;
	}

}
