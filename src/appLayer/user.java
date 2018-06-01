package appLayer;

import dataLayer.DB_user;

public class user {

    public boolean isValidUserCredentials(String sUsername, String sUserPassword){
        DB_user user = new DB_user();
        return user.isValidUserLogin(sUsername,sUserPassword);
    }

    public void register(String sUsername, String sUserPassword){
        DB_user user = new DB_user();
        user.register(sUsername, sUserPassword);
    }
}
