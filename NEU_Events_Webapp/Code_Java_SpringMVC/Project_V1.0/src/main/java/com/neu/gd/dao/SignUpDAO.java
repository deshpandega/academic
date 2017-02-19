/**
 * 
 */
package com.neu.gd.dao;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import com.neu.gd.exception.UserDefinedException;
import com.neu.gd.pojo.LoginPojo;
import com.neu.gd.pojo.PersonPojo;
import com.neu.gd.util.EmailSending;

/**
 * @author GD
 *
 */

public class SignUpDAO extends DAO{
	public SignUpDAO(){
		
	}
	
	public int createUser(LoginPojo loginPojo) throws UserDefinedException{
		try{
			PersonPojo person = loginPojo.getPerson();
			person.setNeuID(loginPojo.getNeuID());
			loginPojo.setNeuID(loginPojo.getNeuID());
			
			loginPojo.setPerson(person);
			
			Query query = null;
			
			//
			String hql = "select user.username FROM LoginPojo user WHERE user.username = :value";
			query = getSession().createQuery(hql);
			query.setParameter("value", loginPojo.getUsername());
			String username= (String)query.uniqueResult();
			if(null==username){
				begin();
				getSession().save(loginPojo);
				commit();
				int i= EmailSending.sendMail(loginPojo, "Dear, " + loginPojo.getPerson().getFirstName()+" "+loginPojo.getPerson().getLastName()+ ", Thank you for signing up. Please login to your accouont using your husky email id and the password you selected.", "Confirm your email address");//sendConfirmationEmail(loginPojo, mailSender, templateMessage);
				if(i==0){
					return 1;
				}
				else{
					rollback();
					return 0;
				}
			}
			else{
				return 0;
			}
		}
		catch(HibernateException ex){
			rollback();
			System.out.println(ex.getMessage());
			//throw new UserDefinedException("Exception while creating new user: " + ex.getMessage());
			return 0;
		}
		finally{
			close();
		}
	}

	public String searchUserByNUID(String neuID) throws UserDefinedException {
		// TODO Auto-generated method stub
		try{
			Query query = null;
			//System.out.println("NEU ID-->"+neuID);
			String hql = "SELECT user.neuID FROM LoginPojo user WHERE user.neuID = :value";
			query = getSession().createQuery(hql);
			query.setParameter("value", neuID);
			String userID = (String)query.uniqueResult();
			//System.out.println("User -->"+userID);
			if(null==userID){
				return "NO";
			}
			else{
				return "YES";
			}
		}catch(HibernateException ex){
			System.out.println("Could not search user because of: "+ex.getMessage());
			//throw new UserDefinedException("Could not search user because of: "+ex.getMessage());
			return "";
		}catch (NumberFormatException ex) {
			// TODO: handle exception
			System.out.println("Could not search user because of: "+ex.getMessage());
			//throw new UserDefinedException("Could not search user because of: "+ex.getMessage());
			return "";
		}
	}

	public String searchUserByHuskyEmail(String email) {
		// TODO Auto-generated method stub
		try{
			Query query = null;
			
			String hql = "FROM LoginPojo user WHERE user.username = :value";
			query = getSession().createQuery(hql);
			query.setParameter("value", email);
			LoginPojo user = (LoginPojo)query.uniqueResult();
			if(null==user){
				return "NO";
			}
			else{
				return "YES";
			}
		}catch(HibernateException ex){
			System.out.println("Could not search user because of: "+ex.getMessage());
			//throw new UserDefinedException("Could not search user because of: "+ex.getMessage());
			return "";
		}catch (NumberFormatException ex) {
			// TODO: handle exception
			System.out.println("Could not search user because of: "+ex.getMessage());
			//throw new UserDefinedException("Could not search user because of: "+ex.getMessage());
			return "";
		}
	}
}
