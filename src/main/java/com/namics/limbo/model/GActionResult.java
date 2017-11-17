package com.namics.limbo.model;

import java.util.Map;

/**
 * GActionResult.
 *
 * @author lboesch, Namics AG
 * @since 17.11.17 10:56
 */
public class GActionResult {

	private String source;
	private String resolvedQuery;
	private String action;
	private String actionIncomplete;
	private Map<String, Object> parameters;


	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public GActionResult source(String source) {
		setSource(source);
		return this;
	}

	public String getResolvedQuery() {
		return resolvedQuery;
	}

	public void setResolvedQuery(String resolvedQuery) {
		this.resolvedQuery = resolvedQuery;
	}

	public GActionResult resolvedQuery(String resolvedQuery) {
		setResolvedQuery(resolvedQuery);
		return this;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public GActionResult action(String action) {
		setAction(action);
		return this;
	}

	public String getActionIncomplete() {
		return actionIncomplete;
	}

	public void setActionIncomplete(String actionIncomplete) {
		this.actionIncomplete = actionIncomplete;
	}

	public GActionResult actionIncomplete(String actionIncomplete) {
		setActionIncomplete(actionIncomplete);
		return this;
	}

	public Map<String, Object> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, Object> parameters) {
		this.parameters = parameters;
	}

	public GActionResult parameters(Map<String, Object> parameters) {
		setParameters(parameters);
		return this;
	}
}
