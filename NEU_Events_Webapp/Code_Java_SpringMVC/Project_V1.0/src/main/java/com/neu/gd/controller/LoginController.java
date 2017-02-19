/**
 * 
 */
package com.neu.gd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.gd.dao.LoginDAO;
import com.neu.gd.dao.SignUpDAO;
import com.neu.gd.exception.UserDefinedException;
import com.neu.gd.pojo.LoginPojo;
import com.neu.gd.util.EmailSending;
import com.neu.gd.validator.ForgotPasswordUsernameValidator;
import com.neu.gd.validator.LoginValidator;
import com.neu.gd.validator.SignUpValidator;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.apache.commons.codec.binary.Base64;

/**
 * @author GD
 *
 */
@Controller
@RequestMapping("/*login*.vm")
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	@Qualifier("signUpValidator")
	SignUpValidator signUpValidator;
	
	@Autowired
	@Qualifier("loginValidator")
	LoginValidator loginValidator;
	
	@Autowired
	@Qualifier("forgotPasswordUsernameValidator")
	ForgotPasswordUsernameValidator forgotPasswordUsernameValidator;
	
	@Autowired
	SignUpDAO signUpDao;
	
	@Autowired
	LoginDAO loginDao;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(signUpValidator);
	}
	
	@RequestMapping(value="login.vm", method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("loginPojo") LoginPojo loginPojo, BindingResult results){
		logger.debug("Login Page");
		return "login";  
	}
	
	@RequestMapping(value="login.vm", method = RequestMethod.POST)
	public ModelAndView loginUser(@ModelAttribute("loginPojo") LoginPojo loginPojo, BindingResult results, HttpServletRequest request, HttpServletResponse response){
		System.out.println("User Entered Details and Clicked Login");
		ModelAndView mv = null ;
		loginValidator.validate(loginPojo, results);
		if(results.hasErrors()){
			mv = new ModelAndView("login");
			return mv;
		}
		
		System.out.println(loginPojo.getUsername());
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			String text = loginPojo.getPassword();
			md.update(text.getBytes("UTF-8")); // Change this to "UTF-16" if needed
			byte[] digest = md.digest();
			String password = String.format("%064x", new java.math.BigInteger(1, digest));
			//System.out.println("Hashed Password--->"+password);
			loginPojo.setPassword(password);

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

				mv = new ModelAndView("redirect:index.vm"); //, "loginName", loginAttempt.getPerson().getFirstName()+" "+loginAttempt.getPerson().getLastName()
			}
			else{
				mv = new ModelAndView("login", "errorLogin", "Incorrect Username or Password");
			}
		}
		catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mv = new ModelAndView("login", "errorLogin", "Incorrect Username or Password");
		}
		catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mv = new ModelAndView("login", "errorLogin", "Incorrect Username or Password");
		}
		
		
		return mv;
	}
	
	
	@RequestMapping(value = "loginsignup.vm",method = RequestMethod.GET)
	public String signUpPage(@ModelAttribute("loginPojo") LoginPojo loginPojo, BindingResult results){
		logger.debug("Sign Up Page");
		return "signup";
	}
	
	@RequestMapping(value = "loginsignup.vm", method = RequestMethod.POST)
	public ModelAndView signUpUser(@ModelAttribute("loginPojo") LoginPojo loginPojo, BindingResult results, HttpServletRequest request){
		logger.debug("User Entered Details and Clicked Sign Up");
		ModelAndView mv = null ;
		signUpValidator.validate(loginPojo, results);
		if(results.hasErrors()){
			mv = new ModelAndView("signup");
			return mv;
		}
		
		try {
			int returnedVal;
			logger.debug("Name---->"+loginPojo.getPerson().getFirstName()+" "+loginPojo.getPerson().getLastName());
			logger.debug("User Name---->"+loginPojo.getUsername());
			logger.debug("Password---->"+loginPojo.getPassword());
			
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			String text = loginPojo.getPassword();
			md.update(text.getBytes("UTF-8"));
			byte[] digest = md.digest();
			String password = String.format("%064x", new java.math.BigInteger(1, digest));
			//System.out.println("Hashed Password--->"+password);
			loginPojo.setPassword(password);
			returnedVal = signUpDao.createUser(loginPojo);
			
			if(returnedVal == 1){
				mv = new ModelAndView("signUpSuccess", "user", loginPojo.getPerson().getFirstName()+" "+loginPojo.getPerson().getLastName());
			}
			else{
				mv = new ModelAndView("signup", "error", "User already exist with same NUID or Email ");
			}
		} catch (UserDefinedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mv = new ModelAndView("errorPage", "error", "Something went horibally wrong!");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mv = new ModelAndView("errorPage", "error", "Something went horibally wrong!");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mv = new ModelAndView("errorPage", "error", "Something went horibally wrong!");
		}
		return mv;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/loginCheckNUID.vm")
	public void checkNeuID(HttpServletRequest request, HttpServletResponse response) throws UserDefinedException, JSONException, IOException{
		String neuID = request.getParameter("neuID");
		String userPresentAlready = signUpDao.searchUserByNUID(neuID);
		//System.out.println("Result from search is------>"+userPresentAlready);
		
		JSONObject obj = new JSONObject();
		if(userPresentAlready.equalsIgnoreCase("YES")){
			obj.put("searchResult", "NUID already registered");
		}
		else if(userPresentAlready.equalsIgnoreCase("NO")){
			obj.put("searchResult", "");
		}
		else{
			obj.put("searchResult", "Can't search NUID");
		}
		PrintWriter out = response.getWriter();
		out.println(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/loginCheckEmail.vm")
	public void checkHuskyEmail(HttpServletRequest request, HttpServletResponse response) throws JSONException, IOException{
		String email = request.getParameter("username");
		String userPresentAlready = signUpDao.searchUserByHuskyEmail(email);
		//System.out.println("Result from search is------>"+userPresentAlready);
		
		JSONObject obj = new JSONObject();
		if(userPresentAlready.equalsIgnoreCase("YES")){
			obj.put("emailSearchResult", "Email ID already registered");
		}
		else if(userPresentAlready.equalsIgnoreCase("NO")){
			obj.put("emailSearchResult", "");
		}
		else{
			obj.put("emailSearchResult", "Can't search Email ID");
		}
		PrintWriter out = response.getWriter();
		out.println(obj);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/loginForgotPassword.vm")
	public String forgotPasswordMethod(@ModelAttribute("loginPojo") LoginPojo loginPojo, BindingResult results){
		return "forgotPassword";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/loginForgotPassword.vm")
	public ModelAndView forgotPasswordSubmit(@ModelAttribute("loginPojo") LoginPojo loginPojo, BindingResult results, HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = null ;
		forgotPasswordUsernameValidator.validate(loginPojo, results);
		if(results.hasErrors()){
			mv = new ModelAndView("forgotPassword");
			return mv;
		}
		
		System.out.println(loginPojo.getUsername());
		
		LoginPojo loginAttempt = loginDao.forgotPasswordSubmitRequest(loginPojo);
		if(null==loginAttempt){
			mv = new ModelAndView("forgotPassword", "errorLogin", "Incorrect Username");
		}
		else{
			String forgotPasswordLink = "ForgotPassword="+loginAttempt.getNeuID()+"="+loginAttempt.getUsername();
			System.out.println("Before encryption---->"+forgotPasswordLink);
			//forgotPasswordLink = encrypt(key,initVector, forgotPasswordLink);
			forgotPasswordLink = symmetricEncrypt(forgotPasswordLink);
			System.out.println("After encryption---->"+forgotPasswordLink);
			String finalURL = "http://localhost:9081/gd/loginPasswordForgot="+forgotPasswordLink+".vm";
			System.out.println(">>>"+finalURL);
			loginAttempt.setConfirmationLink(finalURL);
			//insert the url into database 
			String success = loginDao.updateForgotPasswordUrl(loginAttempt);
			
			if(null==success){
				//Forgot password link not saved into database. Please ask user to do it again.
				mv = new ModelAndView("forgotPassword", "errorLogin", "Something went wrong! While we work on it from our side, please submit the form again to proceed");
			}
			else{
				//send email
				int i = EmailSending.sendMail(loginAttempt, "Dear, " + loginAttempt.getPerson().getFirstName()+" "+loginAttempt.getPerson().getLastName()+ ", You have opted to reset your password. Please click the link below to reset your password   "+finalURL,"Reset Password Request");
				mv = new ModelAndView("login");
			}
		}
		return mv;
	}
	
	
	//Encryption-Decryption for forgot password link
//	public static String encrypt(String value) {
//        try {
//            Key key = generateKey();
//            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5");//AES
//            cipher.init(Cipher.ENCRYPT_MODE, key);
//
//            byte[] encVal = cipher.doFinal(value.getBytes());
//            String encryptedVal = new BASE64Encoder().encode(encVal);
//            return encryptedVal;
//        } catch (Exception e) {
//            e.getMessage();
//        }
//        return null;
//    }
//    
//    public static String decrypt(String value){
//        try {
//            Key key = generateKey();
//            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5");//AES
//            cipher.init(Cipher.DECRYPT_MODE, key);
//
//            byte[] decodedVal = new BASE64Decoder().decodeBuffer(value);
//            byte[] decVal = cipher.doFinal(decodedVal);
//            String decValue = new String(decVal);
//
//            return decValue;
//        } catch (Exception e) {
//            System.out.println("Couldn't decrypt because---->"+e.getMessage());
//        }
//        return null;
//    }
//    
//    private static Key generateKey() throws Exception{
//        Key key = new SecretKeySpec(new byte[]{'G','A','u','R','a','N','g','d','E','s','H','P','A','n','d','E'}, "AES");
//        return key;
//    }
    
    
    /**
     * New Encryption type
     * @return
     */
    public static String symmetricEncrypt(String text) {
    	String secretKey = "XMzDdG4D03CKm2IxIWQw7g==";
        byte[] raw;
        String encryptedString;
        SecretKeySpec skeySpec;
        byte[] encryptText = text.getBytes();
        Cipher cipher;
        try {
            raw = Base64.decodeBase64(secretKey);
            skeySpec = new SecretKeySpec(raw, "AES");
            cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            encryptedString = Base64.encodeBase64String(cipher.doFinal(encryptText));
        } 
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't encrypt because of--->"+e.getMessage());
            return "Error";
        }
        return encryptedString;
    }
    
    public static String symmetricDecrypt(String text) {
    	String secretKey = "XMzDdG4D03CKm2IxIWQw7g==";
        Cipher cipher;
        String encryptedString;
        byte[] encryptText = null;
        byte[] raw;
        SecretKeySpec skeySpec;
        try {
            raw = Base64.decodeBase64(secretKey);
            skeySpec = new SecretKeySpec(raw, "AES");
            encryptText = Base64.decodeBase64(text);
            cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            encryptedString = new String(cipher.doFinal(encryptText));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't decrypt because of--->"+e.getMessage());
            return "Error";
        }
        return encryptedString;
    }
    

//	String key = "Bar12345Bar12345"; // 128 bit key
//    String initVector = "RandomInitVector"; // 16 bytes IV
//	public static String encrypt(String key, String initVector, String value) {
//        try {
//            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
//            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
//
//            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
//            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
//
//            byte[] encrypted = cipher.doFinal(value.getBytes());
//            System.out.println("encrypted string: "
//                    + Base64.encodeBase64String(encrypted));
//
//            return Base64.encodeBase64String(encrypted);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//        return null;
//    }
//
//	public static String decrypt(String key, String initVector, String encrypted) {
//        try {
//            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
//            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
//
//            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
//            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
//
//            byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));
//
//            return new String(original);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//        return null;
//    }
	
	
    @RequestMapping(value="/*loginPassword*", method=RequestMethod.GET)
    public String getForgotPasswordLink(){
    	System.out.println("Link detected!!");
    	return "forgotPasswordGetLink";
    }
    
    
    @RequestMapping(method=RequestMethod.POST, value="/loginRetrivePassword.vm")
    public ModelAndView retrivePasswordFromLink(HttpServletRequest request, HttpServletResponse response){
    	String capturedURL = request.getParameter("passwordLink");
    	System.out.println("This is link entered from mail--->"+capturedURL);
    	
    	//String forgotPasswordLink = decrypt(key, initVector, capturedURL);
    	String forgotPasswordLink = symmetricDecrypt(capturedURL);
    	System.out.println("Decrypted Link---->"+forgotPasswordLink);
    	if(null==forgotPasswordLink || forgotPasswordLink.equalsIgnoreCase("Error")){
    		return new ModelAndView("errorPage", "error", "Something went horibally wrong!");
    	}
    	String [] parts = forgotPasswordLink.split("=");
    	String userId = parts[1];
    	String success = loginDao.retriveUserInformation(userId, capturedURL);
    	if(success.equalsIgnoreCase("success")){
    		return new ModelAndView("resetPassword", "user", userId);
    	}
    	else{
    		return new ModelAndView("errorPage", "error", "Something went horibally wrong!");
    	}
    }
    
    
    //loginRetrivePassword.vm
    @RequestMapping(method=RequestMethod.GET, value="/loginRetrivePassword.vm")
    public ModelAndView setPasswordTowardsErrorPage(){
    	System.out.println("Go to error page-->");
		return new ModelAndView("errorPage", "error", "Something went horibally wrong!");
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/loginSetNewPassword.vm")
    public ModelAndView setNewPassword(HttpServletRequest request, HttpServletResponse response){
    	String newPassword = request.getParameter("password");
    	String confirmPassword = request.getParameter("confirmPassword");
    	String userId = request.getParameter("user");
    	String success = "";
    	MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			String text = newPassword;
			md.update(text.getBytes("UTF-8"));
			byte[] digest = md.digest();
			String password = String.format("%064x", new java.math.BigInteger(1, digest));
			newPassword = password;
			
			md = MessageDigest.getInstance("SHA-256");
			String newText= confirmPassword;
			md.update(newText.getBytes("UTF-8"));
			byte[] newDigest = md.digest();
			String confPass = String.format("%064x", new java.math.BigInteger(1, newDigest));
			confirmPassword = confPass;
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error because-->"+e.getMessage());
			return new ModelAndView("errorPage", "error", "Something went horibally wrong!");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error because-->"+e.getMessage());
			return new ModelAndView("errorPage", "error", "Something went horibally wrong!");
		}
		
    	if(newPassword.equals(confirmPassword)){
    		success = loginDao.resetPassword(userId, confirmPassword);
    		if(null == success){
    			return new ModelAndView("resetPassword", "errorLogin", "Something went wrong! Please set your password again!");
    		}
    		else{
    			return new ModelAndView("redirect:index.vm");
    		}
    	}
    	else{
    		return new ModelAndView("resetPassword", "errorLogin", "Passwords don't match. Please match the passwords");
    	}
    }
}