package io.smartnexus.ats.pojo;

public class GelAllCommands {
	private String Key;
	private String count;
	private CommandGroups[] groups;

	public String getKey() {
		return Key;
	}

	public void setKey(String Key) {
		this.Key = Key;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public CommandGroups[] getGroups() {
		return groups;
	}

	public void setGroups(CommandGroups[] groups) {
		this.groups = groups;
	}

}
