package com.khmoon.recyclerview_swipe3.UTILS;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.khmoon.recyclerview_swipe3.R;

public class CustomDialog {
    private Context context;
    private String svrip = "";

    public CustomDialog(Context context) {
        this.context = context;
    }

    public String  callFunction() {

        final Dialog dlg = new Dialog(context);
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dlg.setContentView(R.layout.dialog_custom_1);
        dlg.setCancelable(false);
        dlg.show();
        final EditText sIP = (EditText) dlg.findViewById(R.id.ed_serverip);
        final Button okButton = (Button) dlg.findViewById(R.id.okButton1);
        final Button cancelButton = (Button) dlg.findViewById(R.id.cancelButton1);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                svrip = sIP.getText().toString();
                dlg.dismiss();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                svrip = "";
                dlg.dismiss();
            }
        });
        return svrip;
    }
}
