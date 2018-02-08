package com.example.master.calculator.Listeners;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by Master on 08-Feb-18.
 */

public class HistoryListViewListener implements AdapterView.OnItemClickListener{

    private ListView historyView;

    HistoryListViewListener(ListView lstView){
        this.historyView = lstView;
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
