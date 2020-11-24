package com.example.versioning.model;

import org.springframework.stereotype.Component;

/**
 * response thats sent back to UI
 *
 */
@Component
public class myapplication {


	String AppVersion;
	String lastcommitsha;
	String description;

	public String getAppVersion() {
		return AppVersion;
	}

	public void setAppVersion(String appVersion) {
		AppVersion = appVersion;
	}

	public String getLastcommitsha() {
		return lastcommitsha;
	}

	public void setLastcommitsha(String lastcommitsha) {
		this.lastcommitsha = lastcommitsha;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "myapplication [AppVersion=" + AppVersion + ", lastcommitsha=" + lastcommitsha + ", description="
				+ description + "]";
	}

}
