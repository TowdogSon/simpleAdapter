package com.example.noreal.simpleadapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private LinkedList<Animal> mdata = null;
    private Context mContext;
    private AnimalAdapter adapter;


    private Button additem;
    private Button removeitem;
    private Button clearitem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //listView
        this.mdata =new LinkedList<>();
        mContext =MainActivity.this;
        this.mdata.add(new Animal("牛","哞哞",R.mipmap.christmas1));
        this.mdata.add(new Animal("羊","咩咩",R.mipmap.christmas31));
        this.mdata.add(new Animal("狗","汪汪",R.mipmap.santa));

        adapter = new AnimalAdapter(mdata,mContext);
        ListView list = findViewById(R.id.list);
        list.setAdapter(adapter);

        operationMethods();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"你点击了第"+String.valueOf(position)+"行",Toast.LENGTH_SHORT).show();
            }
        });


    }

    private  void operationMethods(){


        //点击增加条目
        additem = findViewById(R.id.add);
        additem.setOnClickListener(this);

        //点击删除条目
        removeitem =findViewById(R.id.remove);
        removeitem.setOnClickListener(this);


        //点击清空items

        clearitem = findViewById(R.id.clear);
        clearitem.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
       if (v.getId()==R.id.remove) {
           adapter.removelastItem();
       }else if (v.getId()==R.id.clear){
           adapter.clearAll();
       }else {
           adapter.addData(new Animal("猫","喵喵",R.mipmap.christmas1));

       }
    }
}
