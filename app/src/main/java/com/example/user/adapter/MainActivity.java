package com.example.user.adapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    class Data {
        int photo;
        String name;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Data[] transData = new Data[4];
        for(int i = 0; i < transData.length; i++) {
            transData[i] = new Data();
        }
        transData[0].name = "Bicycle";
        transData[1].name = "Bike";
        transData[2].name = "Car";
        transData[3].name = "Bus";
        transData[0].photo = R.drawable.trans1;
        transData[1].photo = R.drawable.trans2;
        transData[2].photo = R.drawable.trans3;
        transData[3].photo = R.drawable.trans4;

        myAdapter transAdapter = new myAdapter(transData, R.layout.trans_list);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(transAdapter);

        String[] messageData = new String[]{"Message1", "Message2", "Message3", "Message4", "Message5", "Message6"};

        ArrayAdapter<String> messageAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,messageData);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(messageAdapter);

        Data[] cubeeData = new Data[10];
        for (int i = 0;i < cubeeData.length; i++) {
            cubeeData[i] = new Data();
        }
        cubeeData[0].name="Cry";
        cubeeData[1].name="shake";
        cubeeData[2].name="Bye";
        cubeeData[3].name="Pissed";
        cubeeData[4].name="Past out";
        cubeeData[5].name=":)";
        cubeeData[6].name="Great";
        cubeeData[7].name="Hi";
        cubeeData[8].name="Scared";
        cubeeData[9].name="Laugh";
        cubeeData[0].photo=R.drawable.cubee1;
        cubeeData[1].photo=R.drawable.cubee2;
        cubeeData[2].photo=R.drawable.cubee3;
        cubeeData[3].photo=R.drawable.cubee4;
        cubeeData[4].photo=R.drawable.cubee5;
        cubeeData[5].photo=R.drawable.cubee6;
        cubeeData[6].photo=R.drawable.cubee7;
        cubeeData[7].photo=R.drawable.cubee8;
        cubeeData[8].photo=R.drawable.cubee9;
        cubeeData[9].photo=R.drawable.cubee10;

        myAdapter cubeeAdapter = new myAdapter(cubeeData, R.layout.cubee_list);
        GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setNumColumns(3);
        gridView.setAdapter(cubeeAdapter);
    }



    public class myAdapter extends BaseAdapter {
        private Data[] data;
        private int view;

        public myAdapter(Data[] data, int view) {
            this.data = data;
            this.view = view;
        }

        @Override
        public int getCount() {return data.length; }

        @Override
        public Data getItem(int position) { return data[position]; }

        @Override
        public long getItemId(int position) { return 0;}

        @Override
        public View getView(int position, View rowView, ViewGroup parent) {

            rowView = getLayoutInflater().inflate(view, parent, false);

            TextView name = (TextView) rowView.findViewById(R.id.name);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);
            name.setText(data[position].name);
            imageView.setImageResource(data[position].photo);

            return rowView;
        }
    }
}
