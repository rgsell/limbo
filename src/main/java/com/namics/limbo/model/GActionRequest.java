package com.namics.limbo.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * GActionRequest.
 *
 * @author lboesch, Namics AG
 * @since 17.11.17 10:54
 */
@XmlRootElement
public class GActionRequest {

	private String timestamp;
	private String lang;
	private Object[] contexts;
	private GActionResult result;


	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public GActionRequest lang(String lang) {
		setLang(lang);
		return this;
	}

	public Object[] getContexts() {
		return contexts;
	}

	public void setContexts(Object[] contexts) {
		this.contexts = contexts;
	}

	public GActionRequest contexts(Object[] contexts) {
		setContexts(contexts);
		return this;
	}

	public GActionResult getResult() {
		return result;
	}

	public void setResult(GActionResult result) {
		this.result = result;
	}

	public GActionRequest result(GActionResult result) {
		setResult(result);
		return this;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public GActionRequest timestamp(String timestamp) {
		setTimestamp(timestamp);
		return this;
	}

	@Override
	public String toString() {
		return "GActionRequest{" +
		       "timestamp='" + timestamp + '\'' +
		       ", lang='" + lang + '\'' +
		       ", contexts=" + (contexts != null) +
		       ", result=" + result +
		       '}';
	}
}
