package com.example.noreal.simpleadapter;

/**
 * Created by NoReal on 2018/1/3.
 */

public class Animal {
    public String name;
    public String words;
    public int    headPic;

    //初始化方法,构造方法
    public Animal(String name,String words,int headPic){

        this.name=name;
        this.words=words;
        this.headPic=headPic;

    }

    public int getHeadPic(){

        return headPic;
    }

    public String getName(){

        return name;

    }

    public  String getWords(){
        return words;
    }

}
