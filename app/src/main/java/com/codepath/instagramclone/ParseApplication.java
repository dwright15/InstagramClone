package com.codepath.instagramclone;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ParseObject.registerSubclass(Post.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("david-instagram-clone-codepath") // should correspond to APP_ID env variable
                .clientKey("instagramCodepath")  // set explicitly unless clientKey is explicitly configured on Parse server
                .server("http://david-instagram-clone-codepath.herokuapp.com/parse").build());
    }
}
