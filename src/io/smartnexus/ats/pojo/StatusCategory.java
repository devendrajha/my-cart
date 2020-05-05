package io.smartnexus.ats.pojo;

public class StatusCategory {
	private String id;
	private String colorName;
	private String name;
	private String self;
	private String key;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSelf() {
		return self;
	}

	public void setSelf(String self) {
		this.self = self;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "StatusCategory [id = " + id + ", colorName = " + colorName + ", name = " + name + ", self = " + self + ", key = " + key + "]";
	}
}
