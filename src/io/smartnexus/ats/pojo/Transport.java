package io.smartnexus.ats.pojo;

public class Transport {
	private String protocol;
	private String cttl;
	private ChannelQueue channelQueue;
	private String channelHttp;

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getCttl() {
		return cttl;
	}

	public void setCttl(String cttl) {
		this.cttl = cttl;
	}

	public ChannelQueue getChannelQueue() {
		return channelQueue;
	}

	public void setChannelQueue(ChannelQueue channelQueue) {
		this.channelQueue = channelQueue;
	}

	public String getChannelHttp() {
		return channelHttp;
	}

	public void setChannelHttp(String channelHttp) {
		this.channelHttp = channelHttp;
	}

	@Override
	public String toString() {
		return "ClassPojo [protocol = " + protocol + ", cttl = " + cttl + ", channelQueue = " + channelQueue + ", channelHttp = " + channelHttp + "]";
	}
}
