package io.smartnexus.ats.pojo;

public class UserFieldID {
	private String Name;
	private String Value;
	private String DataType;
	private String Id;
	private String DataTypeName;

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getValue() {
		return Value;
	}

	public void setValue(String Value) {
		this.Value = Value;
	}

	public String getDataType() {
		return DataType;
	}

	public void setDataType(String DataType) {
		this.DataType = DataType;
	}

	public String getId() {
		return Id;
	}

	public void setId(String Id) {
		this.Id = Id;
	}

	public String getDataTypeName() {
		return DataTypeName;
	}

	public void setDataTypeName(String DataTypeName) {
		this.DataTypeName = DataTypeName;
	}

	@Override
	public String toString() {
		return "ClassPojo [Name = " + Name + ", Value = " + Value + ", DataType = " + DataType + ", Id = " + Id + ", DataTypeName = " + DataTypeName + "]";
	}
}
