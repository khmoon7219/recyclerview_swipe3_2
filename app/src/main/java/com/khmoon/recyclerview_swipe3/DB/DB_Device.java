package com.khmoon.recyclerview_swipe3.DB;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class DB_Device {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String ssSN;  // 시리얼번호
    private int nnPlayerNo; // 기기번호
    private String ssServerIP;
    private String ssMyIP;
    private String ssStoreName;
    private int nnStore;
    private String ssHallMode;
    private int nnVolume;
    private int nnWidth;
    private int nnHeight;
    private String ssModel;
    private int clickMode;

    public DB_Device(String ssSN, int nnPlayerNo, String ssServerIP, String ssMyIP,
                     String ssStoreName, int nnStore, String ssHallMode, int nnVolume,
                     int nnWidth, int nnHeight, String ssModel, int clickMode) {

        this.ssSN = ssSN;
        this.nnPlayerNo = nnPlayerNo;
        this.ssServerIP = ssServerIP;
        this.ssMyIP = ssMyIP;
        this.ssStoreName = ssStoreName;
        this.nnStore = nnStore;
        this.ssHallMode = ssHallMode;
        this.nnVolume = nnVolume;
        this.nnWidth = nnWidth;
        this.nnHeight = nnHeight;
        this.ssModel = ssModel;
        this.clickMode = clickMode;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getSsSN() { return ssSN; }
    public void setSsSN(String ssSN) { this.ssSN = ssSN; }

    public int getNnPlayerNo() { return nnPlayerNo; }
    public void setNnPlayerNo(int nnPlayerNo) { this.nnPlayerNo = nnPlayerNo; }

    public String getSsServerIP() { return ssServerIP; }
    public void setSsServerIP(String ssServerIP) { this.ssServerIP = ssServerIP; }

    public String getSsHallMode() { return ssHallMode; }
    public void setSsHallMode(String ssHallMode) { this.ssHallMode = ssHallMode; }

    public String getSsMyIP() { return ssMyIP; }
    public void setSsMyIP(String ssMyIP) { this.ssMyIP = ssMyIP; }

    public String getSsModel() { return ssModel; }
    public void setSsModel(String ssModel) { this.ssModel = ssModel; }

    public String getSsStoreName() { return ssStoreName; }
    public void setSsStoreName(String ssStoreName) { this.ssStoreName = ssStoreName; }

    public int getNnStore() { return nnStore; }
    public void setNnStore(int nnStore) { this.nnStore = nnStore; }

    public int getNnVolume() { return nnVolume; }
    public void setNnVolume(int nnVolume) { this.nnVolume = nnVolume; }

    public int getNnWidth() { return nnWidth; }
    public void setNnWidth(int nnWidth) { this.nnWidth = nnWidth; }

    public int getNnHeight() { return nnHeight; }
    public void setNnHeight(int nnHeight) { this.nnHeight = nnHeight; }

    public int getClickMode() {
        return clickMode;
    }

    public void setClickMode(int clickMode) {
        this.clickMode = clickMode;
    }

    @Override
    public String toString() {
        return "DB_Device{" +
                "id=" + id +
                ", ssSN='" + ssSN + '\'' +
                ", nnPlayerNo=" + nnPlayerNo +
                ", ssServerIP='" + ssServerIP + '\'' +
                ", ssMyIP='" + ssMyIP + '\'' +
                ", ssStoreName='" + ssStoreName + '\'' +
                ", nnStore=" + nnStore +
                ", ssHallMode='" + ssHallMode + '\'' +
                ", nnVolume=" + nnVolume +
                ", nnWidth=" + nnWidth +
                ", nnHeight=" + nnHeight +
                ", ssModel='" + ssModel + '\'' +
                ", clickMode=" + clickMode +
                '}';
    }
}
