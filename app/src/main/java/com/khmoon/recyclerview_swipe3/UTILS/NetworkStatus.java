package com.khmoon.recyclerview_swipe3.UTILS;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkStatus {
    public static final int TYPE_WIFI = 1;
    public static final int TYPE_MOBILE = 2;
    public static final int TYPE_NOT_CONNECTED = 3;
    public static final int TYPE_ETHERNET = 4;
    public static final int TYPE_WIMAX = 5;

    //해당 context의 서비스를 사용하기위해서 context객체를 받는다.
    public static int getConnectivityStatus(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if (networkInfo != null) {
            int type = networkInfo.getType();


            if (type == ConnectivityManager.TYPE_MOBILE) {      // 3G or 4G로 연결된 것(모바일을 뜻함.)
                return TYPE_MOBILE;
            } else if (type == ConnectivityManager.TYPE_WIFI) {  // WIFI 로 연결된 것
                return TYPE_WIFI;
            } else if (type == ConnectivityManager.TYPE_ETHERNET) {  // 이더넷으로 연결된 것
                return TYPE_ETHERNET;
            } else if (type == ConnectivityManager.TYPE_WIMAX) { // WIFI 단점을 보완한 향상된 WIFI 네트워크 유형
                return TYPE_WIMAX;
            }
        }
        return  TYPE_NOT_CONNECTED;
    }
}
