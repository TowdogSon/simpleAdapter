package com.example.noreal.simpleadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.LinkedList;

/**
 * Created by NoReal on 2018/1/3.
 */

public class AnimalAdapter extends BaseAdapter {

private LinkedList<Animal> mdata;
private Context mcontext;

public  AnimalAdapter(LinkedList<Animal> mdata,Context mcontext){

    this.mcontext=mcontext;
    this.mdata=mdata;


}

    //以下是adapter必须重写的方法,其中 getView 是重点,它负责展示控件的获取和赋值

    @Override
    public int getCount() {
        return mdata.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        //如果不存在再进行初始化
    if (convertView == null){

        convertView = LayoutInflater.from(mcontext).inflate(R.layout.list_item,parent,false);
        holder = new ViewHolder();
        holder.imageView=convertView.findViewById(R.id.imgtou);
        holder.name= convertView.findViewById(R.id.name);
        holder.word =convertView.findViewById(R.id.says);
        convertView.setTag(holder);
    }
    else{
        holder = (ViewHolder) convertView.getTag(); //tag接收object类型,如果存在就直接取出
    }

        holder.imageView.setBackgroundResource(mdata.get(position).getHeadPic());
        holder.name.setText(mdata.get(position).getName());
        holder.word.setText(mdata.get(position).getWords());
        return  convertView;
    }

    //在最后增加一个条目
    public void addData(Animal animal){

    if (mdata==null){
        mdata = new LinkedList<>();
    }
     mdata.add(animal);
     this.notifyDataSetChanged();
    }
    //删除最后一个条目
    public void removelastItem (){

        if (mdata.size()>0){
            mdata.remove(mdata.size()-1);
            notifyDataSetChanged();
        }

    }

    //删除所有数据

    public void clearAll (){


        if (mdata!=null){

            mdata.clear();
            notifyDataSetChanged();;
        }
    }
}

    class ViewHolder{

    ImageView imageView ;
    TextView  name ;
    TextView  word ;
   }
