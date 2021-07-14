package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.controller.BusinessException;
import com.laptrinhjavaweb.dto.DeactiveCardDetailResponseDTO;
import com.laptrinhjavaweb.dto.DeactiveCardRequestDTO;
import com.laptrinhjavaweb.dto.DeactiveCardResponseDTO;
import com.laptrinhjavaweb.entity.DeactiveCardEntity;
import com.laptrinhjavaweb.repository.DeactiveCardRepository;
import com.laptrinhjavaweb.service.DeactiveCardService;

@Service
@Transactional(readOnly = true)
public class DeactiveCardServiceImpl implements DeactiveCardService {
	
	@Autowired
	DeactiveCardRepository deactiveCardrepo;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public String createUpdateDeactiveCard(DeactiveCardRequestDTO deactiveCardRequestDTO) {
		DeactiveCardEntity deactiveCardEntity = new DeactiveCardEntity();
		if (deactiveCardRequestDTO != null) {
			if (deactiveCardRequestDTO.getDataSource() != null) {
				DeactiveCardEntity deactiveCardExit = this
						.finddeactiveCardByDataSource(deactiveCardRequestDTO.getDataSource());
				if (deactiveCardExit != null) {
					if (deactiveCardRequestDTO.isCreate()) {
						throw new BusinessException("409", "DUPLICATE", "Datasource da ton tai");
					} else
						deactiveCardEntity = deactiveCardExit;
				}
				deactiveCardEntity.setDataSource(deactiveCardRequestDTO.getDataSource());
			}
		}
		if (deactiveCardRequestDTO.getPri() != null) {
			if (deactiveCardRequestDTO.getPri().equals("Y") || deactiveCardRequestDTO.getPri().equals("N")) {
				deactiveCardEntity.setPri(deactiveCardRequestDTO.getPri());
			} else
				throw new BusinessException("400", "BAD REQUEST", "chon 'Y' hoac 'N' ");
		}
		if (deactiveCardRequestDTO.getSup() != null) {
			if (deactiveCardRequestDTO.getSup().equals("Y") || deactiveCardRequestDTO.getSup().equals("N")) {
				deactiveCardEntity.setSup(deactiveCardRequestDTO.getSup());
			} else
				throw new BusinessException("400", "BAD REQUEST", "chon 'Y' hoac 'N' ");
		}
		if (deactiveCardRequestDTO.getVir_p() != null) {
			if (deactiveCardRequestDTO.getVir_p().equals("Y") || deactiveCardRequestDTO.getVir_p().equals("N")) {
				deactiveCardEntity.setVir_p(deactiveCardRequestDTO.getVir_p());
			} else
				throw new BusinessException("400", "BAD REQUEST", "chon 'Y' hoac 'N' ");
		}
		deactiveCardrepo.save(deactiveCardEntity);
		return "thanh cong";
	}

	private DeactiveCardEntity finddeactiveCardByDataSource(String dataSource) {

		return deactiveCardrepo.findByDataSource(dataSource);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public String deleteDeactiveCard(String request) {
		DeactiveCardEntity deactiveCardEntity = this.finddeactiveCardByDataSource(request);
		if (deactiveCardEntity != null) {
			deactiveCardrepo.delete(deactiveCardEntity);
			return "Thanh cong";
		}
		throw new BusinessException("404", "NOT FOUND", "Khong co du lieu xoa");
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public DeactiveCardDetailResponseDTO detail(String request) {
		DeactiveCardEntity deactiveCardEntity = this.finddeactiveCardByDataSource(request);
		if (deactiveCardEntity != null) {
			return this.DeactiveCardResponse(deactiveCardEntity);
		}
		throw new BusinessException("404", "NOT FOUND", "Khong tim thay du lieu");
	}

	private DeactiveCardDetailResponseDTO DeactiveCardResponse(DeactiveCardEntity deactiveCardEntity) {
		DeactiveCardDetailResponseDTO deactive = new DeactiveCardDetailResponseDTO();
		deactive.setDataSource(deactiveCardEntity.getDataSource());
		deactive.setPri(deactiveCardEntity.getPri());
		deactive.setSup(deactiveCardEntity.getSup());
		deactive.setVir_p(deactiveCardEntity.getVir_p());
		return deactive;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public DeactiveCardResponseDTO allDeactiveCard() {
		List<DeactiveCardDetailResponseDTO> list = new ArrayList<>();
		List<DeactiveCardEntity> listEntity = deactiveCardrepo.findAll();
		for (DeactiveCardEntity deactive : listEntity) {
			DeactiveCardDetailResponseDTO detail = this.DeactiveCardResponse(deactive);
			list.add(detail);
		}
		DeactiveCardResponseDTO responseDto = new DeactiveCardResponseDTO();
		responseDto.setList(list);
		return responseDto;
	}

}
