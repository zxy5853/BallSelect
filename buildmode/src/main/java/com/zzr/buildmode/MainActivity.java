package com.zzr.buildmode;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.zzr.buildmode.upgrade.Client;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Client client = new Client();
        client.startBuildHouse();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("djfkldj");
        builder.setMessage("aaaaaaaaaaaaaaa");
        builder.setNegativeButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
//        builder.create();
        builder.show();

    }
}
