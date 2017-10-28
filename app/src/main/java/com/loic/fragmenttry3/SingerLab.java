package com.loic.fragmenttry3;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 胡敏浩 on 2017/10/28.
 */

public class SingerLab {
    private static SingerLab singerLab;
    private List<Singer> singers;

    public static SingerLab get(Context context){
        if (singerLab == null){
            singerLab = new SingerLab(context);
        }
        return singerLab;
    }

    private SingerLab(Context context){
        singers = new ArrayList<>();
        for (int i = 0; i < 60; i++){
            Singer singer = new Singer();
            singer.setAngle(i*60);
            singer.setHeight(i);
            singer.setColorIndex(i);
            singer.setMusicIndex(i);
            singers.add(singer);
        }
        Log.i("SingerLab","new Singers done"+singers.size());
    }

    public List<Singer> getSingers(){
        return singers;
    }

    public Singer getSinger(int index){
        try{
            return singers.get(index);
        }catch (Exception e){
            Log.e("music index:","Out of length!");
            e.printStackTrace();
        }
        return null;
    }
}
