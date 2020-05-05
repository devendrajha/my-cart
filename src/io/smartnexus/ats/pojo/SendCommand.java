package io.smartnexus.ats.pojo;

import java.util.List;

public class SendCommand {
	private boolean rr;
	private String ver;
	private String plId;
	private String cmtId;
	private String cnsr;
	private List<SendCommandParameter> param;
	private String cmdname;
	private String epId;
	private boolean fce;

	public boolean getRr() {
		return rr;
	}

	public void setRr(boolean rr) {
		this.rr = rr;
	}

	public String getVer() {
		return ver;
	}

	public void setVer(String ver) {
		this.ver = ver;
	}

	public String getPlId() {
		return plId;
	}

	public void setPlId(String plId) {
		this.plId = plId;
	}

	public String getCmtId() {
		return cmtId;
	}

	public void setCmtId(String cmtId) {
		this.cmtId = cmtId;
	}

	public String getCnsr() {
		return cnsr;
	}

	public void setCnsr(String cnsr) {
		this.cnsr = cnsr;
	}

	public List<SendCommandParameter> getParam() {
		return param;
	}

	public void setParam(List<SendCommandParameter> param) {
		this.param = param;
	}

	public String getCmdname() {
		return cmdname;
	}

	public void setCmdname(String cmdname) {
		this.cmdname = cmdname;
	}

	public String getEpId() {
		return epId;
	}

	public void setEpId(String epId) {
		this.epId = epId;
	}

	public boolean getFce() {
		return fce;
	}

	public void setFce(boolean fce) {
		this.fce = fce;
	}

	@Override
	public String toString() {
		return "SendCommand [rr = " + rr + ", ver = " + ver + ", plId = " + plId + ", cmtId = " + cmtId + ", cnsr = " + cnsr + ", param = " + param + ", cmdname = "
			+ cmdname + ", epId = " + epId + ", fce = " + fce + "]";
	}
}
