/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source.userAccount;

import java.util.ArrayList;

/**
 *
 * @author GaurangDeshpande
 */
public class UserAccountDirectory {
    private ArrayList<UserAccount> userAccountList;

    public UserAccountDirectory() {
        userAccountList = new ArrayList<>();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }
    
    public UserAccount authenticateUser(String username, String password){
        for(UserAccount userAccout:userAccountList)
            if(userAccout.getUsername().equals(username) && userAccout.getPassword().equals(password)){
                return userAccout;
            }
        return null;
    }
    
    public UserAccount createUserAccount(){
        UserAccount userAccount = new UserAccount();
        userAccountList.add(userAccount);
        return userAccount;
    }
    
    public boolean checkIfUsernameIsUnique(String username){
        for(UserAccount ua:userAccountList){
            if(ua.getUsername().equals(username))
                return false;
        }
        return true;
    }
}