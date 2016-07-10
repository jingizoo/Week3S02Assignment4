package com.jalaj.firstapp.listwithmenu;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.jalaj.firstapp.listwithmenu.adapter.ContactListAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    ArrayList<Contact> contactList;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listNamePhone);

        contactList = new ArrayList<>();
        fillContacts();

       // listView.setOnItemClickListener(this);
        listView.setAdapter(new ContactListAdapter(contactList,this));



    }

    private void  fillContacts()
    {
        contactList.add(new Contact("John","+12243774955"));
        contactList.add(new Contact("Jacob","+12243774955"));
    }




    public boolean onContextItemSelected(MenuItem item){
        Intent intent;
        if (item.getItemId() == 101) {
           intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + contactList.get(position).getPhone()));
        }
        else {
            intent = new Intent(Intent.ACTION_SEND);
            intent.putExtra("sms_body", "default content");
            intent.setType("vnd.android-dir/mms-sms");
        }

        startActivity(intent);

        return super.onContextItemSelected(item);
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        this.position = position;

    }


}
