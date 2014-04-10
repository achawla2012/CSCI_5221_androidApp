package com.location.business;

import java.util.List;

public class Login
{
	private int eventUserId = -1;
	public int getEventUserId() {
		return eventUserId;
	}
	public void setEventUserId(int eventUserId) {
		this.eventUserId = eventUserId;
	}
	public boolean isCheckLogin() {
		return checkLogin;
	}
	public void setCheckLogin(boolean checkLogin) {
		this.checkLogin = checkLogin;
	}
	public List<Event> getEventList() {
		return eventList;
	}
	public void setEventList(List<Event> eventList) {
		this.eventList = eventList;
	}
	private boolean checkLogin = false;
	public List<Event> eventList;
}
