package io.smartnexus.ats.thrift;

/**
 * Enumeration of types of asynchronous events from Agent
 */
public enum ReturnType implements org.apache.thrift.TEnum {
	/**
	 * An event
	 */
	RETURN_EVENT(0),
	/**
	 * A received message
	 */
	RETURN_MSG(1),
	/**
	 * Error on
	 */
	RETURN_ERROR(2);

	private final int value;

	private ReturnType(int value) {
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
	public static ReturnType findByValue(int value) {
		switch (value) {
		case 0:
			return RETURN_EVENT;
		case 1:
			return RETURN_MSG;
		case 2:
			return RETURN_ERROR;
		default:
			return null;
		}
	}
}
