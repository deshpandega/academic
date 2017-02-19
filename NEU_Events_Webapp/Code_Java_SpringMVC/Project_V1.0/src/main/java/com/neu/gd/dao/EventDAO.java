/**
 * 
 */
package com.neu.gd.dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Component;

import com.neu.gd.pojo.EventPojo;
import com.neu.gd.pojo.LoginPojo;

/**
 * @author GD
 *
 */
@Component
public class EventDAO extends DAO{
	public EventDAO(){
		
	}
	
	public int createEvent(EventPojo eventObj){
		try{
			begin();
			getSession().save(eventObj);
			commit();
			return 1;
		}
		catch(HibernateException ex){
			rollback();
			System.out.println(ex.getMessage());
			return 0;
		}
		finally{
			close();
		}
	}
	
	public ArrayList<EventPojo> loadEvents(){
		ArrayList<EventPojo> eventsList = new ArrayList<EventPojo>();
		eventsList= (ArrayList<EventPojo>)(getSession().getNamedQuery("events.loadAll")).list();
		return eventsList;
	}
	
	public EventPojo fetchEventDetails(long eventId){
		try{
			Query query = null;
			System.out.println("EVENT ID-->"+eventId);
			String hql = "FROM EventPojo event WHERE event.id = :value";
			query = getSession().createQuery(hql);
			query.setParameter("value", eventId);
			EventPojo event = (EventPojo)query.uniqueResult();
			return event;
		}
		catch(HibernateException ex){
			System.out.println("Could not fetch event because of: "+ex.getMessage());
			//throw new UserDefinedException("Could not search user because of: "+ex.getMessage());
			return null;
		}
		finally{
			close();
		}
	}

	public EventPojo subscribeToEvent(String eventId, LoginPojo userLoggedIn, String subscription) {
		// TODO Auto-generated method stub
		try{
 			Query query = null;
			System.out.println("EVENT ID-->"+eventId);
			String hql = "FROM EventPojo event WHERE event.id = :value";
			query = getSession().createQuery(hql);
			query.setParameter("value", Long.parseLong(eventId));
			EventPojo event = (EventPojo)query.uniqueResult();
			if(null != event){
				if(subscription.equalsIgnoreCase("Subscribe")){
					event.addSubscriber(userLoggedIn);
				}
				else if(subscription.equalsIgnoreCase("Unsubscribe")){
					event.removeSubscriber(userLoggedIn);
				}
				
				begin();
				getSession().save(event);
				commit();
				return event;
			}
			else{
				return null;
			}
		}
		catch(HibernateException ex){
			System.out.println("Could not fetch event because of: "+ex.getMessage());
			//throw new UserDefinedException("Could not search user because of: "+ex.getMessage());
			return null;
		}
		finally{
			close();
		}
	}
}
