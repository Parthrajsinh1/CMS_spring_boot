package com.app.service;

import java.util.List;

import com.app.pojos.Tutorial;

public interface ITutorialService {
	public List<String> getTutorialDetails(long topicId);
	public Tutorial getTutorialDetails(String tutName) ;

}
