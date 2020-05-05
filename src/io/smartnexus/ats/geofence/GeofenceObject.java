package io.smartnexus.ats.geofence;

import java.util.List;

public class GeofenceObject {
	private String id;
	private String cuid;
	private String name;
	private String alertType;
	private String radius;
	private String type;

	private List<Coordinates> coordinates;

	public String getCuid() {
		return cuid;
	}

	public void setCuid(String cuid) {
		this.cuid = cuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlertType() {
		return alertType;
	}

	public void setAlertType(String alertType) {
		this.alertType = alertType;
	}

	public String getRadius() {
		return radius;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setRadius(String radius) {
		this.radius = radius;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Coordinates> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(List<Coordinates> coordinates) {
		this.coordinates = coordinates;
	}

	@Override
	public String toString() {
		return "GeofenceObject [cuid = " + cuid + ", name = " + name + ", alertType = " + alertType + ", radius = "
				+ radius + ", type = " + type + ", coordinates = " + coordinates + "]";
	}
}
