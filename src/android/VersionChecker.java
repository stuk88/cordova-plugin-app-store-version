package com.kharryman.appupdate;

import android.util.Log;
import org.jsoup.Jsoup;
import java.io.IOException;

public class VersionChecker extends AsyncTask<String, String, String> {

  String newVersion;
  private static final String LOG_TAG = "AppUpdate";

  @Override
  protected String doInBackground(String... params) {
    String packageName = params[0];
    String pattern = "[^A-Za-z.]";
    packageName = packageName.replaceAll(pattern, "");
    Log.d(LOG_TAG, "PASSED PACKAGE NAME REPLACED=" + packageName);
    try {
      String url = "https://play.google.com/store/apps/details?id=" + packageName + "&hl=en";
      Log.d(LOG_TAG, "GET LATEST URL = " + url);
      newVersion = Jsoup.connect(url)
        .timeout(30000)
        .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
        .referrer("http://www.google.com")
        .get()
        .select(".hAyfc .htlgb")
        .get(7)
        .ownText();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return newVersion;
  }

}
