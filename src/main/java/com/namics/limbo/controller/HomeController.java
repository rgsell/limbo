package com.namics.limbo.controller;

import com.frogermcs.gactions.AssistantActions;
import com.frogermcs.gactions.api.StandardIntents;
import com.frogermcs.gactions.api.request.RootRequest;
import com.namics.limbo.gaction.AppEngineResponseHandler;
import com.namics.limbo.gaction.MainRequestHandlerFactory;
import com.namics.limbo.gaction.MyPermissionRequestHandlerFactory;
import com.namics.limbo.gaction.TextRequestHandlerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * HomeController.
 *
 * @author rgsell, Namics AG
 * @since 16.11.17 10:27
 */
@RestController
public class HomeController {
	private static final Logger log = Logger.getLogger(HomeController.class.getName());

	@GetMapping("/")
	public String test() {
		return "Hello, world Google Actions";
	}

	@PostMapping("/")
	public void postIt(RootRequest rootRequest, HttpServletResponse response) throws IOException {
		log.info("POST: " + rootRequest);
		AssistantActions assistantActions =
				new AssistantActions.Builder(new AppEngineResponseHandler(response))
						.addRequestHandlerFactory(StandardIntents.MAIN, new MainRequestHandlerFactory())
						.addRequestHandlerFactory(StandardIntents.TEXT, new TextRequestHandlerFactory())
						.addRequestHandlerFactory(StandardIntents.PERMISSION, new MyPermissionRequestHandlerFactory())
						.build();

		assistantActions.handleRequest(parseActionRequest(rootRequest));
	}

	private RootRequest parseActionRequest(RootRequest request) throws IOException {
		log.info("REQUEST:" + request);
		return request;
	}
}
