package com.example.myapplication.util;

import android.content.Context;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.Display;
import android.view.WindowManager;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AppUtility {
    private static Point size=new Point();

    public static int getDeviceVersion(){
        int currentVer = android.os.Build.VERSION.SDK_INT;
        return currentVer;
    }

    //get device height and width in pixels
    public static int getDeviceWidth(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
//        int width = display.getWidth(); depricated
        display.getSize(size);
        return size.x;
    }

    public static int getDeviceHeight(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        display.getSize(size);
        return size.y;
    }

    /*
    * // pixels, dpi
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int heightPixels = metrics.heightPixels;
        int widthPixels = metrics.widthPixels;
        int densityDpi = metrics.densityDpi;
        float xdpi = metrics.xdpi;
        float ydpi = metrics.ydpi;
    * */

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
