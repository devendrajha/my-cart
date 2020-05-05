package io.smartnexus.ats.thrift;

/**
 * Data types supported by Agent Service
 */
public enum LogClassType implements org.apache.thrift.TEnum {
	LOG_TYPE_ALL(255), LOG_TYPE_NOISE(1), LOG_TYPE_DEBUG(2), LOG_TYPE_WARN(4), LOG_TYPE_CRIT(8), LOG_TYPE_NET(
			16), LOG_TYPE_PAL(32), LOG_TYPE_CUST1(64), LOG_TYPE_CUST2(128);

	private final int value;

	private LogClassType(int value) {
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
	public static LogClassType findByValue(int value) {
		switch (value) {
		case 255:
			return LOG_TYPE_ALL;
		case 1:
			return LOG_TYPE_NOISE;
		case 2:
			return LOG_TYPE_DEBUG;
		case 4:
			return LOG_TYPE_WARN;
		case 8:
			return LOG_TYPE_CRIT;
		case 16:
			return LOG_TYPE_NET;
		case 32:
			return LOG_TYPE_PAL;
		case 64:
			return LOG_TYPE_CUST1;
		case 128:
			return LOG_TYPE_CUST2;
		default:
			return null;
		}
	}
}
