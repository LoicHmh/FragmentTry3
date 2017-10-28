package com.loic.fragmenttry3;


import android.support.v4.app.Fragment;

/**
 * Created by 胡敏浩 on 2017/10/28.
 */

public class SingerListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new SingerListFragment();
    }
}
