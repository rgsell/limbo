package com.namics.limbo.model;

import java.util.Arrays;

/**
 * GActionResponse.
 *
 * @author lboesch, Namics AG
 * @since 17.11.17 10:35
 */
public class GActionResponse {

	private String speech = "";
	private String displayText = "";
	private Object[] contextOut = new Object[] {};


	public String getSpeech() {
		return speech;
	}

	public void setSpeech(String speech) {
		this.speech = speech;
	}

	public GActionResponse speech(String speech) {
		setSpeech(speech);
		return this;
	}

	public String getDisplayText() {
		return displayText;
	}

	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}

	public GActionResponse displayText(String displayText) {
		setDisplayText(displayText);
		return this;
	}

	public Object[] getContextOut() {
		return contextOut;
	}

	public void setContextOut(Object[] contextOut) {
		this.contextOut = contextOut;
	}

	public GActionResponse contextOut(Object[] contextOut) {
		setContextOut(contextOut);
		return this;
	}

	@Override
	public String toString() {
		return "GActionResponse{" +
		       "speech='" + speech + '\'' +
		       ", displayText='" + displayText + '\'' +
		       ", contextOut=" + Arrays.toString(contextOut) +
		       '}';
	}
}
