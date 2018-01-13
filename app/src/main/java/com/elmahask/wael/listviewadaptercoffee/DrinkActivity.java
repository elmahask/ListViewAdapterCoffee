package com.elmahask.wael.listviewadaptercoffee;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DrinkActivity extends AppCompatActivity {

    public static final String EXTRA_DRINKO = "drinkNO";
    private SQLiteOpenHelper dbHelper;
    private SQLiteDatabase dB;
    private Cursor cR,wR;
    private ImageView image;
    private TextView name;
    private TextView desc;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        int drinkno = (Integer) getIntent().getExtras().get(EXTRA_DRINKO);
        dbHelper = new DBHelper(this);

        try {

            dB = dbHelper.getReadableDatabase();
            cR = dB.query("DRINK", new String[]{"NAME", "DESCRIPTION", "IMAGE_RESOURCE_ID"},
                    "_id=?",
                    new String[]{Integer.toString(drinkno)},
                    null, null, null);
//            wR = dB.query("WATER", new String[]{"NAME", "DESCRIPTION", "IMAGE_RESOURCE_ID"},
//                    "_id=?",
//                    new String[]{Integer.toString(drinkno)},
//                    null, null, null);

            if (cR.moveToFirst()) {

                String nameText = cR.getString(0);
                String DescText = cR.getString(1);
                int ImageId = cR.getInt(2);

                image = findViewById(R.id.photo);
                image.setImageResource(ImageId);
                image.setContentDescription(nameText);

                name = findViewById(R.id.name);
                name.setText(nameText);

                desc = findViewById(R.id.desc);
                desc.setText(DescText);
            }
            cR.close();
            dB.close();
        } catch (Exception e) {
            toast = Toast.makeText(this, "DB ERROR", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
