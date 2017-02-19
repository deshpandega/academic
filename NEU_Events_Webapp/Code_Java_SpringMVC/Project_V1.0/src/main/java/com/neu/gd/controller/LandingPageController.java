/**
 * 
 */
package com.neu.gd.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.gd.dao.EventDAO;
import com.neu.gd.dao.LoginDAO;
import com.neu.gd.pojo.EventPojo;
import com.neu.gd.pojo.LoginPojo;

/**
 * @author GD
 *
 */
@Controller
@RequestMapping("/")
public class LandingPageController {
	private static final Logger logger = LoggerFactory.getLogger(LandingPageController.class);
	
	@Autowired
	EventDAO eventDao;
	
	@Autowired
	LoginDAO loginDao;
	
//	@RequestMapping(value="/gd/loginPasswordForgot=*")
//    public String retrivePassword(){
//    	System.out.println("Got the link");
//    	return "forgotPasswordGetLink";
//    }
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView initializeForm(HttpServletRequest request, HttpServletResponse response){
		logger.debug("Index Page");
		ArrayList<EventPojo> allEvents = loadEvents();
		checkLoginFromCookies(request, response);
		return new ModelAndView("index", "allEvents", allEvents);
	}
	
	@RequestMapping(value="/index.vm", method = RequestMethod.GET)
	public ModelAndView homepage(HttpServletRequest request, HttpServletResponse response){
		logger.debug("Index Page");
		ArrayList<EventPojo> allEvents = loadEvents();
		checkLoginFromCookies(request, response);
		return new ModelAndView("index", "allEvents", allEvents);
	}
	
	private ArrayList<EventPojo> loadEvents(){
		ArrayList<EventPojo> allEvents = eventDao.loadEvents();
		
		for(int i=0;i<allEvents.size();i++){
			try {
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date date = format.parse(allEvents.get(i).getEventDate());
				//System.out.println("yyyy-MM-dd -->"+date);
				
				allEvents.get(i).setDateOfEvent(date);
				System.out.println("Date of Event--->"+allEvents.get(i).getDateOfEvent());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				allEvents.get(i).setDateOfEvent(null);
			}
		}
		try{
			Collections.sort(allEvents, new Comparator<EventPojo>() {
				public int compare(EventPojo o1, EventPojo o2) {
					return o2.getDateOfEvent().compareTo(o1.getDateOfEvent());
				}
			});
		}
		catch(Exception ex){
			System.out.println("Exception in parsing the date");
		}

		return allEvents;
	}
	
	private void checkLoginFromCookies(HttpServletRequest request, HttpServletResponse response){
		//Reading from cookies
		Cookie[] cookies = request.getCookies();
		LoginPojo loginPojo = new LoginPojo();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("username")) {
					loginPojo.setUsername(cookie.getValue());
				}
				else if (cookie.getName().equals("password")) {
					loginPojo.setPassword(cookie.getValue());
				}
			}
		}

		LoginPojo loginAttempt = loginDao.authenticateUser(loginPojo);
		if(loginAttempt!=null){
			HttpSession session = request.getSession(true);

			Cookie cookieUsename = new Cookie("username", loginAttempt.getUsername());
			cookieUsename.setMaxAge(864000000);
			Cookie cookiePassword = new Cookie("password", loginAttempt.getPassword());
			cookiePassword.setMaxAge(86400000);

			response.addCookie(cookieUsename);
			response.addCookie(cookiePassword);

			session.setAttribute("user", loginAttempt);
			session.setAttribute("name", loginAttempt.getPerson().getFirstName()+" "+loginAttempt.getPerson().getLastName());
		}
	}
}
