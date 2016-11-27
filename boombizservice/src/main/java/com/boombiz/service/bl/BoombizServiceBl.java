package com.boombiz.service.bl;

import java.util.ArrayList;
import java.util.List;

import com.boombiz.service.dao.BoombizServiceDao;
import com.boombiz.service.model.Businessuser;

public class BoombizServiceBl {
private BoombizServiceDao boombizServiceDao;

public BoombizServiceBl(BoombizServiceDao boombizServiceDao) {
	super();
	this.boombizServiceDao = boombizServiceDao;
}

public List<Businessuser> getUsersByCategory(String category){
	List<Businessuser> users = new ArrayList<Businessuser>();
	users = boombizServiceDao.getUsersByCategory(category);
	return users;
}
}
