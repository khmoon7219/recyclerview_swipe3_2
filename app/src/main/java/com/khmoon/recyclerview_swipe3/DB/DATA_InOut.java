package com.khmoon.recyclerview_swipe3.DB;

public class DATA_InOut {
    private String ssTableName;
    private String ssAction;
    private String dtAction;
    private int nnNumber;
    private int nnStore;
    private String dt;


    public DATA_InOut(String ssTableName, String ssAction, String dtAction, int nnNumber, int nnStore, String dt) {
        this.ssTableName = ssTableName;
        this.ssAction = ssAction;
        this.dtAction = dtAction;
        this.nnNumber = nnNumber;
        this.nnStore = nnStore;
        this.dt = dt;
    }

    public String getSsTableName() { return ssTableName; }
    public void setSsTableName(String ssTableName) { this.ssTableName = ssTableName; }

    public String getSsAction() { return ssAction; }
    public void setSsAction(String ssAction) { this.ssAction = ssAction; }

    public String getDtAction() { return dtAction; }
    public void setDtAction(String dtAction) { this.dtAction = dtAction; }

    public int getNnNumber() { return nnNumber; }
    public void setNnNumber(int nnNumber) { this.nnNumber = nnNumber; }

    public int getNnStore() { return nnStore; }
    public void setNnStore(int nnStore) { this.nnStore = nnStore; }

    public String getDt() { return dt; }
    public void setDt(String dt) { this.dt = dt; }

    @Override
    public String toString() {
        return "DATA_InOut{" +
                "ssTableName='" + ssTableName + '\'' +
                ", ssAction='" + ssAction + '\'' +
                ", dtAction='" + dtAction + '\'' +
                ", nnNumber=" + nnNumber +
                ", nnStore=" + nnStore +
                ", dt='" + dt + '\'' +
                '}';
    }
}
