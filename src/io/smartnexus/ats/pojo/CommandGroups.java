package io.smartnexus.ats.pojo;

public class CommandGroups {
	private String displayGroupName;
	private CommandDetails[] commands;

	public String getDisplayGroupName() {
		return displayGroupName;
	}

	public void setDisplayGroupName(String displayGroupName) {
		this.displayGroupName = displayGroupName;
	}

	public CommandDetails[] getCommands() {
		return commands;
	}

	public void setCommands(CommandDetails[] commands) {
		this.commands = commands;
	}

	@Override
	public String toString() {
		return "CommandGroups [displayGroupName = " + displayGroupName + ", commands = " + commands + "]";
	}
}