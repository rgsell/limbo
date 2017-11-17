package com.namics.limbo.controller;

import com.namics.limbo.model.GActionRequest;
import com.namics.limbo.model.GActionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


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
			number = Integer.valueOf(rootRequest.getResult().getParameters().get("number"));
		}

		if (number == null) {
			return new GActionResponse().speech("wo ist denn die zahl?").displayText("****obacht****");
		}
		if (number == 1) {
			return new GActionResponse().displayText("Achtung, lustig.")
			                            .speech("Beat hat noch nicht genug Witze gehört. Was findet man beim Kannibalen in der Dusche? — Head and Shoulders.");
		}
		if (number == 2) {
			return new GActionResponse().displayText("Achtung, lustig.")
			                            .speech("Beat hat noch nicht genug Witze gehört. Wie heißt ein Spanier ohne Auto? — Carlos");
		}
		if (number == 3) {
			return new GActionResponse().displayText("Achtung, lustig.")
			                            .speech("Was ist ein studierter Bauer? —- Ein Ackerdemiker");
		}
		if (number == 4) {
			return new GActionResponse().displayText("Achtung, lustig.")
			                            .speech("Hopp Sangallä, fürä mit em Ballä.");
		}
		return new GActionResponse().speech("du hast limbo gesagt. wer kommt schon auf limbo " + number);
	}

	@PostMapping(value = "/bonus", produces = MediaType.APPLICATION_JSON_VALUE)
	public GActionResponse test(@RequestBody GActionRequest rootRequest) throws IOException {
		log.error("POST: " + rootRequest);

		if (rootRequest.getResult().getParameters().containsKey("name")) {
			int n = new Random().nextInt(20000) + 1;
			String prefix = n > 1000 ? "good job " : "uiuiui schlechtes jahr: ";
			String name = rootRequest.getResult().getParameters().get("name");
			if (name.equalsIgnoreCase("beat") || name.equalsIgnoreCase("helfenberger")) {
				return new GActionResponse().speech(name + "erhält dieses Jahr kein Bonus, er möchte nur Witze hören");
			}
			return new GActionResponse().speech(prefix + name + "erhält dieses Jahr einen Bonus von " + n);
		}
		List<String> names = Arrays.asList("Fredy", "Ueli", "Gorgio Contini", "Killo Barnetta", "Kyponto");
		return new GActionResponse().speech("du hast keinen Mitarbeiter angegeben, um den Bonus zu ermittlen. Der Mitarbeiter des Jahres ist aber " + names
				.stream()
				.findAny()
				.orElse("Theo"));
	}

}
