package io.smartnexus.ats.thrift;

/**
 * Agent provides notification of these events to eApp
 */
public enum EventType implements org.apache.thrift.TEnum {
	/**
	 * New OTA image is available
	 */
	EVENT_NEW_OTA_IMAGE_AVAIL(0),
	/**
	 * MQTT connection to IOTHUB is down
	 */
	EVENT_IOTHUB_CONNECTION_DOWN(1),
	/**
	 * Timestamp from server
	 */
	EVENT_TIMESTAMP_AVAIL(2),
	/**
	 * MQTT message send was successful
	 */
	EVENT_MQTT_SEND_SUCCESS(3),
	/**
	 * Invalid OTA image
	 */
	EVENT_INVALID_OTA_IMAGE(4),
	/**
	 * The number of events
	 */
	NUM_EVENTS(5);

	private final int value;

	private EventType(int value) {
		this.value = value;
	}

	/**
	 * Get the integer value of this enum value, as defined in the Thrift IDL.
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Find a the enum type by its integer value, as defined in the Thrift IDL.
	 * 
	 * @return null if the value is not found.
	 */
	public static EventType findByValue(int value) {
		switch (value) {
		case 0:
			return EVENT_NEW_OTA_IMAGE_AVAIL;
		case 1:
			return EVENT_IOTHUB_CONNECTION_DOWN;
		case 2:
			return EVENT_TIMESTAMP_AVAIL;
		case 3:
			return EVENT_MQTT_SEND_SUCCESS;
		case 4:
			return EVENT_INVALID_OTA_IMAGE;
		case 5:
			return NUM_EVENTS;
		default:
			return null;
		}
	}
}
