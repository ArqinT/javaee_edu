/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ntdev.security;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MyMatcher implements CredentialsMatcher{

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MyMatcher.class);
    
    @Override
    public boolean doCredentialsMatch(AuthenticationToken at, AuthenticationInfo ai) {
                                   
        char[] cred = (char[])at.getCredentials();            
        String passFromForm = String.valueOf(cred);
        String passFromDB = (String) ai.getCredentials();
        Md5Hash passFromFormHash = new Md5Hash(passFromForm);
        
        logger.info("Password from form(hashed) "+passFromFormHash.toString());
        logger.info("Password from DB(row) "+passFromDB);
        
        return passFromDB.equals(passFromFormHash.toString());
    }
}
