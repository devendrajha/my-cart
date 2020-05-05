package io.smartnexus.ats.pojo;

public class GroupDetails {
	private String Name;
	private String GroupId;
	private String OwnerName;

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getGroupId() {
		return GroupId;
	}

	public void setGroupId(String groupId) {
		GroupId = groupId;
	}

	public String getOwnerName() {
		return OwnerName;
	}

	public void setOwnerName(String ownerName) {
		OwnerName = ownerName;
	}

	@Override
	public String toString() {
		return "Groups [Name=" + Name + ", GroupId=" + GroupId + ", OwnerName=" + OwnerName + "]";
	}

}
