package io.smartnexus.ats.pojo;

import java.util.Arrays;

public class SyncResponse {
	private Eps[] eps;
	private String pId;
	private String cpId;
	private Transport transport;
	private String cfgTmplId;
	private String vpId;
	private String prodTmplId;
	private String plId;
	private String apiKey;
	private String manifestUrl;
	private String epstotal;
	private String lastSyncDate;

	public Eps[] getEps() {
		return eps;
	}

	public void setEps(Eps[] eps) {
		this.eps = eps;
	}

	public String getPId() {
		return pId;
	}

	public void setPId(String pId) {
		this.pId = pId;
	}

	public String getCpId() {
		return cpId;
	}

	public void setCpId(String cpId) {
		this.cpId = cpId;
	}

	public Transport getTransport() {
		return transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	public String getCfgTmplId() {
		return cfgTmplId;
	}

	public void setCfgTmplId(String cfgTmplId) {
		this.cfgTmplId = cfgTmplId;
	}

	public String getVpId() {
		return vpId;
	}

	public void setVpId(String vpId) {
		this.vpId = vpId;
	}

	public String getProdTmplId() {
		return prodTmplId;
	}

	public void setProdTmplId(String prodTmplId) {
		this.prodTmplId = prodTmplId;
	}

	public String getPlId() {
		return plId;
	}

	public void setPlId(String plId) {
		this.plId = plId;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getpId() {
		return pId;
	}

	public String getManifestUrl() {
		return manifestUrl;
	}

	public String getEpstotal() {
		return epstotal;
	}

	public String getLastSyncDate() {
		return lastSyncDate;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public void setManifestUrl(String manifestUrl) {
		this.manifestUrl = manifestUrl;
	}

	public void setEpstotal(String epstotal) {
		this.epstotal = epstotal;
	}

	public void setLastSyncDate(String lastSyncDate) {
		this.lastSyncDate = lastSyncDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SyncResponse [eps=").append(Arrays.toString(eps)).append(", pId=").append(pId).append(", cpId=").append(cpId).append(", transport=")
			.append(transport).append(", cfgTmplId=").append(cfgTmplId).append(", vpId=").append(vpId).append(", prodTmplId=").append(prodTmplId).append(", plId=")
			.append(plId).append(", apiKey=").append(apiKey).append(", manifestUrl=").append(manifestUrl).append(", epstotal=").append(epstotal)
			.append(", lastSyncDate=").append(lastSyncDate).append("]");
		return builder.toString();
	}

}
