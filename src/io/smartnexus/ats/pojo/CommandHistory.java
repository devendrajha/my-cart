package io.smartnexus.ats.pojo;

import java.util.Arrays;

public class CommandHistory {
	private CommandData[] data;
	private String count;
	private String filters;
	public CommandData[] getData() {
		return data;
	}
	public String getCount() {
		return count;
	}
	public String getFilters() {
		return filters;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CommandHistory [data=").append(Arrays.toString(data)).append(", count=").append(count).append(", filters=").append(filters).append("]");
		return builder.toString();
	}
	
	

}
