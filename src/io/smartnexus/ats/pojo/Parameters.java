package io.smartnexus.ats.pojo;

import java.util.List;

public class Parameters {
	private String dataType;
	private List<ListOfPossibleValues> listOfPossibleValues;

	private int formType;

	private String name;

	private List<Constraints> constraints;

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public List<ListOfPossibleValues> getListOfPossibleValues() {
		return listOfPossibleValues;
	}

	public void setListOfPossibleValues(List<ListOfPossibleValues> listOfPossibleValues) {
		this.listOfPossibleValues = listOfPossibleValues;
	}

	public int getFormType() {
		return formType;
	}

	public void setFormType(int formType) {
		this.formType = formType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Constraints> getConstraint() {
		return constraints;
	}

	public void setConstraint(List<Constraints> Constraint) {
		this.constraints = Constraint;
	}

	@Override
	public String toString() {
		return "[dataType = " + dataType + ", listOfPossibleValues = " + listOfPossibleValues + ", formType = " + formType + ", name = " + name + ", Constraint = "
			+ constraints + "]";
	}
}