package com.boombiz.service.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the connection database table.
 * 
 */
@Entity
@Table(name="connection")
@NamedQuery(name="Connection.findAll", query="SELECT c FROM Connection c")
public class Connection implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idconnection;
	private Date date;
	private byte isAccepted;
	private Businessuser connectionRequestFrom;
	private Businessuser connectionRequestTo;

	public Connection() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	public int getIdconnection() {
		return this.idconnection;
	}

	public void setIdconnection(int idconnection) {
		this.idconnection = idconnection;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	public byte getIsAccepted() {
		return this.isAccepted;
	}

	public void setIsAccepted(byte isAccepted) {
		this.isAccepted = isAccepted;
	}


	//bi-directional many-to-one association to Businessuser
	@ManyToOne
	@JoinColumn(name="requestFrom")
	public Businessuser getConnectionRequestFrom() {
		return this.connectionRequestFrom;
	}

	public void setConnectionRequestFrom(Businessuser connectionRequestFrom) {
		this.connectionRequestFrom = connectionRequestFrom;
	}


	//bi-directional many-to-one association to Businessuser
	@ManyToOne
	@JoinColumn(name="requestTo")
	public Businessuser getConnectionRequestTo() {
		return this.connectionRequestTo;
	}

	public void setConnectionRequestTo(Businessuser connectionRequestTo) {
		this.connectionRequestTo = connectionRequestTo;
	}

}