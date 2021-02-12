package com.rncamerabridge;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.util.Log;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import javax.annotation.Nullable;

public class CameraModule extends ReactContextBaseJavaModule {
    static final int REQUEST_IMAGE_CAPTURE = 1;
    Activity activity;
    ReactContext context;
    public CameraModule(ReactApplicationContext reactContext){
        super(reactContext);
        this.activity = reactContext.getCurrentActivity();
        context = reactContext;
    }

    @Override
    public String getName() {
        return "CameraModule";
    }
    @ReactMethod
    public void onClick() {
        ReactApplicationContext context = getReactApplicationContext();
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if(cameraIntent.resolveActivity(context.getPackageManager()) !=null) {
            context.startActivity(cameraIntent);
        }
    }

    @ReactMethod
    public void sendEvent(){
        WritableMap params = Arguments.createMap();
        params.putString("eventProperty", "someValue");

        getReactInstanceManager().getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit("customEventName",params);
    }
}
