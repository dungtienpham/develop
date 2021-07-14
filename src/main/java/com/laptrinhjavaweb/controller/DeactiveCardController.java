package com.laptrinhjavaweb.controller;

import java.net.URI;
import java.net.URISyntaxException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.laptrinhjavaweb.dto.DeactiveCardDetailResponseDTO;
import com.laptrinhjavaweb.dto.DeactiveCardRequestDTO;
import com.laptrinhjavaweb.dto.DeactiveCardResponseDTO;
import com.laptrinhjavaweb.service.DeactiveCardService;

@RestController
@RequestMapping(value = "/deactivecard/")
public class DeactiveCardController {
	@Autowired
	DeactiveCardService deactiveCardService;

	@PostMapping("/create-update")
	public ResponseEntity<String> createOrUpdateDeactiveCard(
			@RequestBody @Valid DeactiveCardRequestDTO deactiveCardRequestDTO) throws URISyntaxException {
		String result = deactiveCardService.createUpdateDeactiveCard(deactiveCardRequestDTO);
		return ResponseEntity.created(new URI("create-update")).body(result);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteCard(@RequestParam(required = true) String source) {
		String result = deactiveCardService.deleteDeactiveCard(source);
		return ResponseEntity.ok().body(result);
	}

	@GetMapping("/detail")
	public ResponseEntity<DeactiveCardDetailResponseDTO> deactiveDetail(@RequestParam(required = true) String source) {
		DeactiveCardDetailResponseDTO deactiveResponse = deactiveCardService.detail(source);
		return ResponseEntity.ok().body(deactiveResponse);
	}

	@GetMapping("/list")
	public ResponseEntity<DeactiveCardResponseDTO> allDeactiveCard() {
		DeactiveCardResponseDTO allDeactive = deactiveCardService.allDeactiveCard();
		return ResponseEntity.ok().body(allDeactive);
	}
}
