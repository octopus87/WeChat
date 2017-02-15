package com.zy.wechat.dataVO;

public class AccessToken {
	private String token;
	private long expires;
	private long getTime;
	
	public AccessToken(String token, long expires, long getTime) {
		super();
		this.token = token;
		this.expires = expires;
		this.getTime = getTime;
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public long getExpires() {
		return expires;
	}
	public void setExpires(long expires) {
		this.expires = expires;
	}

	public long getGetTime() {
		return getTime;
	}

	public void setGetTime(long getTime) {
		this.getTime = getTime;
	}

	@Override
	public String toString() {
		return "AccessToken [token=" + token + ", expires=" + expires + ", getTime=" + getTime + "]";
	}
}
