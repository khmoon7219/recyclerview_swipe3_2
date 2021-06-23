package com.khmoon.recyclerview_swipe3.UTILS;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.khmoon.recyclerview_swipe3.R;
import com.khmoon.recyclerview_swipe3.RECYCLERVIEW.Data_OrderCall;


public class CustomDialogOrder extends Dialog {
    private Context context;
    private int nTable = 0;
    private int nNumber = 0;
    Data_OrderCall dt;

    public interface ICustomDialogEventListener {
        public void customDialogEvent(int iTable, int iNumber);
    }

    private ICustomDialogEventListener onCustomDialogEventListener;

    public CustomDialogOrder(Context context, ICustomDialogEventListener onCustomDialogEventListener) {
        super(context);
        this.context = context;
        this.onCustomDialogEventListener = onCustomDialogEventListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Dialog dlg = new Dialog(context);
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dlg.setContentView(R.layout.dialog_custom_2);
        dlg.setCancelable(false);
//        dlg.show();

        final EditText sTable = (EditText) dlg.findViewById(R.id.ed_table);
        final EditText sNumber = (EditText) dlg.findViewById(R.id.ed_number);
        final Button okButton = (Button) dlg.findViewById(R.id.okButton2);
        final Button cancelButton = (Button) dlg.findViewById(R.id.cancelButton2);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nTable = Integer.valueOf(sTable.getText().toString()) ;
                nNumber = Integer.valueOf(sNumber.getText().toString());

                if (nNumber > 0) {
                    onCustomDialogEventListener.customDialogEvent(nTable, nNumber);
                    dlg.dismiss();
                } else {
                    dlg_message("주문번호 오류", "주문 번호를 확인 후 다시 입력하세요.");
                }
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                dt = null;
                dlg.dismiss();
            }
        });
    }

    private void dlg_message(String title, String message) {
        AlertDialog.Builder adlg = new AlertDialog.Builder(context);
        adlg.setTitle(title)
                .setMessage(message);
        adlg.setPositiveButton("확인", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog alertDialog = adlg.create();
        alertDialog.show();
    }
}
