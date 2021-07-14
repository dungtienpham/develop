package com.laptrinhjavaweb.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "deactive_card")
//@SequenceGenerator(name = "DEACTIVE_CARD_SEQ", sequenceName = "DEACTIVE_CARD_SEQ", allocationSize = 1)
public class DeactiveCardEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "data_source")
	private String dataSource;

	@Column(name = "pri")
	private String pri;

	@Column(name = "sup")
	private String sup;

	@Column(name = "vir")
	private String vir_p;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

}
