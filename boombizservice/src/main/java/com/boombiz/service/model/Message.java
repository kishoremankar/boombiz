package com.boombiz.service.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the message database table.
 * 
 */
@Entity
@Table(name="message")
@NamedQuery(name="Message.findAll", query="SELECT m FROM Message m")
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idMessage;
	private String content;
	private Date date;
	private Businessuser messageFrom;
	private Businessuser messageTo;

	public Message() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	public int getIdMessage() {
		return this.idMessage;
	}

	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}


	@Column(length=500)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	//bi-directional many-to-one association to Businessuser
	@ManyToOne
	@JoinColumn(name="messageFrom")
	public Businessuser getMessageFrom() {
		return this.messageFrom;
	}

	public void setMessageFrom(Businessuser messageFrom) {
		this.messageFrom = messageFrom;
	}


	//bi-directional many-to-one association to Businessuser
	@ManyToOne
	@JoinColumn(name="messageTo")
	public Businessuser getMessageTo() {
		return this.messageTo;
	}

	public void setMessageTo(Businessuser messageTo) {
		this.messageTo = messageTo;
	}

}