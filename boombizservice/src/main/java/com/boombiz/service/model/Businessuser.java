package com.boombiz.service.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


/**
 * The persistent class for the businessuser database table.
 * 
 */
@Entity
@Table(name="businessuser")
@NamedQuery(name="Businessuser.findAll", query="SELECT b FROM Businessuser b")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idBusinessUser")
public class Businessuser implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idBusinessUser;
	private String bussinessUserName;
	private String category;
	private String companyName;
	private String companyPhoneNo1;
	private String companyPhoneNo2;
	private String detailDescOfBusiness;
	private String sizeOfTheBusiness;
	private List<Address> addresses;
	private List<Connection> receivedConnectionRequests;
	private List<Connection> sentConnectionRequests;
	private List<Message> recievedMessages;
	private List<Message> sentMessages;
	private List<Recommend> recommendationsFrom;
	private List<Recommend> recommended;
	private List<Subscription> subscriptions;
	private String password;
	private String username;
	private String businessURL;

	public Businessuser() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	public int getIdBusinessUser() {
		return this.idBusinessUser;
	}

	public void setIdBusinessUser(int idBusinessUser) {
		this.idBusinessUser = idBusinessUser;
	}


	@Column(length=45)
	public String getBussinessUserName() {
		return this.bussinessUserName;
	}

	public void setBussinessUserName(String businessOwnerName) {
		this.bussinessUserName = businessOwnerName;
	}


	@Column(length=45)
	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}


	@Column(length=45)
	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	@Column(length=45)
	public String getCompanyPhoneNo1() {
		return this.companyPhoneNo1;
	}

	public void setCompanyPhoneNo1(String companyPhoneNo1) {
		this.companyPhoneNo1 = companyPhoneNo1;
	}


	@Column(length=45)
	public String getCompanyPhoneNo2() {
		return this.companyPhoneNo2;
	}

	public void setCompanyPhoneNo2(String companyPhoneNo2) {
		this.companyPhoneNo2 = companyPhoneNo2;
	}


	@Column(length=45)
	public String getDetailDescOfBusiness() {
		return this.detailDescOfBusiness;
	}

	public void setDetailDescOfBusiness(String detailDescOfBusiness) {
		this.detailDescOfBusiness = detailDescOfBusiness;
	}


	@Column(length=45)
	public String getSizeOfTheBusiness() {
		return this.sizeOfTheBusiness;
	}

	public void setSizeOfTheBusiness(String sizeOfTheBusiness) {
		this.sizeOfTheBusiness = sizeOfTheBusiness;
	}


	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="businessuser")
	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setBusinessuser(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setBusinessuser(null);

		return address;
	}


	//bi-directional many-to-one association to Connection
	@OneToMany(mappedBy="connectionRequestFrom")
	public List<Connection> getReceivedConnectionRequests() {
		return this.receivedConnectionRequests;
	}

	public void setReceivedConnectionRequests(List<Connection> receivedConnectionRequests) {
		this.receivedConnectionRequests = receivedConnectionRequests;
	}

	public Connection addReceivedConnectionRequests(Connection receivedConnectionRequests) {
		getReceivedConnectionRequests().add(receivedConnectionRequests);
		receivedConnectionRequests.setConnectionRequestFrom(this);

		return receivedConnectionRequests;
	}

	public Connection removeReceivedConnectionRequests(Connection receivedConnectionRequests) {
		getReceivedConnectionRequests().remove(receivedConnectionRequests);
		receivedConnectionRequests.setConnectionRequestFrom(null);

		return receivedConnectionRequests;
	}


	//bi-directional many-to-one association to Connection
	@OneToMany(mappedBy="connectionRequestTo")
	public List<Connection> getsentConnectionRequests() {
		return this.sentConnectionRequests;
	}

	public void setsentConnectionRequests(List<Connection> sentConnectionRequests) {
		this.sentConnectionRequests = sentConnectionRequests;
	}

	public Connection addsentConnectionRequests(Connection sentConnectionRequests) {
		getsentConnectionRequests().add(sentConnectionRequests);
		sentConnectionRequests.setConnectionRequestTo(this);

		return sentConnectionRequests;
	}

	public Connection removeConnections2(Connection sentConnectionRequests) {
		getsentConnectionRequests().remove(sentConnectionRequests);
		sentConnectionRequests.setConnectionRequestTo(null);

		return sentConnectionRequests;
	}


	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="messageFrom")
	public List<Message> getRecievedMessages() {
		return this.recievedMessages;
	}

	public void setRecievedMessages(List<Message> recievedMessages) {
		this.recievedMessages = recievedMessages;
	}

	public Message addRecievedMessages(Message recievedMessages) {
		getRecievedMessages().add(recievedMessages);
		recievedMessages.setMessageFrom(this);

		return recievedMessages;
	}

	public Message removeRecievedMessages(Message recievedMessages) {
		getRecievedMessages().remove(recievedMessages);
		recievedMessages.setMessageFrom(null);

		return recievedMessages;
	}


	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="messageTo")
	public List<Message> getSentMessages() {
		return this.sentMessages;
	}

	public void setSentMessages(List<Message> sentMessages) {
		this.sentMessages = sentMessages;
	}

	public Message addSentMessages(Message sentMessages) {
		getSentMessages().add(sentMessages);
		sentMessages.setMessageTo(this);

		return sentMessages;
	}

	public Message removeSentMessages(Message sentMessages) {
		getSentMessages().remove(sentMessages);
		sentMessages.setMessageTo(null);

		return sentMessages;
	}


	//bi-directional many-to-one association to Recommend
	@OneToMany(mappedBy="recommendFrom")
	public List<Recommend> getRecommendationsFrom() {
		return this.recommendationsFrom;
	}

	public void setRecommendationsFrom(List<Recommend> recommendationsFrom) {
		this.recommendationsFrom = recommendationsFrom;
	}

	public Recommend addRecommendationsFrom(Recommend recommendationsFrom) {
		getRecommendationsFrom().add(recommendationsFrom);
		recommendationsFrom.setRecommendFrom(this);

		return recommendationsFrom;
	}

	public Recommend removeRecommends1(Recommend recommendationsFrom) {
		getRecommendationsFrom().remove(recommendationsFrom);
		recommendationsFrom.setRecommendFrom(null);

		return recommendationsFrom;
	}


	//bi-directional many-to-one association to Recommend
	@OneToMany(mappedBy="recommendTo")
	public List<Recommend> getRecommended() {
		return this.recommended;
	}

	public void setRecommended(List<Recommend> recommended) {
		this.recommended = recommended;
	}

	public Recommend addRecommended(Recommend recommended) {
		getRecommended().add(recommended);
		recommended.setRecommendTo(this);

		return recommended;
	}

	public Recommend removeRecommended(Recommend recommended) {
		getRecommended().remove(recommended);
		recommended.setRecommendTo(null);

		return recommended;
	}


	//bi-directional many-to-one association to Subscription
	@OneToMany(mappedBy="businessuser")
	public List<Subscription> getSubscriptions() {
		return this.subscriptions;
	}

	public void setSubscriptions(List<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}

	public Subscription addSubscription(Subscription subscription) {
		getSubscriptions().add(subscription);
		subscription.setBusinessuser(this);

		return subscription;
	}

	public Subscription removeSubscription(Subscription subscription) {
		getSubscriptions().remove(subscription);
		subscription.setBusinessuser(null);

		return subscription;
	}
	@Column(length=45)
	public String getBusinessURL() {
		return this.businessURL;
	}

	public void setBusinessURL(String businessURL) {
		this.businessURL = businessURL;
	}
	@Column(length=45)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	@Column(length=45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}