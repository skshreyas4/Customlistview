package com.example.shreyassk.realcustomlistview;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Abc> arrayList;
    ListView list;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrayList = new ArrayList<>();
        Abc obj = new Abc();
        obj.firstname = "ram";
        obj.secondname = "gopal";
        obj.id = 12;
        Abc abj = new Abc();
        abj.firstname = "varma";
        abj.secondname = "raj";
        obj.id = 234;
        arrayList.add(obj);
        arrayList.add(abj);
        int i;
        for (i = 0; i < arrayList.size(); i++) {

            Log.e("Listofarray", arrayList.get(i).id + " " + arrayList.get(i).firstname + " " + arrayList.get(i).secondname);
        }
        Adaptor adaptor = new Adaptor(MainActivity.this, 0);
        list.setAdapter(adaptor);

    }


        class Adaptor extends ArrayAdapter {

        public Adaptor(Context context, int resource) {
            super(context, resource);
        }

        public int getCount() {
            return arrayList.size();

        }

        public View getView(int position, View convertView, View parent) {
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            convertView =inflater.inflate(R.layout.adaptor,null);
            TextView firstName,secondName;
            ImageView image;
            firstName=(TextView)convertView.findViewById(R.id.firstName);
            secondName=(TextView)convertView.findViewById(R.id.secondName);
            image = (ImageView)convertView.findViewById(R.id.imageView1);

            firstName.setText(arrayList.get(position).firstname);
            secondName.setText(arrayList.get(position).secondname);
            image.setImageResource(arrayList.get(position).id);
            return convertView;
        }

    }
}
    class  Abc
    {
        String firstname,secondname;
        int id;
    }
