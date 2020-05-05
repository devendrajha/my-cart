package io.smartnexus.ats.thrift;

/**
 * Receipt Status
 */
public enum ReceiptStatus implements org.apache.thrift.TEnum {
	/**
	 * Cloud request was processed successfully
	 */
	RECEIPT_STATUS_OK(1),
	/**
	 * Cloud request is processing but not completed
	 */
	RECEIPT_STATUS_DELAY_EXEC(2),
	/**
	 * Cloud request failed
	 */
	RECEIPT_STATUS_FAIL(4);

	private final int value;

	private ReceiptStatus(int value) {
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
	public static ReceiptStatus findByValue(int value) {
		switch (value) {
		case 1:
			return RECEIPT_STATUS_OK;
		case 2:
			return RECEIPT_STATUS_DELAY_EXEC;
		case 4:
			return RECEIPT_STATUS_FAIL;
		default:
			return null;
		}
	}
}
