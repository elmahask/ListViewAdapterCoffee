package com.elmahask.wael.listviewadaptercoffee;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by elmahask on 12/8/17.
 */
public class AdapterList extends CursorAdapter {
    public AdapterList(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }
    // The newView method is used to inflate a new view and return it,
    // you don't bind any data to the view at this point.
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView name = (TextView) view.findViewById(R.id.select);
        TextView desc = (TextView) view.findViewById(R.id.desc);
        ImageView image = (ImageView) view.findViewById(R.id.image);

        String namee = cursor.getString(cursor.getColumnIndexOrThrow("NAME"));
        String descr = cursor.getString(cursor.getColumnIndexOrThrow("DESCRIPTION"));

        name.setText(namee);
        desc.setText(descr);
        image.setImageResource(cursor.getInt(cursor.getColumnIndexOrThrow("IMAGE_RESOURCE_ID")));
    }
}

