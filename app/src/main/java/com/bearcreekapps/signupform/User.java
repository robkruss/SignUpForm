package com.bearcreekapps.signupform;

import java.io.Serializable;

/**
 * Created by Rob on 2/6/2015.
 */
public class User implements Serializable {

    private String mUsername;
    private String mPassword;

    User(String username, String password){
        mUsername = username;
        mPassword = password;
    }

    public String getUsername(){
        return mUsername;
    }
}
