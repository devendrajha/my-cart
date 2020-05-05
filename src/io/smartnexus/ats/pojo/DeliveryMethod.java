package io.smartnexus.ats.pojo;

public class DeliveryMethod {
	private String Name;
	private String Description;
	private String MethodId;
	private String SupportedTemplateType;
	private String Id;

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}

	public String getMethodId() {
		return MethodId;
	}

	public void setMethodId(String MethodId) {
		this.MethodId = MethodId;
	}

	public String getSupportedTemplateType() {
		return SupportedTemplateType;
	}

	public void setSupportedTemplateType(String SupportedTemplateType) {
		this.SupportedTemplateType = SupportedTemplateType;
	}

	public String getId() {
		return Id;
	}

	public void setId(String Id) {
		this.Id = Id;
	}

	@Override
	public String toString() {
		return "ClassPojo [Name = " + Name + ", Description = " + Description + ", MethodId = " + MethodId + ", SupportedTemplateType = " + SupportedTemplateType
			+ ", Id = " + Id + "]";
	}
}