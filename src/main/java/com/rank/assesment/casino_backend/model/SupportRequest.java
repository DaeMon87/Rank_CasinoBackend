package com.rank.assesment.casino_backend.model;

public class SupportRequest {
    
    private String username;
	private String securityKey;

	public SupportRequest() {
		this.username = "";
		this.securityKey = "";
	}

	public SupportRequest(String username, String securityKey) {
		this.username = username;
		this.securityKey = securityKey;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSecurityKey() {
		return securityKey;
	}

	public void setSecurityKey(String securityKey) {
		this.securityKey = securityKey;
	}

	
}
