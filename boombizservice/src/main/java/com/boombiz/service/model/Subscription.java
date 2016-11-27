package com.boombiz.service.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the subscription database table.
 * 
 */
@Entity
@Table(name="subscription")
@NamedQuery(name="Subscription.findAll", query="SELECT s FROM Subscription s")
public class Subscription implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idsubscription;
	private String typeOfSubscription;
	private Businessuser businessuser;

	public Subscription() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	public int getIdsubscription() {
		return this.idsubscription;
	}

	public void setIdsubscription(int idsubscription) {
		this.idsubscription = idsubscription;
	}


	@Column(length=45)
	public String getTypeOfSubscription() {
		return this.typeOfSubscription;
	}

	public void setTypeOfSubscription(String typeOfSubscription) {
		this.typeOfSubscription = typeOfSubscription;
	}


	//bi-directional many-to-one association to Businessuser
	@ManyToOne
	@JoinColumn(name="businessUser")
	public Businessuser getBusinessuser() {
		return this.businessuser;
	}

	public void setBusinessuser(Businessuser businessuser) {
		this.businessuser = businessuser;
	}

}