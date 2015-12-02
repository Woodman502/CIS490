package joeconnornick.cis490.chatapp;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by Joe Woodcox on 12/2/2015.
 */
public class ChatApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "s0f5UeOgUnnhFNsjsiPlh1nhaklHA1PWg42gpd2s", "0TSxQ3HEBaeyOccNALH38hl7erVPZXAIlzerVxRt");
    }
}
