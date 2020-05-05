package io.smartnexus.ats.thrift;

/**
 * Receipt type associated with message type
 */
public enum ReceiptType implements org.apache.thrift.TEnum {
	/**
	 * Receipt is associated with a command
	 */
	RECEIPT_TYPE_COMMAND(0),
	/**
	 * Receipt is associated with a setting
	 */
	RECEIPT_TYPE_SETTING(1),
	/**
	 * Receipt is associated with a custom message
	 */
	RECEIPT_TYPE_CUSTOM(2);

	private final int value;

	private ReceiptType(int value) {
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
	public static ReceiptType findByValue(int value) {
		switch (value) {
		case 0:
			return RECEIPT_TYPE_COMMAND;
		case 1:
			return RECEIPT_TYPE_SETTING;
		case 2:
			return RECEIPT_TYPE_CUSTOM;
		default:
			return null;
		}
	}
}
