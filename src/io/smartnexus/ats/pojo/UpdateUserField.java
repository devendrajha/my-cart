package io.smartnexus.ats.pojo;

public class UpdateUserField {
	private String description;
	private String name;
	private String apiKey;

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

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	@Override
	public String toString() {
		return "ClassPojo [description = " + description + ", name = " + name + ", apiKey = " + apiKey + "]";
	}
}