package com.burnweb.rnwebview;

import android.util.Log;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/**
 * Created by joeykamsteeg on 26/01/2018.
 */

public class PostMessageEvent extends Event<PostMessageEvent>{

    public static final String EVENT_NAME = "postMessage";

    private final String message;

    public PostMessageEvent( int viewId, String message ){
        super( viewId );

        this.message = message;
    }

    @Override
    public String getEventName() {
        return "postMessage";
    }

    @Override
    public void dispatch(RCTEventEmitter rctEventEmitter) {
        rctEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
    }

    private WritableMap serializeEventData(){
        Log.d("ReactNativeJS", this.message );
        WritableMap eventData = Arguments.createMap();
        eventData.putString("data", this.message );
        return eventData;
    }
}
