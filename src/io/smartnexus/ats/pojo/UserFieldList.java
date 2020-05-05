package io.smartnexus.ats.pojo;

public class UserFieldList {
	private UserFields[] userFields;

	public UserFields[] getUserFields() {
		return userFields;
	}

	public void setUserFields(UserFields[] userFields) {
		this.userFields = userFields;
	}

	@Override
	public String toString() {
		return "UserFieldList [userFields = " + userFields + "]";
	}
}
