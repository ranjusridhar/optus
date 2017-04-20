package org.ranjani.optus.controller;

import javax.servlet.http.HttpServletRequest;

import org.ranjani.optus.service.SubscriptionServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SubscriptionController 
{	
	SubscriptionServiceImpl subServiceImpl = new SubscriptionServiceImpl();
	
	@RequestMapping(value = "/subscribe" , method = RequestMethod.GET )
	public @ResponseBody String subscribe(HttpServletRequest request ) 
	{		
		String orderDetails = getOrderDetails();
		return subServiceImpl.truncate( orderDetails, 24 );		
	}
	
	public String getOrderDetails()
	{
		return "123456789012345678901234567890";		
	}
		
}

