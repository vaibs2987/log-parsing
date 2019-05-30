package com.log.model;

public enum LogType {
	INFO("INFO"), WARNINNG("Warning"), CRITICAL("Critical"), BLOCKER("Blocker");

	private String logType;

	private LogType(String logType) {
		this.setLogType(logType);
	}

	public String getLogType() {
		return logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}

	public static LogType getLogType(String logTypeStr) {
		for (LogType logType : LogType.values()) {
			if (logType.getLogType().equalsIgnoreCase(logTypeStr)) {
				return logType;
			}
		}
		return null;
	}
}
