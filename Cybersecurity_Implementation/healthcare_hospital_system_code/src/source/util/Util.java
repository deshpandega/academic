/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source.util;

/**
 *
 * @author GaurangDeshpande
 */
public final class Util {
    public static final String USERNAME_HINT = "username";
    public static final String PASSWORD_HINT = "password";
    public static final String LOGIN_BUTTON_TEXT = "Login";
    public static final String LOGOUT_BUTTON_TEXT = "Logout";
    
    public static final String WORK_AREA = "workArea";
    public static final String BLANK_WORK_AREA = "blankWorkArea";
    public static final String BLANK_QUOTES = "";
    
    
    //Error Messages
    public static final String ERROR_USERNAME_PASSWORD = "Please enter username and password";
    public static final String ERROR_USERNAME = "Please enter username";
    public static final String ERROR_PASSWORD = "Please enter password";
    public static final String ERROR_INVALID_CREDENTIALS = "User no found!";
    
    public static final String POP_UP_HEADING_ERROR = "ERROR";

    //DB4O 
    public static final String DB4O_FILE_NAME = "GothamGeneral.db4o"; // path to the data store
    
    
    //Encryption Options:
    static final String ALGORITHM = "AES";
    static final String ALGORITHM_PADDING = "AES/CBC/PKCS5PADDING";
    //static final String IT_IT_VECTOR = "";
    static final int ITERATIONS = 2;
    static final byte[] SECRET_KEY = new byte[]{'G','A','u','R','a','N','g','d','E','s','H','P','A','n','d','E'};
    static final String SALT_KEY = "NortheasternUniv";
    
    //Send Email
    static final String USERNAME = "inferno.kool@gmail.com";
    static final String PASSWORD = "IMhopelessbutstilliamCOOL9";
}
