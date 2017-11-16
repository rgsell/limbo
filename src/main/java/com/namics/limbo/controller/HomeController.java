package com.namics.limbo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HomeController.
 *
 * @author rgsell, Namics AG
 * @since 16.11.17 10:27
 */
@RestController
public class HomeController {

	@GetMapping("/")
	public String test() {
		return "hello";
	}
}
