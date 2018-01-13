package com.elmahask.wael.listviewadaptercoffee;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class TopMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_top);
        AdapterView.OnItemClickListener item = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(TopMainActivity.this, DrinkCategoryActivity.class);

                    startActivity(intent);
                } else if (position == 1) {
                    Intent intent = new Intent(TopMainActivity.this, DrinkCategoryActivity.class);
                    startActivity(intent);
                } else if (position == 2) {
                    Intent intent = new Intent(TopMainActivity.this, DrinkCategoryActivity.class);
                    startActivity(intent);
                }else if (position == 3) {
                    Intent intent = new Intent(TopMainActivity.this, DrinkCategoryActivity.class);
                    startActivity(intent);
                }else if (position == 4) {
                    Intent intent = new Intent(TopMainActivity.this, DrinkCategoryActivity.class);
                    startActivity(intent);
                }else if (position == 5) {
                    Intent intent = new Intent(TopMainActivity.this, DrinkCategoryActivity.class);
                    startActivity(intent);
                }else if (position == 6) {
                    Intent intent = new Intent(TopMainActivity.this, DrinkCategoryActivity.class);
                    startActivity(intent);
                }else if (position == 7) {
                    Intent intent = new Intent(TopMainActivity.this, DrinkCategoryActivity.class);
                    startActivity(intent);
                }else if (position == 8) {
                    Intent intent = new Intent(TopMainActivity.this, DrinkCategoryActivity.class);
                    startActivity(intent);
                }else if (position == 9) {
                    Intent intent = new Intent(TopMainActivity.this, DrinkCategoryActivity.class);
                    startActivity(intent);
                }
            }

        };
        ListView list = (ListView) findViewById(R.id.list_options);
        list.setOnItemClickListener(item);
    }
}
