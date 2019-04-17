package com.example.myapplication.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AppUtility {

    static DisplayMetrics metrics = new DisplayMetrics();

    public static int getDeviceVersion(){
        int currentVer = android.os.Build.VERSION.SDK_INT;
        return currentVer;
    }

    //get device height and width in pixels
    public static int getDeviceWidthPixels(Activity activity) {
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int heightPixels = metrics.heightPixels;
        return heightPixels;
    }

    public static int getDeviceHeightPixels(Activity activity) {
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int widthPixels = metrics.widthPixels;
        return widthPixels;
    }
    public static float getDeviceHeightDpi(Activity activity) {
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        float xdpi = metrics.xdpi;
        return xdpi;
    }

    public static float getDeviceWidthDpi(Activity activity) {
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int widthPixels = metrics.widthPixels;
        return widthPixels;
    }

    public static boolean isInternetAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        boolean connected;
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null) {
            // connected to the internet
            connected = true;
        }
        else{
            connected = false;
        }
        return connected;
    }

    public static String convertStringDate(String stringdate, String inputFormat, String outFormat) {

        String strDateTime = "";
        try {
            DateFormat inputFormatter = new SimpleDateFormat(inputFormat, Locale.getDefault());
            Date da = (Date) inputFormatter.parse(stringdate);
//            System.out.println("==Date is ==" + da);

            DateFormat outputFormatter = new SimpleDateFormat(outFormat, Locale.getDefault());
            strDateTime = outputFormatter.format(da);
//            System.out.println("==String date is : " + strDateTime);
            return strDateTime;
        } catch (ParseException e) {
            e.printStackTrace();

        }
        return strDateTime;

    }
}
