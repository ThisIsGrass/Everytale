package com.idlewink.everytale;

import android.support.v4.app.Fragment;
import android.util.Log;

public class CharaListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        Log.d("REACHED", " AT EXACTLY ON BEFORE RETURN OF A CHARALISTFRAGMENT");
        return new CharaListFragment();
    }
}
