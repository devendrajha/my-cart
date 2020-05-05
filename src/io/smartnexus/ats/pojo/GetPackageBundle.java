package io.smartnexus.ats.pojo;

public class GetPackageBundle {
	private String count;
	private String filters;
	private PackageBundle[] data;

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getFilters() {
		return filters;
	}

	public void setFilters(String filters) {
		this.filters = filters;
	}

	public PackageBundle[] getData() {
		return data;
	}

	public void setData(PackageBundle[] data) {
		this.data = data;
	}

}