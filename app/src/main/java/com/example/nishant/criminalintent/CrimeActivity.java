package com.example.nishant.criminalintent;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;

public class CrimeActivity extends SingleFragmentActivity{

   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container); //retrieve the CrimeFragment from the FragmentManager.

        if(fragment == null) {
            fragment = new CrimeFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment) //A fragment should be placed in the spot with an id of fragment_controller in activity_fragment.
                    .commit();
        }
    }*/

    @Override
    protected Fragment createFragment() {
        return new CrimeFragment();   //return an instance of the fragment that the activity ie activity_fragment is hosting.
    }
}
