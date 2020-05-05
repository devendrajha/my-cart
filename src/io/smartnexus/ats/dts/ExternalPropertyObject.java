package io.smartnexus.ats.dts;

public class ExternalPropertyObject {
	private String propertyName;
	private String mfgId;
	private String sku;
	private String headers;
	private String cuid;
	private String methodType;
	private String url;
	private String[] customProperty;
	private String conversionId;
	private int conversionTypeId;

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getMfgId() {
		return mfgId;
	}

	public void setMfgId(String mfgId) {
		this.mfgId = mfgId;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getHeaders() {
		return headers;
	}

	public void setHeaders(String headers) {
		this.headers = headers;
	}

	public String getCuid() {
		return cuid;
	}

	public void setCuid(String cuid) {
		this.cuid = cuid;
	}

	public String getMethodType() {
		return methodType;
	}

	public void setMethodType(String methodType) {
		this.methodType = methodType;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String[] getCustomProperty() {
		return customProperty;
	}

	public void setCustomProperty(String[] customProperty) {
		this.customProperty = customProperty;
	}

	public String getConversionId() {
		return conversionId;
	}

	public void setConversionId(String conversionId) {
		this.conversionId = conversionId;
	}

	public int getConversionTypeId() {
		return conversionTypeId;
	}

	public void setConversionTypeId(int conversionTypeId) {
		this.conversionTypeId = conversionTypeId;
	}

}