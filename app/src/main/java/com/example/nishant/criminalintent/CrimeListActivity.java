package com.example.nishant.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by Nishant on 3/22/2018.
 */

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
