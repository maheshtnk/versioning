package com.example.versioning.model;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * response thats sent back to UI
 *
 */
@Component
public class AppModel {

	List<myapplication> myapplication;

	public List<myapplication> getmyapplication() {
		return myapplication;
	}

	public void setmyapplication(List<myapplication> myapplication) {
		this.myapplication = myapplication;
	}

	@Override
	public String toString() {
		return "AppModel [myapplication=" + myapplication + "]";
	}

}
