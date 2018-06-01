package appLayer;

import dataLayer.DB_user;

public class user {

    public boolean isValidUserCredentials(String sUsername, String sUserPassword){
        DB_user user = new DB_user();

        return user.isValidUserLogin(sUsername,sUserPassword);
    }
}
