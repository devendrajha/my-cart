package io.smartnexus.ats.thrift;

/**
 * Data types supported by Agent Service
 */
public enum DataElementType implements org.apache.thrift.TEnum {
	/**
	 * Boolean
	 */
	DATA_TYPE_BOOL(1),
	/**
	 * Integer
	 */
	DATA_TYPE_INTEGER(2),
	/**
	 * Byte
	 */
	DATA_TYPE_BYTE(3),
	/**
	 * Decimal
	 */
	DATA_TYPE_DECIMAL(4),
	/**
	 * BigInteger
	 */
	DATA_TYPE_BIGINT(5),
	/**
	 * String
	 */
	DATA_TYPE_STRING(6),
	/**
	 * Floating-point number
	 */
	DATA_TYPE_FLOAT(7),
	/**
	 * Double number
	 */
	DATA_TYPE_DOUBLE(8),
	/**
	 * Long Double number
	 */
	DATA_TYPE_LDOUBLE(9),
	/**
	 * JSON
	 */
	DATA_TYPE_JSON(10);

	private final int value;

	private DataElementType(int value) {
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
	public static DataElementType findByValue(int value) {
		switch (value) {
		case 1:
			return DATA_TYPE_BOOL;
		case 2:
			return DATA_TYPE_INTEGER;
		case 3:
			return DATA_TYPE_BYTE;
		case 4:
			return DATA_TYPE_DECIMAL;
		case 5:
			return DATA_TYPE_BIGINT;
		case 6:
			return DATA_TYPE_STRING;
		case 7:
			return DATA_TYPE_FLOAT;
		case 8:
			return DATA_TYPE_DOUBLE;
		case 9:
			return DATA_TYPE_LDOUBLE;
		case 10:
			return DATA_TYPE_JSON;
		default:
			return null;
		}
	}
}
