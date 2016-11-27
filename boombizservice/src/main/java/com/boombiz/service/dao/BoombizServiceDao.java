package com.boombiz.service.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.boombiz.service.model.Businessuser;

public class BoombizServiceDao {
private HibernateTemplate template;

public BoombizServiceDao(HibernateTemplate template) {
	super();
	this.template = template;
}

public List<Businessuser> getUsersByCategory(String category){
	List<Businessuser> users = (List<Businessuser>) template.findByCriteria(DetachedCriteria.forClass(Businessuser.class).add(Restrictions.eq("category", category)));
	return users;
}
public static void main(String[] args) {
	   
    ApplicationContext context =  new ClassPathXmlApplicationContext("application-context.xml");  
      
    BoombizServiceDao dao=(BoombizServiceDao)context.getBean("boombizServiceDao"); 
    for (Businessuser user : dao.getUsersByCategory("automobile")) {
		System.out.println("UserName"+user.getUsername());
	}
}

}
