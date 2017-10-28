package com.loic.fragmenttry3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by 胡敏浩 on 2017/10/27.
 */

public class FirstFragment extends Fragment {
    private Singer singer;
    private EditText angle;
    private Button confirmButton;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        singer=new Singer();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v= inflater.inflate(R.layout.fragment_first,container,false);

        angle= (EditText)v.findViewById(R.id.angle);
        angle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try{
                    singer.setAngle(Integer.parseInt(s.toString()));
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        confirmButton = (Button)v.findViewById(R.id.confirm_button);
        confirmButton.setText("OK");
        confirmButton.setEnabled(false);
        return v;
    }
}
