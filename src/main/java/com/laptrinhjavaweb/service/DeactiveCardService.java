package com.laptrinhjavaweb.service;

import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.dto.DeactiveCardDetailResponseDTO;
import com.laptrinhjavaweb.dto.DeactiveCardRequestDTO;
import com.laptrinhjavaweb.dto.DeactiveCardResponseDTO;
@Service
public interface DeactiveCardService {
	String createUpdateDeactiveCard(DeactiveCardRequestDTO deactiveCardRequestDTO);

	String deleteDeactiveCard(String request);

	DeactiveCardDetailResponseDTO detail(String request);

	DeactiveCardResponseDTO allDeactiveCard();

}
