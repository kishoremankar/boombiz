package com.boombiz.service.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.boombiz.service.bl.BoombizServiceBl;
import com.boombiz.service.model.Businessuser;

public class BoomBizService {
private BoombizServiceBl boombizServiceBl;

public BoomBizService(BoombizServiceBl boombizServiceBl) {
	super();
	this.boombizServiceBl = boombizServiceBl;
}

public BoomBizService() {
	super();
}

@POST
@Path("/users/{category}")
@Produces(
{ MediaType.APPLICATION_JSON })
@Consumes(
{ MediaType.APPLICATION_JSON })
public List<Businessuser> getUsersByCategory(@PathParam("category") String category){
	List<Businessuser> users = new ArrayList<Businessuser>();
	for (Businessuser businessuser : boombizServiceBl.getUsersByCategory(category)) {
		users.add(businessuser);
	}
	return users;
}
}
