package com.namics.limbo.controller;

import com.frogermcs.gactions.ResponseBuilder;
import com.frogermcs.gactions.api.request.RootRequest;
import com.frogermcs.gactions.api.response.RootResponse;
import com.namics.limbo.model.GActionRequest;
import com.namics.limbo.model.GActionResponse;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;


/**
 * HomeController.
 *
 * @author rgsell, Namics AG
 * @since 16.11.17 10:27
 */
@RestController
public class HomeController {
	private static final Logger log = LoggerFactory.getLogger(HomeController.class.getName());

	@GetMapping("/")
	public String test() {
		return "Hello, world Google Actions";
	}

	@PostMapping("/")
	public GActionResponse postIt(@RequestBody GActionRequest rootRequest) throws IOException {
		log.error("POST: " + rootRequest);
		Integer number = null;
		if (rootRequest.getResult().getParameters().containsKey("number")) {
			number = (Integer) rootRequest.getResult().getParameters().get("number");
		}

		if (number == null) {
			return new GActionResponse().speech("wo ist denn die zahl?");
		}
		return new GActionResponse().speech("du hast limbo gesagt. wer kommt schon auf limbo " + number);
	}

	@PostMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
	public GActionResponse test(InputStream inputStream) throws IOException {
		log.error("POST to test: {}", IOUtils.toString(inputStream));
		RootResponse rootResponse = ResponseBuilder.tellResponse("You've just said: ueli");
		log.error("GActionResponse: {}", rootResponse);
		return new GActionResponse().speech("Hast du den ueli gemeint gäll?");
	}

	private RootRequest parseActionRequest(RootRequest request) throws IOException {
		log.info("REQUEST:" + request);
		return request;
	}
}
