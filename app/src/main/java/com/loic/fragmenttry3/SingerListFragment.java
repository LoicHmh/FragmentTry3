package com.loic.fragmenttry3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 胡敏浩 on 2017/10/28.
 */

public class SingerListFragment extends Fragment {
    private RecyclerView recyclerView;
    private SingerAdapter singerAdapter;

/*    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_singer_list,container,false);
        recyclerView = (RecyclerView) view.findViewById(R.id.singer_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();
        Log.i("SingerListFragment","onCreateView done");
        return view;
    }

    private void updateUI(){
        SingerLab singerLab = SingerLab.get(getActivity());
        List<Singer> singers = singerLab.getSingers();

        singerAdapter = new SingerAdapter(singers);
        recyclerView.setAdapter(singerAdapter);
        Log.i("SingerListFragment","updateUI done");
    }

    private class SingerHolder extends RecyclerView.ViewHolder{
        //public TextView textView;
        private TextView textViewSingerNumber;
        private TextView textViewSingerAngle;
        private TextView textViewSingerHeight;

        private Singer singer;

        public void bindSinger(Singer singer){
            this.singer = singer;
            textViewSingerNumber.setText( ""+this.singer.getColorIndex());
            textViewSingerAngle.setText(""+this.singer.getAngle());
            textViewSingerHeight.setText(""+this.singer.getHeight());
            Log.i("SingerListFragment","bindSinger done");
        }

        public SingerHolder(View itemView){
            super(itemView);
            //textView = (TextView) itemView;
            textViewSingerNumber = (TextView) itemView.findViewById(R.id.singer_number);
            textViewSingerAngle = (TextView) itemView.findViewById(R.id.singer_angle);
            textViewSingerHeight = (TextView) itemView.findViewById(R.id.singer_height);
            Log.i("SingerListFragment","singerHolder done");
        }
    }

    private class SingerAdapter extends RecyclerView.Adapter<SingerHolder>{
        private List<Singer> singers;
        public SingerAdapter(List<Singer> singerList){
            singers = singerList;
        }

        @Override
        public SingerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflate = LayoutInflater.from(getActivity());
            View view = layoutInflate.inflate(R.layout.list_item_singer,parent,false);
            Log.i("SingerListFragment","onCreateViewHolder done");
            return new SingerHolder(view);
        }

        @Override
        public void onBindViewHolder(SingerHolder holder, int position) {
            Singer singer = singers.get(position);
            //holder.textView.setText(singer.getColorIndex());
            holder.bindSinger(singer);
            Log.i("SingerListFragment","onBindViewHolder done");
        }

        @Override
        public int getItemCount() {
            Log.i("SingerListFragment","getItemCount done"+singers.size());
            return singers.size();
        }
    }
}
