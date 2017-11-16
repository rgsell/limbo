package com.namics.limbo.gaction;

import com.frogermcs.gactions.ResponseHandler;
import com.frogermcs.gactions.api.response.RootResponse;
import com.google.gson.Gson;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * AppEngineResponseHandler.
 *
 * @author lboesch, Namics AG
 * @since 16.11.17 14:37
 */
public class AppEngineResponseHandler implements ResponseHandler {
	private final HttpServletResponse httpServletResponse;
	private final Gson gson;

	public AppEngineResponseHandler(HttpServletResponse httpServletResponse) {
		this(httpServletResponse, new Gson());
	}

	public AppEngineResponseHandler(HttpServletResponse httpServletResponse, Gson gson) {
		this.httpServletResponse = httpServletResponse;
		this.gson = gson;
	}

	@Override
	public void onPrepareContentType(String contentType) {
		httpServletResponse.setContentType(contentType);
	}

	@Override
	public void onPrepareResponseHeaders(Map<String, String> headers) {
		for (String headerName : headers.keySet()) {
			httpServletResponse.addHeader(headerName, headers.get(headerName));
		}
	}

	@Override
	public void onResponse(RootResponse rootResponse) {
		try {
			gson.toJson(rootResponse, httpServletResponse.getWriter());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
