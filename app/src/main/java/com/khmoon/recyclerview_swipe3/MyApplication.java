package com.khmoon.recyclerview_swipe3;

import android.app.Application;

public class MyApplication extends Application {
    //    private boolean isClickedOrder = false;
//    private int iClickedOrder;
    private static MyApplication instance = null;
    //    private int nOrder;
//    private int nCall;
    private String sSN;
    private int nPlayerNo;
    private String sStoreName;
    private String serverIP;
    private String myIP;
    private String modelName;
    private int nVolume;
    private String ssHallMode;
    private int nStore;
    private int nWidth;
    private int nHeight;
    private int nOrderNo;
    private int nCallNo;
    private String sOrderDT;
    private String sCallDT;
    private int clickMode;

    @Override
    public void onCreate() {
        super.onCreate();

//        this.isClickedOrder = false;
//        this.iClickedOrder = 0;
//        this.nOrder = 0;
//        this.nCall = 0;
        this.sSN = "";
        this.sStoreName = "";
        this.nPlayerNo = 0;
        this.serverIP = "http://59.8.46.164:8078/DID/json/";
        this.serverIP = "";
        this.myIP = "";
        this.modelName = "";
        this.nVolume = 0;
        this.ssHallMode = "N";
        this.nStore = 0;
        this.nWidth = 0;
        this.nHeight = 0;
        this.nOrderNo = 0;
        this.nCallNo = 0;
        this.sOrderDT = "0000-00-00 00:00:00";
        this.sCallDT = "0000-00-00 00:00:00";
        this.clickMode = 1;
    }

    public static synchronized MyApplication getInstance(){
        if(null == instance){
            instance = new MyApplication();
        }
        return instance;
    }

//    public boolean isClickedOrder() { return isClickedOrder; }
//    public void setClickedOrder(boolean clickedOrder) { isClickedOrder = clickedOrder; }
//
//    public int getiClickedOrder() { return iClickedOrder; }
//    public void setiClickedOrder(int iClickedOrder) { this.iClickedOrder = iClickedOrder; }

//    public int getnOrder() { return nOrder; }
//    public void setnOrder(int nOrder) { this.nOrder = nOrder; }
//
//    public int getnCall() { return nCall; }
//    public void setnCall(int nCall) { this.nCall = nCall; }

    public String getsSN() { return sSN; }
    public void setsSN(String sSN) { this.sSN = sSN; }

    public int getnPlayerNo() { return nPlayerNo; }
    public void setnPlayerNo(int nPlayerNo) { this.nPlayerNo = nPlayerNo; }

    public String getsStoreName() { return sStoreName; }
    public void setsStoreName(String sStoreName) { this.sStoreName = sStoreName; }

    public String getServerIP() { return serverIP; }
    public void setServerIP(String serverIP) { this.serverIP = serverIP; }

    public String getMyIP() { return myIP; }
    public void setMyIP(String myIP) { this.myIP = myIP; }

    public String getModelName() { return modelName; }
    public void setModelName(String modelName) { this.modelName = modelName; }

    public int getnVolume() { return nVolume; }
    public void setnVolume(int nVolume) { this.nVolume = nVolume; }

    public String getSsHallMode() { return ssHallMode; }
    public void setSsHallMode(String ssHallMode) { this.ssHallMode = ssHallMode; }

    public int getnStore() { return nStore; }
    public void setnStore(int nStore) { this.nStore = nStore; }

    public int getnWidth() { return nWidth; }
    public void setnWidth(int nWidth) { this.nWidth = nWidth; }

    public int getnHeight() { return nHeight; }
    public void setnHeight(int nHeight) { this.nHeight = nHeight; }

    public int getnOrderNo() { return nOrderNo; }
    public void setnOrderNo(int nOrderNo) { this.nOrderNo = nOrderNo; }

    public int getnCallNo() { return nCallNo; }
    public void setnCallNo(int nCallNo) { this.nCallNo = nCallNo; }

    public String getsOrderDT() {
        return sOrderDT;
    }
    public void setsOrderDT(String sOrderDT) {
        this.sOrderDT = sOrderDT;
    }

    public String getsCallDT() {
        return sCallDT;
    }
    public void setsCallDT(String sCallDT) {
        this.sCallDT = sCallDT;
    }

    public int getClickMode() { return clickMode; }
    public void setClickMode(int clickMode) { this.clickMode = clickMode; }

    @Override
    public String toString() {
        return "MyApplication{" +
                "sSN='" + sSN + '\'' +
                ", nPlayerNo=" + nPlayerNo +
                ", sStoreName='" + sStoreName + '\'' +
                ", serverIP='" + serverIP + '\'' +
                ", myIP='" + myIP + '\'' +
                ", modelName='" + modelName + '\'' +
                ", nVolume=" + nVolume +
                ", ssHallMode='" + ssHallMode + '\'' +
                ", nStore=" + nStore +
                ", nWidth=" + nWidth +
                ", nHeight=" + nHeight +
                ", nOrderNo=" + nOrderNo +
                ", nCallNo=" + nCallNo +
                ", sOrderDT='" + sOrderDT + '\'' +
                ", sCallDT='" + sCallDT + '\'' +
                ", clickMode=" + clickMode +
                '}';
    }
}
