package com.laptrinhjavaweb.dto;

public class DeactiveCardRequestDTO {
	private String dataSource;
	private String pri;
	private String sup;
	private String vir_p;
	boolean isCreate;

	public DeactiveCardRequestDTO() {
		super();
	}

	public DeactiveCardRequestDTO(String dataSource, String pri, String sup, String vir_p, boolean isCreate) {
		super();
		this.dataSource = dataSource;
		this.pri = pri;
		this.sup = sup;
		this.vir_p = vir_p;
		this.isCreate = isCreate;
	}

	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getPri() {
		return pri;
	}

	public void setPri(String pri) {
		this.pri = pri;
	}

	public String getSup() {
		return sup;
	}

	public void setSup(String sup) {
		this.sup = sup;
	}

	public String getVir_p() {
		return vir_p;
	}

	public void setVir_p(String vir_p) {
		this.vir_p = vir_p;
	}

	public boolean isCreate() {
		return isCreate;
	}

	public void setCreate(boolean isCreate) {
		this.isCreate = isCreate;
	}

}
