/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source.util;

import java.security.Key;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.commons.codec.binary.Base64;
import source.department.Department.DepartmentType;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author GaurangDeshpande
 */
public final class UtilFunctions {
    public static String assignDepartmentID(String name) {
        if(DepartmentType.Admission.getValue().equals(name)){
            return "DEPT001";
        }
        else if(DepartmentType.Anesthesia.getValue().equals(name)){
            return "DEPT002";
        }
        else if(DepartmentType.Emergency.getValue().equals(name)){
            return "DEPT003";
        }
        else if(DepartmentType.Gynecology.getValue().equals(name)){
            return "DEPT004";
        }
        else if(DepartmentType.Laboratory.getValue().equals(name)){
            return "DEPT005";
        }
        else if(DepartmentType.Neurology.getValue().equals(name)){
            return "DEPT006";
        }
        else if(DepartmentType.Nursing.getValue().equals(name)){
            return "DEPT007";
        }
        else if(DepartmentType.Pediatrics.getValue().equals(name)){
            return "DEPT008";
        }
        else if(DepartmentType.Security.getValue().equals(name)){
            return "DEPT009";
        }
        else if(DepartmentType.Surgery.getValue().equals(name)){
            return "DEPT010";
        }
        else if(DepartmentType.XRay.getValue().equals(name)){
            return "DEPT011";
        }
        
        return null;
    }
    
    public static boolean validateTextOnly(String text){
        for(int i=0;i<text.length();i++){
            switch(text.charAt(i)){
                case '0': return false;
                case '1': return false;
                case '2': return false;
                case '3': return false;
                case '4': return false;
                case '5': return false;
                case '6': return false;
                case '7': return false;
                case '8': return false;
                case '9': return false;
                case '!': return false;
                case '@': return false;
                case '#': return false;
                case '$': return false;
                case '%': return false;
                case '^': return false;
                case '&': return false;
                case '*': return false;
                case '-': return false;
                case '_': return false;
                case '+': return false;
                case '.': return false;
                case ',': return false;
                case '\'': return false;
                case '"': return false;
                case '=': return false;
                case '(': return false;
                case ')': return false;
                case '{': return false;
                case '}': return false;
                case '[': return false;
                case ']': return false;
                case '|': return false;
                case '\\': return false;
                case ';': return false;
                case ':': return false;
                case '<': return false;
                case '>': return false;
                case '/': return false;
                case '?': return false;
                case '~': return false;
                case '`': return false;
            }
        }
        return true;
    }
    
    public static boolean validateNumberAndText(String value){
        for(int i=0;i<value.length();i++){
            switch(value.charAt(i)){
                case '!': return false;
                case '@': return false;
                case '#': return false;
                case '$': return false;
                case '%': return false;
                case '^': return false;
                case '&': return false;
                case '*': return false;
                case '-': return false;
                case '_': return false;
                case '+': return false;
                case '.': return false;
                case ',': return false;
                case '\'': return false;
                case '"': return false;
                case '=': return false;
                case '(': return false;
                case ')': return false;
                case '{': return false;
                case '}': return false;
                case '[': return false;
                case ']': return false;
                case '|': return false;
                case '\\': return false;
                case ';': return false;
                case ':': return false;
                case '<': return false;
                case '>': return false;
                case '/': return false;
                case '?': return false;
                case '~': return false;
                case '`': return false;
            }
        }
        return true;
    }
    
    public static boolean validateNumericalsOnly(String numbers){
        for(int i=0;i<numbers.length();i++){
            switch(numbers.charAt(i)){
                case '0': break;
                case '1': break;
                case '2': break;
                case '3': break;
                case '4': break;
                case '5': break;
                case '6': break;
                case '7': break;
                case '8': break;
                case '9': break;
                default: return false;
            }
        }
        return true;
    }
    
    public static boolean validateUsernameCriteria(String username){
        if(username.length()<6||username.length()>20){
            return false;
        }
        else{
            return true;
        }
    }
    
    public static boolean validatePasswordCriteria(String password) {
        final Pattern hasUppercase = Pattern.compile("[A-Z]");
        final Pattern hasLowercase = Pattern.compile("[a-z]");
        final Pattern hasNumber = Pattern.compile("\\d");
        final Pattern hasSpecialChar = Pattern.compile("[^a-zA-Z0-9 ]");

        if (password.length() < 6 || password.length()>20) {
            return false;
        }
        if (!hasUppercase.matcher(password).find()) {
            return false;
        }

        if (!hasLowercase.matcher(password).find()) {
            return false;
        }

        if (!hasNumber.matcher(password).find()) {
            return false;
        }

        if (!hasSpecialChar.matcher(password).find()) {
            return false;
        }
        return true;
    }
    
    public static boolean validateZip(String zip){
        for(int i=0;i<zip.length();i++){
            switch(zip.charAt(i)){
                case '0': break;
                case '1': break;
                case '2': break;
                case '3': break;
                case '4': break;
                case '5': break;
                case '6': break;
                case '7': break;
                case '8': break;
                case '9': break;
                default: return false;
            }
        }
        if(zip.length()==5){
            return true;
        }
        else{
            return false;
        }
    }
    
    public static boolean validateSSN(String SSN){
        for(int i=0;i<SSN.length();i++){
            switch(SSN.charAt(i)){
                case '0': break;
                case '1': break;
                case '2': break;
                case '3': break;
                case '4': break;
                case '5': break;
                case '6': break;
                case '7': break;
                case '8': break;
                case '9': break;
                default: return false;
            }
        }
        if(SSN.length()==9){
            return true;
        }
        else{
            return false;
        }
        
    }
    
    public static boolean validateEmailAddress(String emailText){
        String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return emailText.matches(EMAIL_REGEX);
    }
    
    public static ArrayList<String> populateGender(){
        ArrayList<String> genders = new ArrayList<>();
        genders.add("Male");
        genders.add("Female");
        return genders;
    }
    
    public static ArrayList<String> populateStates(){
        ArrayList<String> states = new ArrayList<>();
        states.add("AL");
        states.add("AK");
        states.add("AZ");
        states.add("AR");
        states.add("CA");
        states.add("CO");
        states.add("CT");
        states.add("DE");
        states.add("FL");
        states.add("GA");
        states.add("HI");
        states.add("ID");
        states.add("IL");
        states.add("IN");
        states.add("IA");
        states.add("KS");
        states.add("KY");
        states.add("LA");
        states.add("ME");
        states.add("MD");
        states.add("MA");
        states.add("MI");
        states.add("MN");
        states.add("MS");
        states.add("MO");
        states.add("MT");
        states.add("NE");
        states.add("NV");
        states.add("NH");
        states.add("NJ");
        states.add("NM");
        states.add("NY");
        states.add("NC");
        states.add("ND");
        states.add("OH");
        states.add("OK");
        states.add("OR");
        states.add("PA");
        states.add("RI");
        states.add("SC");
        states.add("SD");
        states.add("TN");
        states.add("TX");
        states.add("UT");
        states.add("VT");
        states.add("VA");
        states.add("WA");
        states.add("WV");
        states.add("WI");
        states.add("WY");
        return states;
    }
    
    public static boolean validateDateFormat(String date){
        try{
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            formatter.parse(date);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
     
    public static boolean validateDateSequence(String dateTill, String dateFrom){
        try{
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            Date tillDate = formatter.parse(dateTill);
            Date fromDate = formatter.parse(dateFrom);
            
            if(fromDate.before(tillDate)){
                return true;
            }
            else{
                return false;
            }
            
        }
        catch (Exception e){
            return false;
        }
    }
    
    public static boolean validateDateSequence(Date dateTill, Date dateFrom) {
        return dateFrom.before(dateTill);
    }

    public static boolean validatePastDate(String dateTill){
        try{
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            Date surgeryDate = formatter.parse(dateTill);
            Date today = formatter.parse(formatter.format(new Date()));
            
            if(surgeryDate.before(today)){
                return false;
            }
            else if(surgeryDate.equals(today)){
                return true;
            }
            else{
                return true;
            }
            
        }
        catch (Exception e){
            return false;
        }
    }
    
    public static Date formatDate(String date){
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        try {
            return formatter.parse(date);
        } catch (Exception e) {
            return null;
        }
    }

    public static Date formatDate(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        try {
            return formatter.parse(formatter.format(date));
        } catch (Exception e) {
            return null;
        }
    }    
    public static Date getTodayFormattedDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        try {
            return formatter.parse(formatter.format(new Date()));
        } catch (Exception e) {
            return null;
        }
    }
    
    public static String encrypt(String value) {
        try {
            Key key = generateKey();
            Cipher cipher = Cipher.getInstance(Util.ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] encVal = cipher.doFinal(value.getBytes());
            String encryptedVal = new BASE64Encoder().encode(encVal);
            return encryptedVal;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }
    
    public static String decrypt(String value){
        try {
            Key key = generateKey();
            Cipher cipher = Cipher.getInstance(Util.ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);

            byte[] decodedVal = new BASE64Decoder().decodeBuffer(value);
            byte[] decVal = cipher.doFinal(decodedVal);
            String decValue = new String(decVal);

            return decValue;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }
    
    private static Key generateKey() throws Exception{
        Key key = new SecretKeySpec(Util.SECRET_KEY, Util.ALGORITHM);
        return key;
        
        //KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        //keyGen.init(128); // for example
        //SecretKey secretKey = keyGen.generateKey();
        //return secretKey;
        
        //SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        //byte[] salt = new byte[8];
        //new SecureRandom().nextBytes(salt);
        //PBEKeySpec spec = new PBEKeySpec(KEY.toCharArray(), salt, 10000, 128);
        //SecretKey tmp = factory.generateSecret(spec);
        //SecretKey key = new SecretKeySpec(tmp.getEncoded(), "AES");
        //return key;
    }
    
    public static String encryptText(String data) throws Exception {
        String key = "GaurangDeshpande";
        IvParameterSpec iv = new IvParameterSpec(Util.SALT_KEY.getBytes("UTF-8"));
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), Util.ALGORITHM);

        Cipher cipher = Cipher.getInstance(Util.ALGORITHM_PADDING);
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

        byte[] encrypted = cipher.doFinal(data.getBytes());
        System.out.println("encrypted string: " + Base64.encodeBase64String(encrypted));

        return Base64.encodeBase64String(encrypted);
    }

     public static String decryptText(String data) throws Exception {
         String key = "GaurangDeshpande";
        IvParameterSpec iv = new IvParameterSpec(Util.SALT_KEY.getBytes("UTF-8"));
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), Util.ALGORITHM);

        Cipher cipher = Cipher.getInstance(Util.ALGORITHM_PADDING);
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

        byte[] original = cipher.doFinal(Base64.decodeBase64(data));

        return new String(original);
    }
    
    public static String encryption(String value) throws Exception {
        Key key = generateKey();
        Cipher cipher = Cipher.getInstance(Util.ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        
        String valueToEnc = null;
        String eValue = value;
        for (int i = 0; i < Util.ITERATIONS; i++) {
            valueToEnc = Util.SALT_KEY + eValue;
            byte [] encValue = cipher.doFinal(valueToEnc.getBytes());
            eValue = new BASE64Encoder().encode(encValue);
        }
        return eValue;
    }

    public static String decryption(String value) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(Util.ALGORITHM);
        c.init(Cipher.DECRYPT_MODE, key);
        
        String dValue = null;
        String valueToDecrypt = value;
        for (int i = 0; i < Util.ITERATIONS; i++) {
             byte[] decodedValue= new BASE64Decoder().decodeBuffer(valueToDecrypt);
             byte[] decValue = c.doFinal(decodedValue);
             dValue = new String(decValue).substring(Util.SALT_KEY.length());
             valueToDecrypt = dValue;
        }
        return dValue;
    }

    public static void sendEmail(String addresslist, String name, String subject, String purpose){
        
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        
        
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(Util.USERNAME, Util.PASSWORD);
            }
        });
        
        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Util.USERNAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(addresslist));
            message.setSubject("");
            message.setText("Dear "+name+",\n\n This is a confirmation of you visiting our hospital for "+purpose+".\n\n If this is not you, please inform hospital to update your contact details.\n\n Stay up to date with our latest reminder service.");
            Transport.send(message);
            
        }
        catch(MessagingException e){
            System.out.println("--->"+e.getMessage());
        }
        catch(Exception e){
            System.out.println("--->"+e.getMessage());
        }
    }
}