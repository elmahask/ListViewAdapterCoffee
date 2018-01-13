package com.elmahask.wael.listviewadaptercoffee;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class DrinkCategoryActivity extends AppCompatActivity {
    SQLiteOpenHelper DBHelper;
    SQLiteDatabase dB;
    Cursor cR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        DBHelper = new DBHelper(this);
        final ListView listItem = (ListView) findViewById(R.id.aList_Item);
        try {
            dB = DBHelper.getReadableDatabase();
            cR = dB.query("DRINK",
                    new String[]{"_id", "NAME", "DESCRIPTION", "IMAGE_RESOURCE_ID"},
                    null, null, null, null, null);
            AdapterList todoAdapter = new AdapterList(this, cR);
            listItem.setAdapter(todoAdapter);
        } catch (Exception e) {
            Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        }
        listItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(DrinkCategoryActivity.this, DrinkActivity.class);
                intent.putExtra(DrinkActivity.EXTRA_DRINKO, (int) id);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        cR.close();
        dB.close();
    }
}
