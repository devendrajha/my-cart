package io.smartnexus.ats.pojo;

public class Transitions {
	private To to;
	private String id;
	private String name;
	private String hasScreen;

	public To getTo() {
		return to;
	}

	public void setTo(To to) {
		this.to = to;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHasScreen() {
		return hasScreen;
	}

	public void setHasScreen(String hasScreen) {
		this.hasScreen = hasScreen;
	}

	@Override
	public String toString() {
		return "Transitions [to = " + to + ", id = " + id + ", name = " + name + ", hasScreen = " + hasScreen + "]";
	}
}
