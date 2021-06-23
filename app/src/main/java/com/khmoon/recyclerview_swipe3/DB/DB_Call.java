package com.khmoon.recyclerview_swipe3.DB;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class DB_Call {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private int nnStore;
    private int nnTable;
    private int nnNumber;
    private String dtTime;

    public DB_Call(int nnStore, int nnTable, int nnNumber, String dtTime) {
        this.nnStore = nnStore;
        this.nnTable = nnTable;
        this.nnNumber = nnNumber;
        this.dtTime = dtTime;
    }

//    public DB_Call() {
//        this.nnStore = 0;
//        this.nnTable = 0;
//        this.nnNumber = 0;
//        this.dtTime = "";
//    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getNnTable() { return nnTable; }
    public void setNnTable(int nnTable) { this.nnTable = nnTable; }

    public int getNnNumber() { return nnNumber; }
    public void setNnNumber(int nnNumber) { this.nnNumber = nnNumber; }

    public int getNnStore() { return nnStore; }
    public void setNnStore(int nnStore) { this.nnStore = nnStore; }

    public String getDtTime() { return dtTime; }
    public void setDtTime(String dtTime) { this.dtTime = dtTime; }

    @Override
    public String toString() {
        return "DB_Call{" +
                "id=" + id +
                ", nnStore=" + nnStore +
                ", nnTable=" + nnTable +
                ", nnNumber=" + nnNumber +
                ", dtTime='" + dtTime + '\'' +
                '}';
    }
}
