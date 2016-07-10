package com.jalaj.firstapp.listwithmenu.adapter;

import android.content.Context;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jalaj.firstapp.listwithmenu.Contact;
import com.jalaj.firstapp.listwithmenu.R;

import java.util.ArrayList;

/**
 * Created by jalajmehta on 7/10/16.
 */

public class ContactListAdapter extends BaseAdapter implements View.OnCreateContextMenuListener {

    ArrayList<Contact> arrayList;
    LayoutInflater layoutInflater;
    private TextView nameTextView;
    private TextView phoneTextView;

    public ContactListAdapter(ArrayList<Contact> arrayList, Context ctx) {
        this.arrayList = arrayList;
        layoutInflater = LayoutInflater.from(ctx);


    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = layoutInflater.inflate(R.layout.layout_textview,parent,false);

        nameTextView = (TextView)convertView.findViewById(R.id.txtName);
        phoneTextView = (TextView)convertView.findViewById(R.id.txtPhoneNo);
        nameTextView.setText(arrayList.get(position).getName());
        phoneTextView.setText(arrayList.get(position).getPhone());
        Log.d("I must be here","I must be here!");
        convertView.setOnCreateContextMenuListener(this);
        return convertView;
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
      // super.onCreateContextMenu(menu, v, menuInfo);


        menu.setHeaderTitle("Select Action");
        menu.add(1,101,1,"Call");
        menu.add(1,102,1,"SMS");


    }
}

