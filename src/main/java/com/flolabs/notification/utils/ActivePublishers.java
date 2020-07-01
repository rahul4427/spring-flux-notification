package com.flolabs.notification.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.flolabs.notification.domain.SSEDomain;

@Component
public class ActivePublishers {

	Map<String,SSEDomain> lookup = new HashMap<String, SSEDomain>();

	public SSEDomain getProcessor(String userName) {
		return lookup.get(userName);
	}

	public void addProcessor(String userName, SSEDomain sse) {
		lookup.put(userName,sse);
	}
	
	public void removeSSEDomain(String user) {
		lookup.remove(user);
	}
	
}
