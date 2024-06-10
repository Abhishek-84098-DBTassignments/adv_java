package com.sunbeam.listeners;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.sunbeam.entities.User;

public class AppSessionListener implements HttpSessionListener {
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("New session Started!!");
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		User usr = (User) session.getAttribute("curuser");
		System.out.println("Session stopped :: " + usr.getFirstName());
	}
}
