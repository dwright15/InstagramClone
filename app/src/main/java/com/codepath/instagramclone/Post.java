package com.codepath.instagramclone;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("Post")
public class Post extends ParseObject {
public static final String KEY_DESCIRIPTION = "description";
public static final String KEY_USER = "user";
public static final String KEY_IMAGE = "image";

public String getKeyDesciription(){
    return getString(KEY_DESCIRIPTION);
    }
 public void setDesciription(String description){
    put(KEY_DESCIRIPTION, description);
 }

 public ParseFile getKeyImage(){
    return getParseFile(KEY_IMAGE);
 }

 public void setKeyImage(ParseFile image){
    put(KEY_IMAGE, image);
 }

 public ParseUser getKeyUser(){
    return getParseUser(KEY_USER);
 }

 public void setKeyUser(ParseUser user){
    put(KEY_USER, user);
 }


}
