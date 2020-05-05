package io.smartnexus.ats.pojo;

public class SetUserPreference {
	private String phoneNo;
	private String webhookAuthencationTypeId;
	private String certificatePassword;
	private String authUri;
	private String webhookHeader;
	private String certificateName;
	private String webhookUri;
	private MqttUserPreferenceModel mqttUserPreferenceModel;
	private String authRequestHeaders;
	private String authRequestBody;

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getWebhookAuthencationTypeId() {
		return webhookAuthencationTypeId;
	}

	public void setWebhookAuthencationTypeId(String webhookAuthencationTypeId) {
		this.webhookAuthencationTypeId = webhookAuthencationTypeId;
	}

	public String getCertificatePassword() {
		return certificatePassword;
	}

	public void setCertificatePassword(String certificatePassword) {
		this.certificatePassword = certificatePassword;
	}

	public String getAuthUri() {
		return authUri;
	}

	public void setAuthUri(String authUri) {
		this.authUri = authUri;
	}

	public String getWebhookHeader() {
		return webhookHeader;
	}

	public void setWebhookHeader(String webhookHeader) {
		this.webhookHeader = webhookHeader;
	}

	public String getCertificateName() {
		return certificateName;
	}

	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}

	public String getWebhookUri() {
		return webhookUri;
	}

	public void setWebhookUri(String webhookUri) {
		this.webhookUri = webhookUri;
	}

	public MqttUserPreferenceModel getMqttUserPreferenceModel() {
		return mqttUserPreferenceModel;
	}

	public void setMqttUserPreferenceModel(MqttUserPreferenceModel mqttUserPreferenceModel) {
		this.mqttUserPreferenceModel = mqttUserPreferenceModel;
	}

	public String getAuthRequestHeaders() {
		return authRequestHeaders;
	}

	public void setAuthRequestHeaders(String authRequestHeaders) {
		this.authRequestHeaders = authRequestHeaders;
	}

	public String getAuthRequestBody() {
		return authRequestBody;
	}

	public void setAuthRequestBody(String authRequestBody) {
		this.authRequestBody = authRequestBody;
	}

	@Override
	public String toString() {
		return "ClassPojo [phoneNo = " + phoneNo + ", webhookAuthencationTypeId = " + webhookAuthencationTypeId + ", certificatePassword = " + certificatePassword
			+ ", authUri = " + authUri + ", webhookHeader = " + webhookHeader + ", certificateName = " + certificateName + ", webhookUri = " + webhookUri
			+ ", mqttUserPreferenceModel = " + mqttUserPreferenceModel + ", authRequestHeaders = " + authRequestHeaders + ", authRequestBody = " + authRequestBody + "]";
	}
}