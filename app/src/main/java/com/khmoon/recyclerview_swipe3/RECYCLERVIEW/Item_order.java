package com.khmoon.recyclerview_swipe3.RECYCLERVIEW;

import android.graphics.Color;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.ForegroundColorSpan;

import com.khmoon.recyclerview_swipe3.MainActivity;

public class Item_order {
    private int nNumber = 0;
    private int nTable = 0;
    private int isOrderCall = 0;


    public Item_order(int OrderCall , int nTable, int nNumber) {
        this.isOrderCall = OrderCall;
        this.nNumber = nNumber;
        this.nTable = nTable;
    }

    public SpannableStringBuilder getItemText() {
        SpannableStringBuilder itemText = insertOrderButton(""+ this.nTable, ""+ this.nNumber);

        return itemText;
    }

    private SpannableStringBuilder insertOrderButton(String s1, String s2) {
//        SpannableStringBuilder ssb = new SpannableStringBuilder(s1 +"\n" + s2);

        SpannableStringBuilder ssb = new SpannableStringBuilder(s2);
        Color callColor = Color.valueOf(0xFFFF9800);
        ssb.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER), 0, s2.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        ssb.setSpan(new AbsoluteSizeSpan(80), 0, s2.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);

//        if (MainActivity.isWidthMode == true) {
//            ssb.setSpan(new AbsoluteSizeSpan(80), 0, s2.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
//        } else {
//            ssb.setSpan(new AbsoluteSizeSpan(70), 0, s2.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
//        }

        if (isOrderCall == MainActivity.CONTENT_CALL ) {
            ssb.setSpan(new ForegroundColorSpan(callColor.toArgb()), 0, s2.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        } else {
            ssb.setSpan(new ForegroundColorSpan(Color.WHITE), 0, s2.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        }

        return ssb;
    }

    public int getnNumber() { return nNumber; }
    public void setnNumber(int nNumber) { this.nNumber = nNumber; }

    public int getnTable() { return nTable; }
    public void setnTable(int nTable) { this.nTable = nTable; }

    public int getIsOrderCall() { return isOrderCall; }
    public void setIsOrderCall(int isOrderCall) { this.isOrderCall = isOrderCall; }

    @Override
    public String toString() {
        return "Item_order{" +
                "nNumber=" + nNumber +
                ", nTable=" + nTable +
                ", isOrderCall=" + isOrderCall +
                '}';
    }
}
