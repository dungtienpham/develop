package com.laptrinhjavaweb.dto;

import java.util.List;

public class DeactiveCardResponseDTO {
	private List<DeactiveCardDetailResponseDTO> list;

	public DeactiveCardResponseDTO() {
		super();
	}

	public DeactiveCardResponseDTO(List<DeactiveCardDetailResponseDTO> list) {
		super();
		this.list = list;
	}

	public List<DeactiveCardDetailResponseDTO> getList() {
		return list;
	}

	public void setList(List<DeactiveCardDetailResponseDTO> list) {
		this.list = list;
	}

}
