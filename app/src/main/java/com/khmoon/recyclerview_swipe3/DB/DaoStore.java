package com.khmoon.recyclerview_swipe3.DB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DaoStore {
    @Query("SELECT * FROM DB_Store order by id")
    List<DB_Store> getAll();

    @Query("SELECT ssStoreName FROM DB_Store")
    String[] getStoreNames();

    @Query("SELECT nnStore FROM DB_Store WHERE ssStoreName = :storeName")
    int getStoreNo(String storeName);

    @Query("SELECT ssStore_pass FROM DB_Store WHERE nnStore = :nStore")
    String getStorePW(int nStore);

    @Query("SELECT count(*) FROM DB_Store")
    int rowCount();

    @Query("SELECT EXISTS (SELECT * FROM DB_Store WHERE ssStoreName = :storeName)")
    int isDataExist(String storeName);

    @Query("SELECT EXISTS (SELECT * FROM DB_Store)")
    int isNotEmpty();

    @Insert
    void insert(DB_Store... db_stores);

    @Query("INSERT INTO DB_Store (nnStore, nnStore_list, ssStoreName, ssStore_pass, ssStore_remark) " +
            "VALUES (:nStore, :nStoreList, :sStoreName, :sStorePass, :sStoreRemark)")
    void insertOrder(int nStore, int nStoreList, String sStoreName, String sStorePass, String sStoreRemark);

    //delete Number
    @Query("DELETE FROM DB_Store WHERE ssStoreName = :storeName")
    void delete(String storeName);

    @Query("DELETE FROM DB_Store")
    void deleteAll();

}
