package io.smartnexus.ats.pojo;

public class Eps {
	private String epTmplId;
	private String serialNo;
	private String cmdTmplId;
	private String mfgId;
	private String hash;
	private String status;
	private String epLocalId;
	private String name;
	private Attr[] attr;
	private String en;
	private String ver;
	private String epId;

	public String getEpTmplId() {
		return epTmplId;
	}

	public void setEpTmplId(String epTmplId) {
		this.epTmplId = epTmplId;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getCmdTmplId() {
		return cmdTmplId;
	}

	public void setCmdTmplId(String cmdTmplId) {
		this.cmdTmplId = cmdTmplId;
	}

	public String getMfgId() {
		return mfgId;
	}

	public void setMfgId(String mfgId) {
		this.mfgId = mfgId;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEpLocalId() {
		return epLocalId;
	}

	public void setEpLocalId(String epLocalId) {
		this.epLocalId = epLocalId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Attr[] getAttr() {
		return attr;
	}

	public void setAttr(Attr[] attr) {
		this.attr = attr;
	}

	public String getEn() {
		return en;
	}

	public void setEn(String en) {
		this.en = en;
	}

	public String getVer() {
		return ver;
	}

	public void setVer(String ver) {
		this.ver = ver;
	}

	public String getEpId() {
		return epId;
	}

	public void setEpId(String epId) {
		this.epId = epId;
	}

	@Override
	public String toString() {
		return "ClassPojo [epTmplId = " + epTmplId + ", serialNo = " + serialNo + ", cmdTmplId = " + cmdTmplId + ", mfgId = " + mfgId + ", hash = " + hash
			+ ", status = " + status + ", epLocalId = " + epLocalId + ", name = " + name + ", attr = " + attr + ", en = " + en + ", ver = " + ver + ", epId = " + epId
			+ "]";
	}
}