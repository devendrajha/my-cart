package io.smartnexus.ats.pojo;

public class MqttUserPreferenceModel {
	private String port;
	private String username;
	private String topicname;
	private String certificatepassword;
	private String server;
	private String certificatename;
	private String password;
	private String issecure;

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTopicname() {
		return topicname;
	}

	public void setTopicname(String topicname) {
		this.topicname = topicname;
	}

	public String getCertificatepassword() {
		return certificatepassword;
	}

	public void setCertificatepassword(String certificatepassword) {
		this.certificatepassword = certificatepassword;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getCertificatename() {
		return certificatename;
	}

	public void setCertificatename(String certificatename) {
		this.certificatename = certificatename;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIssecure() {
		return issecure;
	}

	public void setIssecure(String issecure) {
		this.issecure = issecure;
	}

	@Override
	public String toString() {
		return "MqttUserPreferenceModel [port = " + port + ", username = " + username + ", topicname = " + topicname + ", certificatepassword = " + certificatepassword
			+ ", server = " + server + ", certificatename = " + certificatename + ", password = " + password + ", issecure = " + issecure + "]";
	}
}
