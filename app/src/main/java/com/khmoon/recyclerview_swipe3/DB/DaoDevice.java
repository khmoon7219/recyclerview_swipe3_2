package com.khmoon.recyclerview_swipe3.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DaoDevice {
    @Query("SELECT * FROM DB_Device ORDER BY id")
    List<DB_Device> getall();

    @Query("SELECT count(*) FROM DB_Device")
    int rowCount();

    @Query("SELECT EXISTS (SELECT * FROM DB_Device)")
    int isNotEmpty();

    @Query("SELECT ssHallMode FROM DB_Device WHERE ssSN = :sSN")
    String isHallMode(String sSN);

    @Query("SELECT nnPlayerNo FROM DB_Device")
    int  getPlayerNo();

    @Query("UPDATE DB_device SET ssHallMode = :hallmode WHERE ssSN = :sSN")
    void updateHallMode(String sSN, String hallmode);

    @Query("UPDATE DB_device SET nnPlayerNo = :nPlayerno, ssSerVerIP = :sServerIP, ssMyIP = :sMyIP, " +
            "ssStoreName = :sStoreName, nnStore = :nStore, ssHallMode = :sHallMode, nnVolume = :nVolume, " +
            "nnWidth = :nWidth, nnHeight = :nHeight, ssModel = :sModel" +
            " WHERE ssSN = :sSN")
    void updateAll(String sSN,int nPlayerno, String sServerIP, String sMyIP, String sStoreName,
                   int nStore, String sHallMode, int nVolume, int nWidth, int nHeight, String sModel);

    @Query("UPDATE DB_device SET ssStoreName = :sStoreName, nnStore = :nStore WHERE ssSN = :sSN")
    void updateStore(String sSN, String sStoreName, int nStore);



    @Insert
    void insertAll(DB_Device... db_devices);

    @Delete
    void delete(DB_Device db_device);

    @Query("DELETE FROM db_device")
    void deleteAll();

}
