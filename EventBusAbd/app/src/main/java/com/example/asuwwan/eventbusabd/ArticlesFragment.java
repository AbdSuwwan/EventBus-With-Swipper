package com.example.asuwwan.eventbusabd;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import de.greenrobot.event.EventBus;


public class ArticlesFragment extends Fragment  {


    public static final Article[] articls=
            {
                    new Article("Java","Hello in Java World\nHello in Java World\nHello in Java World\nHello in Java World\nHello in Java World\nHello in Java World\nHello in Java World\nHello in Java World\nHello in Java World\nHello in Java World\nHello in Java World\nHello in Java World\nHello in Java World\nHello in Java World\nHello in Java World\nHello in Java World\nHello in Java World\nHello in Java World\nHello in Java World\nHello in Java World\nHello in Java World\nHello in Java World\nHello in Java World\nHello in Java World\nHello in Java World\nHello in Java World\nHello in Java World"),
                    new Article("C++","Hello in c++ World"),
                    new Article("C#","Hello in C# World"),
                    new Article("Objective-C","Hello in Objective-C  World"),
                    new Article("Python","Hello in Python World")
            };




    /**
     * The fragment's ListView/GridView.
     */
    private AbsListView mListView;


    private ListAdapter mAdapter;


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ArticlesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        mAdapter = new ArrayAdapter<Article>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, articls);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item, container, false);

        // Set the adapter
        mListView = (ListView) view.findViewById(android.R.id.list);
        ((AdapterView<ListAdapter>) mListView).setAdapter(mAdapter);

        // Set OnItemClickListener so we can be notified on item clicks
       // mListView.setOnItemClickListener(this);


        return view;
    }


    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        mListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        EventBus.getDefault().post(new EventMessage(articls[position]));

                    }
                }

        );
    }

    @Override
    public void onDetach() {
        super.onDetach();
       // mListener = null;
    }




    public void setEmptyText(CharSequence emptyText) {
        View emptyView = mListView.getEmptyView();

        if (emptyView instanceof TextView) {
            ((TextView) emptyView).setText(emptyText);
        }
    }




}
