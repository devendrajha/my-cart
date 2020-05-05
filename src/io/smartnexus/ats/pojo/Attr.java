package io.smartnexus.ats.pojo;

public class Attr {
	private String pri;
	private String gId;
	private String name;
	private String dtype;
	private String en;
	private String localId;

	public String getPri() {
		return pri;
	}

	public void setPri(String pri) {
		this.pri = pri;
	}

	public String getGId() {
		return gId;
	}

	public void setGId(String gId) {
		this.gId = gId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDtype() {
		return dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	public String getEn() {
		return en;
	}

	public void setEn(String en) {
		this.en = en;
	}

	public String getLocalId() {
		return localId;
	}

	public void setLocalId(String localId) {
		this.localId = localId;
	}

	@Override
	public String toString() {
		return "ClassPojo [pri = " + pri + ", gId = " + gId + ", name = " + name + ", dtype = " + dtype + ", en = " + en + ", localId = " + localId + "]";
	}
}