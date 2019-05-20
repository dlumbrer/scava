package org.eclipse.scava.crossflow.runtime.utils;

import org.eclipse.scava.crossflow.runtime.Workflow;

public class CrossflowLogger {

	private Workflow w;

	public enum SEVERITY {
		INFO, WARNING, ERROR
	}

	public CrossflowLogger(Workflow w) {
		this.w = w;
	}

	public void log(SEVERITY level, String message) {
		LogMessage m = new LogMessage(level, message, w.getName());
		try {
			w.getLogTopic().send(m);
		} catch (Exception e) {
			System.err.println("Exception occurred while trying to send LogMessage to LogTopic: " + e.getMessage());
			System.err.println("Message: " + message);
		}
	}

	public void log(SEVERITY level, String message, String taskName) {
		LogMessage m = new LogMessage(level, message, w.getName() + " | " + taskName);
		try {
			w.getLogTopic().send(m);
		} catch (Exception e) {
			System.err.println("Exception occurred while trying to send LogMessage to LogTopic: " + e.getMessage());
			System.err.println("Message: " + message);
		}
	}

	public void log(String message) {
		LogMessage m = new LogMessage(SEVERITY.INFO, message, w.getName());
		try {
			w.getLogTopic().send(m);
		} catch (Exception e) {
			System.err.println("Exception occurred while trying to send LogMessage to LogTopic: " + e.getMessage());
			System.err.println("Message: " + message);
		}
	}

}
