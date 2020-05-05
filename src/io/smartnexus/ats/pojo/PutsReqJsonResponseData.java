package io.smartnexus.ats.pojo;

public class PutsReqJsonResponseData {
	private String mfgId;
	private String status;
	private String name;
	private String localId;
	private String sku;

	public String getMfgId() {
		return mfgId;
	}

	public void setMfgId(String mfgId) {
		this.mfgId = mfgId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocalId() {
		return localId;
	}

	public void setLocalId(String localId) {
		this.localId = localId;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	@Override
	public String toString() {
		return "PutsReqJsonResponseData [mfgId = " + mfgId + ", status = " + status + ", name = " + name + ", localId = " + localId + ", sku = " + sku + "]";
	}
}
