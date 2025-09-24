package com.app.dao;

import java.util.List;

import com.app.pojos.Tutorial;

public interface ITutorialDao {
	List<String> getTutorialDetails(long topicId);
	
	Tutorial getTutorialDetails(String tutName);
}
