package io.smartnexus.ats.pojo;

public class ChannelQueue {
	private String port;
	private String sasToken;
	private String connectionURI;

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getSasToken() {
		return sasToken;
	}

	public void setSasToken(String sasToken) {
		this.sasToken = sasToken;
	}

	public String getConnectionURI() {
		return connectionURI;
	}

	public void setConnectionURI(String connectionURI) {
		this.connectionURI = connectionURI;
	}

	@Override
	public String toString() {
		return "ChannelQueue [port = " + port + ", sasToken = " + sasToken + ", connectionURI = " + connectionURI + "]";
	}
}