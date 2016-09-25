package com.example.administrator.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class ListDialog extends AppCompatActivity implements View.OnClickListener {
    private AlertDialog myDialog = null;
    Button but;
    private ListView listView;
    private ListViewAdapter adapter =null;
    private String[] beans = new String[] { "1", "2", "3", "4", "5", "6", "7",
            "8", "9", "10", "11", "12", "13" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        but = (Button) this.findViewById(R.id.button);
        but.setOnClickListener(this);
        adapter = new ListViewAdapter(ListDialog.this, beans);
    }

    @Override
    public void onClick(View view) {
        myDialog = new AlertDialog.Builder(ListDialog.this).create();
        myDialog.show();
        myDialog.getWindow().setContentView(R.layout.dialog_main);
        listView = (ListView)myDialog.getWindow(). findViewById(R.id.listView1);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        myDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                myDialog.dismiss();
            }
        });
    }

}
