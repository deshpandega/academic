/**
 * 
 */
package com.neu.gd.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author GD
 *
 */
@Controller
@RequestMapping("/logout.htm")
public class LogoutController {
	private static final Logger logger = LoggerFactory.getLogger(LogoutController.class);
	
	@RequestMapping(value="logout.htm", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response){
		logger.debug("Logout Controller");
		//Invalidate Session
		HttpSession session = request.getSession();
		session.invalidate();
		
		//Reset Cookies
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("username")) {
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
				else if (cookie.getName().equals("password")) {
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}
		return "redirect:index.vm";  
	}
}
