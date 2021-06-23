package com.khmoon.recyclerview_swipe3.DB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DaoCall {

    @Query("SELECT * FROM DB_Call ORDER BY id")
    List<DB_Call> getAll();

    @Query("SELECT * FROM DB_Call WHERE nnNumber = :number")
    DB_Call getCall(int number);

    @Query("SELECT count(*) FROM DB_Call")
    int rowCount();

    @Query("SELECT MAX(dtTime) FROM DB_Call")
    String getMaxDt();

    @Query("SELECT EXISTS (SELECT * FROM DB_Call WHERE nnNumber = :number)")
    int isDataExist(int number);

    @Query("SELECT count(*) FROM DB_Call WHERE nnNumber = :number and nnTable = :table")
    int isCompareExist(int number, int table);

    @Query("SELECT EXISTS (SELECT * FROM DB_Call)")
    int isNotEmpty();

    @Insert
    void insert(DB_Call... db_calls);

//    @Delete
//    void delete(DB_Call db_call);

    @Query("DELETE FROM DB_Call WHERE nnNumber = :number")
    void delete(int number);

    @Query("DELETE FROM DB_Call")
    void deleteAll();
}
