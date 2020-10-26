package com.protegemos.protegemospersonas.data;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

public class Util {

    public Boolean isOnlineNet(Context context) {

        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        RunnableFuture<Boolean> futureRun = new FutureTask<Boolean>(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                if ((networkInfo.isAvailable()) && (networkInfo.isConnected())) {
                    try {
                        HttpURLConnection urlc = (HttpURLConnection) (new URL("http://181.62.161.60").openConnection());
                        urlc.setRequestProperty("User-Agent", "Test");
                        urlc.setRequestProperty("Connection", "close");
                        urlc.setConnectTimeout(1500);
                        urlc.connect();
                        return (urlc.getResponseCode() == 200);
                    } catch (IOException e) {
                        Log.e("", "Error checking internet connection", e);
                    }
                } else {
                    Log.d("", "No network available!");
                }
                return false;
            }
        });

        new Thread(futureRun).start();


        try {
            return futureRun.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return false;
        }
    }



}
