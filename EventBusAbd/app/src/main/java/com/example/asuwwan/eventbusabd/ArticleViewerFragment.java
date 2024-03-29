package com.example.asuwwan.eventbusabd;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link ArticleViewerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ArticleViewerFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    private Article article;



    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param article Parameter 1.
     * @return A new instance of fragment ArticleViewerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ArticleViewerFragment newInstance(Article article) {
        ArticleViewerFragment fragment = new ArticleViewerFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM1, article);
        fragment.setArguments(args);
        return fragment;
    }

    public ArticleViewerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            article = getArguments().getParcelable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_article_viewer, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView title=(TextView)view.findViewById(R.id.articleTitle);
        TextView content=(TextView)view.findViewById(R.id.articleContent);
        title.setText(article.getTitle().toString());
        content.setText(article.getContent().toString());

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }



}
