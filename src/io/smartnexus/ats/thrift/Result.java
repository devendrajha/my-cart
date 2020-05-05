package io.smartnexus.ats.thrift;

/**
 * Return codes for Agent Service functions
 */
public enum Result implements org.apache.thrift.TEnum {
	/**
	 * Success
	 */
	OK(0),
	/**
	 * Generic error
	 */
	ERROR(1),
	/**
	 * Operation timed out
	 */
	TIMEOUT(2),
	/**
	 * Device needs to be activated
	 */
	NOT_ACTIVATED(3),
	/**
	 * An invalid parameter value was provided
	 */
	INVALID_PARAM(4),
	/**
	 * Device is already activated
	 */
	ALREADY_ACTIVATED(5),
	/**
	 * Out of memory
	 */
	OUT_OF_MEMORY(6),
	/**
	 * Generic parse error
	 */
	PARSE_ERROR(7),
	/**
	 * MQTT already connected
	 */
	ALREADY_CONNECTED(8),
	/**
	 * Error parsing URI
	 */
	PARSE_ERROR_URI(9),
	/**
	 * Error in the platform abstraction layer
	 */
	PAL_ERROR(10),
	/**
	 * Error establishing MQTT connection
	 */
	MQTT_CONNECT_ERROR(11),
	/**
	 * MQTT subscribe error
	 */
	MQTT_SUBSCRIBE_ERROR(12),
	/**
	 * String too long
	 */
	STRING_TOO_LONG(13),
	/**
	 * MQTT publish error
	 */
	MQTT_PUBLISH_ERROR(14),
	/**
	 * Invalid request
	 */
	INVALID_REQUEST(15),
	/**
	 * Error reading or writing NVM (non-volatile memory)
	 */
	NVM_FAIL(16),
	/**
	 * Attribute not found
	 */
	ATTRIBUTE_NOT_FOUND(17),
	/**
	 * Buffer too small
	 */
	STATIC_TOO_SMALL(18),
	/**
	 * Data type mismatch
	 */
	TYPE_MISMATCH(19),
	/**
	 * Network error
	 */
	NETWORK_ERROR(20),
	/**
	 * Missing activation data (NVM file could be missing)
	 */
	ACTIVATION_DATA_MISSING(21),
	/**
	 * OTA check failed
	 */
	OTA_FAILED(22),
	/**
	 * Out of memory for parsing JSON
	 */
	JSON_OUT_OF_TOKENS(23),
	/**
	 * Error parsing JSON
	 */
	JSON_PARSE_ERROR(24),
	/**
	 * No attributes available
	 */
	NO_ATTRIBUTES(25),
	/**
	 * Agent busy, try again
	 */
	BUSY(26),
	/**
	 * MQTT already disconnected
	 */
	ALREADY_DISCONNECTED(27),
	/**
	 * Endpoint local Id not found
	 */
	ENDPOINT_NOT_FOUND(28),
	/**
	 * Agent not initialized. Call init.
	 */
	NOT_INIT(29),
	/**
	 * Failed to call callback
	 */
	CB_FAIL(30),
	/**
	 * Error access database file.
	 */
	DATABASE_ERROR(31),
	/**
	 * Setting not found. (Invalid setting ID)
	 */
	SETTING_NOT_FOUND(32),
	/**
	 * Endpoint local Id already exist.
	 */
	ENDPOINT_ALREADY_EXISTS(33),
	/**
	 * OTA required. The device must update before it can activate or sync.
	 */
	OTA_REQUIRED(34),
	/**
	 * Failed to generate new endpoint Id entry
	 */
	NEW_EP_ID_ERROR(35),
	/**
	 * Failed to Invalid Data Type
	 */
	DATA_TYPE_NOT_FOUND(36),
	/**
	 * Error access certificate file.
	 */
	CERTIFICATE_ERROR(37),
	/**
	 * Device not provisioned
	 */
	NOT_PROVISIONED(38),
	/**
	 * Missing provisioned data. (NVM could be missing)
	 */
	PROVISION_DATA_MISSING(39),
	/**
	 * The number of error codes
	 */
	NUM_RESULTS(40);

	private final int value;

	private Result(int value) {
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
	public static Result findByValue(int value) {
		switch (value) {
		case 0:
			return OK;
		case 1:
			return ERROR;
		case 2:
			return TIMEOUT;
		case 3:
			return NOT_ACTIVATED;
		case 4:
			return INVALID_PARAM;
		case 5:
			return ALREADY_ACTIVATED;
		case 6:
			return OUT_OF_MEMORY;
		case 7:
			return PARSE_ERROR;
		case 8:
			return ALREADY_CONNECTED;
		case 9:
			return PARSE_ERROR_URI;
		case 10:
			return PAL_ERROR;
		case 11:
			return MQTT_CONNECT_ERROR;
		case 12:
			return MQTT_SUBSCRIBE_ERROR;
		case 13:
			return STRING_TOO_LONG;
		case 14:
			return MQTT_PUBLISH_ERROR;
		case 15:
			return INVALID_REQUEST;
		case 16:
			return NVM_FAIL;
		case 17:
			return ATTRIBUTE_NOT_FOUND;
		case 18:
			return STATIC_TOO_SMALL;
		case 19:
			return TYPE_MISMATCH;
		case 20:
			return NETWORK_ERROR;
		case 21:
			return ACTIVATION_DATA_MISSING;
		case 22:
			return OTA_FAILED;
		case 23:
			return JSON_OUT_OF_TOKENS;
		case 24:
			return JSON_PARSE_ERROR;
		case 25:
			return NO_ATTRIBUTES;
		case 26:
			return BUSY;
		case 27:
			return ALREADY_DISCONNECTED;
		case 28:
			return ENDPOINT_NOT_FOUND;
		case 29:
			return NOT_INIT;
		case 30:
			return CB_FAIL;
		case 31:
			return DATABASE_ERROR;
		case 32:
			return SETTING_NOT_FOUND;
		case 33:
			return ENDPOINT_ALREADY_EXISTS;
		case 34:
			return OTA_REQUIRED;
		case 35:
			return NEW_EP_ID_ERROR;
		case 36:
			return DATA_TYPE_NOT_FOUND;
		case 37:
			return CERTIFICATE_ERROR;
		case 38:
			return NOT_PROVISIONED;
		case 39:
			return PROVISION_DATA_MISSING;
		case 40:
			return NUM_RESULTS;
		default:
			return null;
		}
	}
}
