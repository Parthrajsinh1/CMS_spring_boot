package com.app.dao;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.User;

import jakarta.persistence.EntityManager;


@Repository //MANDATORY : to tell SC , following is Spring bean containing DAL.
//this anno enables exc translation (chked/un chekd----> spring specific unchecked excs)
public class UserDaoImpl implements IUserDao {
	//dependency : Sesssion Factory
	@Autowired //OR JPA : @PersistenceContext
	private EntityManager manager;
	
	@Override
	public User authenticateUser(String email, String pass) {
		String jpql = "select u from User u join fetch u.roles where u.email=:em and u.password=:pass";
		return manager
				.createQuery(jpql, User.class)
				.setParameter("em",email)
				.setParameter("pass", pass)
				.getSingleResult();
	}//rets user + roles : in single select query

}
