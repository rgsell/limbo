package com.namics.limbo.gaction;

import com.frogermcs.gactions.api.RequestHandler;
import com.frogermcs.gactions.api.request.RootRequest;

/**
 * Created by froger_mcs on 19/01/2017.
 */
public class MainRequestHandlerFactory extends RequestHandler.Factory {
	@Override
	public RequestHandler create(RootRequest rootRequest) {
		return new MainRequestHandler(rootRequest);
	}
}
