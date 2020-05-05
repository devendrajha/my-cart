package io.smartnexus.ats.pojo;

public class ProductMasterVirtualProducts {
	private String count;
	private VirtualProductDetails[] data;

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public VirtualProductDetails[] getData() {
		return data;
	}

	public void setData(VirtualProductDetails[] data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ProductMasterVirtualProducts [count = " + count + ", data = " + data + "]";
	}
}