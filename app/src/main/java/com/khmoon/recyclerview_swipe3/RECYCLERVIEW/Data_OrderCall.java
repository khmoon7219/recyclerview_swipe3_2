package com.khmoon.recyclerview_swipe3.RECYCLERVIEW;

public class Data_OrderCall {
    private int id;
    private int iTable;
    private int iNumber;

    public Data_OrderCall(int id, int iTable, int iNumber) {
        this.id = id;
        this.iTable = iTable;
        this.iNumber = iNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getiTable() {
        return iTable;
    }

    public void setiTable(int iTable) {
        this.iTable = iTable;
    }

    public int getiNumber() {
        return iNumber;
    }

    public void setiNumber(int iNumber) {
        this.iNumber = iNumber;
    }

    /*******   완성되지 않음 사용하지 말것 ***
     목적: order 및 call 시 화면에 뿌려줄 자료를 만들고자 함.

     ***************************************/

}
