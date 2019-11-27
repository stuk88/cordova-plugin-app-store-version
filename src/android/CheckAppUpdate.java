package com.kharryman.appupdate;

import android.app.Activity;
import android.Manifest;
import android.util.Log;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.concurrent.ExecutionException;

public class CheckAppUpdate extends CordovaPlugin {
    public static final String TAG = "CheckAppUpdate";
    private static final String LOG_TAG = "AppUpdate";

    @Override

    public boolean execute(String action, String packageName, CallbackContext callbackContext)
            throws JSONException {

        if (action.equals("checkAppUpdate")) {
            VersionChecker versionChecker = new VersionChecker();
          try {
            Log.d(LOG_TAG, "checkAppUpdate PACKAGE NAME=" + packageName);
            String latestVersion = versionChecker.execute(packageName).get();
            Log.d(LOG_TAG, "LATEST VERSION SUCCESS = " + latestVersion);
            callbackContext.success(latestVersion);
          } catch (InterruptedException e) {
            e.printStackTrace();
          } catch (ExecutionException e) {
            e.printStackTrace();
            Log.d(LOG_TAG, "GET LATEST VERSION ERROR = " + e.getMessage());
            callbackContext.error("GET LATEST VERSION ERROR = " + e.getMessage());
          }
        }else {
          callbackContext.error("no such method: " + action);
        }
        return false;
    }
}
