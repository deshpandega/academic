/**
 * 
 */
package com.neu.gd.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.gd.util.EmailSending;
import com.neu.gd.util.PDFGeneration;
import com.neu.gd.validator.CreateEventValidator;

/**
 * @author GD
 *
 */
@Controller
@RequestMapping("/*footer*.*")
public class FooterController {
	private static final Logger logger = LoggerFactory.getLogger(FooterController.class);
	
	@RequestMapping(value="/footerTerms.htm", method=RequestMethod.GET)
	public ModelAndView showPDFTerms(){
		PDFGeneration pdfGenerator = new PDFGeneration();
		return new ModelAndView(pdfGenerator);
	}
	
	@RequestMapping(value="/footerAboutUs.htm", method=RequestMethod.GET)
	public String showAboutUs(){
		return "aboutus";
	}
	
	@RequestMapping(value="/footerContact.htm", method=RequestMethod.GET)
	public String showContact(){
		return "contactus";
	}
	
	@RequestMapping(value="/footerContactus.ftl", method=RequestMethod.POST)
	public ModelAndView sendMailOnContactUs(HttpServletRequest request){
		ModelAndView mv;
		String sender = request.getParameter("email");
		String subject = request.getParameter("subject");
		String body = request.getParameter("message");
		int i = EmailSending.sendContactUs(sender, body, subject);
		if(i==0){
			mv = new ModelAndView("contactus", "response", "Thank you for your feedback!");
		}
		else{
			mv = new ModelAndView("contactus", "response", "Something went wrong! While we work on it from our side, please submit the form again to proceed");
		}
		return mv;
	}
}