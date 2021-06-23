package com.khmoon.recyclerview_swipe3.DB;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class DB_Store {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private int nnStore;
    private int nnStore_list;
    private String ssStoreName;
    private String ssStore_pass;
    private String ssStore_remark;

    public DB_Store(int nnStore, int nnStore_list, String ssStoreName, String ssStore_pass, String ssStore_remark) {
        this.nnStore = nnStore;
        this.nnStore_list = nnStore_list;
        this.ssStoreName = ssStoreName;
        this.ssStore_pass = ssStore_pass;
        this.ssStore_remark = ssStore_remark;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getNnStore() { return nnStore; }
    public void setNnStore(int nnStore) { this.nnStore = nnStore; }

    public int getNnStore_list() { return nnStore_list; }
    public void setNnStore_list(int nnStore_list) { this.nnStore_list = nnStore_list; }

    public String getSsStoreName() { return ssStoreName; }
    public void setSsStoreName(String ssStoreName) { this.ssStoreName = ssStoreName; }

    public String getSsStore_pass() { return ssStore_pass; }
    public void setSsStore_pass(String ssStore_pass) { this.ssStore_pass = ssStore_pass; }

    public String getSsStore_remark() { return ssStore_remark; }

    public void setSsStore_remark(String ssStore_remark) { this.ssStore_remark = ssStore_remark; }

    @Override
    public String toString() {
        return "DB_Store{" +
                "id=" + id +
                ", nnStore=" + nnStore +
                ", nnStore_list=" + nnStore_list +
                ", ssStoreName='" + ssStoreName + '\'' +
                ", ssStore_pass='" + ssStore_pass + '\'' +
                ", ssStore_remark='" + ssStore_remark + '\'' +
                '}';
    }
}
