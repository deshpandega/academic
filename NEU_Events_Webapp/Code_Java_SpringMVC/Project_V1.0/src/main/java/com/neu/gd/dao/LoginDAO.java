/**
 * 
 */
package com.neu.gd.dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.neu.gd.pojo.LoginPojo;
import com.neu.gd.pojo.PersonPojo;

/**
 * @author GD
 *
 */
public class LoginDAO extends DAO{

	public LoginDAO() {
		
	}
	
	public LoginPojo authenticateUser(LoginPojo loginPojo){
		try{
			Query query = null;
			Criteria criteria = getSession().createCriteria(LoginPojo.class);
			criteria.add(Restrictions.like("username", loginPojo.getUsername(), MatchMode.EXACT));
			criteria.add(Restrictions.like("password", loginPojo.getPassword(), MatchMode.EXACT));
			LoginPojo loginSuccess = (LoginPojo)criteria.uniqueResult();
			
			if(null == loginSuccess){
				return null;
			}
			else{
				return loginSuccess;
			}
		}catch(HibernateException ex){
			System.out.println("Couln't login because of --->" + ex.getMessage());
			return null;
		}
	}

	public LoginPojo forgotPasswordSubmitRequest(LoginPojo loginPojo) {
		// TODO Auto-generated method stub
		try{
			Query query = null;
			Criteria criteria = getSession().createCriteria(LoginPojo.class);
			criteria.add(Restrictions.like("username", loginPojo.getUsername(), MatchMode.EXACT));
			LoginPojo loginSuccess = (LoginPojo)criteria.uniqueResult();
			
			if(null == loginSuccess){
				return null;
			}
			else{
				return loginSuccess;
			}
		}catch(HibernateException ex){
			System.out.println("Couln't login because of --->" + ex.getMessage());
			return null;
		}
	}

	public String updateForgotPasswordUrl(LoginPojo loginPojo) {
		// TODO Auto-generated method stub
		try{
			begin();
			getSession().update(loginPojo);
			commit();
			return "success";
		}
		catch(HibernateException ex){
			rollback();
			System.out.println(ex.getMessage());
			//throw new UserDefinedException("Exception while creating new user: " + ex.getMessage());
			return null;
		}
		finally{
			close();
		}
	}

	public String retriveUserInformation(String userId, String finalUrl) {
		// TODO Auto-generated method stub
		try{
			Query query = null;
			Criteria criteria = getSession().createCriteria(LoginPojo.class);
			criteria.add(Restrictions.like("neuID", userId, MatchMode.EXACT));
			LoginPojo loginSuccess = (LoginPojo)criteria.uniqueResult();
			if(null == loginSuccess){
				return null;
			}
			else{
				loginSuccess.setConfirmationLink("");
				begin();
				getSession().update(loginSuccess);
				commit();
				return "success";
			}
		}catch(HibernateException ex){
			System.out.println("Couln't login because of --->" + ex.getMessage());
			return null;
		}
		finally{
			close();
		}
		
	}

	public String resetPassword(String userId, String confirmPassword) {
		// TODO Auto-generated method stub
		try{
			Query query = null;
			Criteria criteria = getSession().createCriteria(LoginPojo.class);
			criteria.add(Restrictions.like("neuID", userId, MatchMode.EXACT));
			LoginPojo loginSuccess = (LoginPojo)criteria.uniqueResult();
			if(null == loginSuccess){
				return null;
			}
			else{
				loginSuccess.setPassword(confirmPassword);
				begin();
				getSession().update(loginSuccess);
				commit();
				return "success";
			}
		}catch(HibernateException ex){
			System.out.println("Couln't login because of --->" + ex.getMessage());
			return null;
		}
		finally{
			close();
		}
	}
}
