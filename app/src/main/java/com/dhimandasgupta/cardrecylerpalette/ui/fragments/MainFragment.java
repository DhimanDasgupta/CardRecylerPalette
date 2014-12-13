package com.dhimandasgupta.cardrecylerpalette.ui.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dhimandasgupta.cardrecylerpalette.R;
import com.dhimandasgupta.cardrecylerpalette.model.CardItemGenerator;
import com.dhimandasgupta.cardrecylerpalette.ui.adapters.CardAdapter;

/**
 * Created by dhimandasgupta on 12/13/14.
 */
public class MainFragment extends Fragment {
    private CardAdapter mCardAdapter;

    public MainFragment() {

    }

    public static MainFragment newInstance() {
        final MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final RecyclerView recyclerView = (RecyclerView) view
                .findViewById(R.id.fragment_main_recyler_view);
        if (recyclerView != null) {
            final int columnCount = view.getContext().getResources().getInteger(R.integer.column_count);
            mCardAdapter = new CardAdapter(CardItemGenerator.getCardItems(), columnCount);
            final GridLayoutManager layoutManager = new GridLayoutManager(
                    view.getContext(), columnCount, GridLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(layoutManager);

            recyclerView.setAdapter(mCardAdapter);
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
