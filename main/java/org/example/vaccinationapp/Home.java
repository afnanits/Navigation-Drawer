package org.example.vaccinationapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Home extends Fragment {







    private  static  RecyclerView subrecview;
    public Home() {

    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        View rootView = inflater.inflate(R.layout.home, container, false);
        subrecview = rootView.findViewById(R.id.recyclerview);





        NewsAdapter adapter = new NewsAdapter(getActivity());

        subrecview.setAdapter(adapter);
        subrecview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false));
        Util util = new Util();

        ArrayList<NEWS> subjects = new ArrayList<>();
        subjects = util.getAllsubjects();
        adapter.setSubjects(subjects);
        subrecview.setAdapter(adapter);
        return rootView;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Home");
    }

}


