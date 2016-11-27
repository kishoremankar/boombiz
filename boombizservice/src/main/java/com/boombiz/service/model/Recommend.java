package com.boombiz.service.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the recommend database table.
 * 
 */
@Entity
@Table(name="recommend")
@NamedQuery(name="Recommend.findAll", query="SELECT r FROM Recommend r")
public class Recommend implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idrecommend;
	private String date;
	private String recommendMessage;
	private Businessuser recommendFrom;
	private Businessuser recommendTo;

	public Recommend() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	public int getIdrecommend() {
		return this.idrecommend;
	}

	public void setIdrecommend(int idrecommend) {
		this.idrecommend = idrecommend;
	}


	@Column(length=45)
	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	@Column(length=45)
	public String getRecommendMessage() {
		return this.recommendMessage;
	}

	public void setRecommendMessage(String recommendMessage) {
		this.recommendMessage = recommendMessage;
	}


	//bi-directional many-to-one association to Businessuser
	@ManyToOne
	@JoinColumn(name="recommendFrom")
	public Businessuser getRecommendFrom() {
		return this.recommendFrom;
	}

	public void setRecommendFrom(Businessuser recommendFrom) {
		this.recommendFrom = recommendFrom;
	}


	//bi-directional many-to-one association to Businessuser
	@ManyToOne
	@JoinColumn(name="recommendTo")
	public Businessuser getRecommendTo() {
		return this.recommendTo;
	}

	public void setRecommendTo(Businessuser recommendTo) {
		this.recommendTo = recommendTo;
	}

}