package com.idlewink.everytale;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public abstract class SingleFragmentActivity extends AppCompatActivity {
    //THE METHOD RETURNS A FRAGMENT
    //THIS METHOD IS EMPTY! AND IS ONLY DETERMINED BY THE ONE THAT INHERITS IT!
    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fm = getSupportFragmentManager();
        //WITH WHATEVER FRAGMENT IT IS... IF IT INHERITS THIS ABSTRACT CLASS...
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            //THE FRAGMENT CLASS MUST IMPLEMENT CREATE FRAGMENT
            //THIS WAS OVERWRITTEN TO BE THE TYPE THE CLASS THAT CALLED THIS PARENT ACTIVITY TO BE
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }
}
