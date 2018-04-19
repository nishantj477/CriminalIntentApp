package com.example.nishant.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Nishant on 3/22/2018.
 */

public class CrimeListFragment extends Fragment {
    private RecyclerView mCrimeRecyclerView;
    private CrimeAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crime_list, container, false);   //hookup view to fragment.
        mCrimeRecyclerView = (RecyclerView) view
                .findViewById(R.id.crime_recycler_view);   //creates a RecyclerView of crimes but only for 12 crimes enough to fill a screen at a time.
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));  //RecyclerView needs layoutManager to work which handles positioning and scrolling.
        updateUI();
        return view;
    }


    private class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {  //This ViewHolder maintains a reference to a single view: the title TextView
        private TextView mTitleTextView;
        private TextView mDateTextView;
        private CheckBox mSolvedCheckBox;

        private Crime mCrime;

        public CrimeHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mTitleTextView = (TextView)
                    itemView.findViewById(R.id.list_item_crime_title_text_view);
            mDateTextView = (TextView)
                    itemView.findViewById(R.id.list_item_crime_date_text_view);
            mSolvedCheckBox = (CheckBox)
                    itemView.findViewById(R.id.list_item_crime_solved_check_box);
        }

        public void bindCrime(Crime crime) {
            mCrime = crime;
            mTitleTextView.setText(mCrime.getmTitle());
            mDateTextView.setText(mCrime.getMdate().toString());
            mSolvedCheckBox.setChecked(mCrime.ismSolved());
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(getActivity(), mCrime.getmTitle().toString() + " Clicked!", Toast.LENGTH_SHORT ).show();
        }
    }


    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder> {  //The Adapter creates ViewHolders and binds viewholders to data from model layer.
        private List<Crime> mCrimes;
        public CrimeAdapter(List<Crime> crimes) {
            mCrimes = crimes;
        }

        @Override
        public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {  //This method is called by RecyclerView When it needs to display a new view.
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater
                    .inflate(R.layout.list_item_crime, parent, false);
            return new CrimeHolder(view);
        }
        @Override
        public void onBindViewHolder(CrimeHolder holder, int position) {  //binds viewholder view to model's object.
            Crime crime = mCrimes.get(position);
            holder.bindCrime(crime);
        }
        @Override
        public int getItemCount() {
            return mCrimes.size();
        }
    }


    private void updateUI() {
        CrimeLab crimeLab = CrimeLab.getCrimeLab(getActivity());

        List<Crime> crimes = crimeLab.getCrimes();
        mAdapter = new CrimeAdapter(crimes);
        mCrimeRecyclerView.setAdapter(mAdapter);
    }
}

