package io.smartnexus.ats.pojo;

public class WebhookResponse {
	private int count;
	private int http_status;
	private NotificationResponse[] documents;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getHttp_status() {
		return http_status;
	}

	public void setHttp_status(int http_status) {
		this.http_status = http_status;
	}

	public NotificationResponse[] getDocuments() {
		return documents;
	}

	public void setDocuments(NotificationResponse[] documents) {
		this.documents = documents;
	}

	

}
