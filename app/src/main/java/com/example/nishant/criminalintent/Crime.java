package com.example.nishant.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Nishant on 3/21/2018.
 */

public class Crime {
    private UUID mid;
    private String mTitle;
    private Date mdate;
    private boolean mSolved;


    public Crime() {
        mid = UUID.randomUUID();
        mdate = new Date();
    }

    public UUID getMid() {
        return mid;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmTitle() {
        return mTitle;
    }

    public Date getMdate() {
        return mdate;
    }

    public void setMdate(Date mdate) {
        this.mdate = mdate;
    }

    public boolean ismSolved() {
        return mSolved;
    }

    public void setmSolved(boolean mSolved) {
        this.mSolved = mSolved;
    }
}
