package com.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Topic;

import jakarta.persistence.EntityManager;

@Repository
@Transactional
public class TopicDaoImpl implements ITopicDao {
	//dependency EntityManager
	@Autowired
	private EntityManager em;

	@Override
	public List<Topic> getallTopics() {

		return em.createQuery("select t from Topic t", Topic.class).getResultList();
	}

}
