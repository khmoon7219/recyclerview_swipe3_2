package com.khmoon.recyclerview_swipe3.DB;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DaoOrder {

    @Query("SELECT * FROM DB_Order order by id")
    List<DB_Order> getAll();

    @Query("SELECT * FROM DB_Order WHERE nnNumber = :number")
    DB_Order getOrder(int number);

    @Query("SELECT count(*) FROM DB_Order")
    int rowCount();

    @Query("SELECT MAX(dtTime) FROM DB_Order")
    String getMaxDt();

    @Query("SELECT EXISTS (SELECT * FROM DB_Order WHERE nnNumber = :number)")
    int isDataExist(int number);

    @Query("SELECT count(*) FROM DB_Order WHERE nnNumber = :number and nnTable = :table")
    int isCompareExist(int number, int table);

    @Query("SELECT EXISTS (SELECT * FROM DB_Order)")
    int isNotEmpty();

    @Insert
    void insert(DB_Order... db_orders);

    @Query("INSERT INTO DB_Order (nnStore, nnTable, nnNumber) VALUES (:store, :table, :number)")
    void insertOrder(int store, int table, int number);

//    @Delete
//    void delete(DB_Order db_order);

    //delete Number
    @Query("DELETE FROM DB_Order WHERE nnNumber = :number")
    void delete(int number);

    @Query("DELETE FROM db_order")
    void deleteAll();
}
