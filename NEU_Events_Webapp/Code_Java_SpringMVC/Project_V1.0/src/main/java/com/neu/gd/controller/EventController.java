 /**
 * 
 */
package com.neu.gd.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EventObject;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;

import com.neu.gd.dao.EventDAO;
import com.neu.gd.pojo.EventPojo;
import com.neu.gd.pojo.LoginPojo;
import com.neu.gd.validator.CreateEventValidator;

/**
 * @author GD
 *
 */
@Controller
@RequestMapping("/*event*.htm")
public class EventController {
	
	private static final Logger logger = LoggerFactory.getLogger(EventController.class);

	@Autowired
	@Qualifier("createEventValidator")
	CreateEventValidator createEventValidator;
	
	@Autowired
	EventDAO eventDao;
	
	@Autowired
	ServletContext servletContext;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// TODO Auto-generated method stub
		binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	    sdf.setLenient(false);
	    //binder.registerCustomEditor(Date.class, EventPojo.getEventDate(), new CustomDateEditor(sdf, true));
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
		binder.setValidator(createEventValidator);
	}
	
	@RequestMapping(value="/event.htm", method=RequestMethod.GET)
	public ModelAndView showEventPage(@ModelAttribute("createEventObject")EventPojo eventObj, BindingResult results, HttpServletRequest request){
		logger.debug("Create Event Page");
		HttpSession session = request.getSession();
		if(null==session || null==session.getAttribute("user")){
			return new ModelAndView("errorPage", "error", "Something went wrong!!");
		}
		else{
			return new ModelAndView("createEvent");
		}
	}
	
	@RequestMapping(value="/eventcreate.htm", method=RequestMethod.GET)
	public ModelAndView goToHomePage(){
		ModelAndView mv = new ModelAndView("redirect:index.vm");
		return mv;
	}
	
	@RequestMapping(value="/eventcreate.htm", method=RequestMethod.POST)
	public ModelAndView addEvent(@ModelAttribute("createEventObject")EventPojo eventObj, BindingResult results, HttpServletRequest request){
		System.out.println("Inside Add Event Controller");
		ModelAndView mv = null;
		File file;
		
		//Call Event Dao to save image path to database
		LoginPojo user = (LoginPojo) request.getSession().getAttribute("user");
		if(null==user){
			mv = new ModelAndView("errorPage", "error", "Something went wrong!!");
			return mv;
		}
		
		createEventValidator.validate(eventObj, results);
		if(results.hasErrors()){
			mv = new ModelAndView("createEvent");
			return mv;
		}
		
		String separator = File.separator;
		String filePathPattern = null;
		if(separator.equalsIgnoreCase("\\")){
			filePathPattern = servletContext.getRealPath("").replace("build\\", "");
			filePathPattern += "resources\\images\\";
		}
		
		if (separator.equalsIgnoreCase("/")) {
			filePathPattern = servletContext.getRealPath("").replace("build/", "");
			filePathPattern += "resources/images/";
        }
		
		if(eventObj.getEventPhoto() !=null){
			String imageNameWithExt = System.currentTimeMillis() + eventObj.getEventPhoto().getOriginalFilename();
            file = new File(filePathPattern + imageNameWithExt);
            String context = servletContext.getContextPath();

            try {
				eventObj.getEventPhoto().transferTo(file);
				eventObj.setImagePath(context + "/resources/images/" + imageNameWithExt);
				//System.out.println("----->"+eventObj.getImagePath());
			}
            catch (IllegalStateException e) {
				System.out.println("IllegalStateException: Couldn't upload file because of---->"+e.getMessage());
			}
            catch (IOException e) {
				System.out.println("IOException: Couldn't upload file because of---->"+e.getMessage());
			}
		}
		//System.out.println("------>"+eventObj.getEventName());
		
		Set<EventPojo> events = new HashSet<EventPojo>();
		events.add(eventObj);
		user.setEventSet(events);
		eventObj.setUser(user);
		
		int status = eventDao.createEvent(eventObj);
		if(status==1){
			//event created successfully! Find a way to show a pop up to user about this and move to index page
			System.out.println("Event Added successfully");
		}
		else{
			mv = new ModelAndView("createEvent", "createEventObject", eventObj);
			return mv;
		}
		
		mv = new ModelAndView("redirect:index.vm");
		return mv;
	}
	
	@RequestMapping(value="/viewevent.htm", method=RequestMethod.GET)
	public ModelAndView goToIndexPage(){
		ModelAndView mv = new ModelAndView("redirect:index.vm");
		return mv;
	}
	
	@RequestMapping(value="/viewevent.htm", method=RequestMethod.POST)
	public ModelAndView displayEvent(HttpServletRequest request){
		ModelAndView mv = null;
		long eventId = Long.parseLong(request.getParameter("eventNumber"));
		//System.out.println("--------------------->"+eventId);
		
		EventPojo eventFetched = eventDao.fetchEventDetails(eventId);
		
		String subscription = "";
		int i=0;
		LoginPojo loggedInUser = (LoginPojo) request.getSession().getAttribute("user");
		if(null!=loggedInUser){
			for(LoginPojo user: eventFetched.getSubscribers()){
				if(user.getNeuID().equalsIgnoreCase(loggedInUser.getNeuID())){
					//Subscriber already present
					i++;
					break;
				}
			}
		}
		
		if(i==1){
			subscription= "Unsubscribe";
		}
		else if(i==0){
			subscription= "Subscribe";
		}
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("Event Date (String)--->"+eventFetched.getEventDate());
		System.out.println("Date Event (Date)--->"+eventFetched.getDateOfEvent());
		//Date date;
		try {
			DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			//System.out.println("MM/dd/yyyy -->"+formatter.format(format.parse(eventFetched.getEventDate())));
			eventFetched.setEventDate(formatter.format(format.parse(eventFetched.getEventDate())));

			if(null!=eventFetched){
				mv = new ModelAndView("viewEvent", "event", eventFetched);
				mv.addObject("subscription",subscription);
			}
			else{
				mv = new ModelAndView("errorPage", "error", "Something went horibally wrong!");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return mv;
	}
	
	@RequestMapping(value="/eventSubscribe.htm",method=RequestMethod.POST)
	public ModelAndView subscribeUserToEvent(HttpServletRequest request, HttpServletResponse response) throws JSONException, IOException{
		ModelAndView mv = null;
		
		String eventId = request.getParameter("eventNumber");
		String subscription = request.getParameter("buttonText");
		
		LoginPojo userLoggedIn = (LoginPojo) request.getSession().getAttribute("user");
		
		System.out.println("Event id---->"+eventId);
		System.out.println("subscription ---->"+subscription);
		System.out.println("UserId--->"+userLoggedIn.getNeuID());
		
		EventPojo subscribed = eventDao.subscribeToEvent(eventId, userLoggedIn, subscription);
		if(null == subscribed){
			mv = new ModelAndView("errorPage", "error", "Something went horibally wrong!");
		}
		else{
			mv = new ModelAndView("viewEvent", "event", subscribed);
			if(subscription.equalsIgnoreCase("Subscribe")){
				mv.addObject("subscription", "Subscribed");
			}
			else{
				mv.addObject("subscription", "Subscribe");
			}
		}
		return mv;
	}
}
