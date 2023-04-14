package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Courses extends Fragment {
    View v;
    private ListView listView;
    Button button_home;
    Button button_homeworks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment__courses, container, false);
        List<String> courses_list = new ArrayList<String>();
        for (int i = 0; i < 200; i++){
            courses_list.add("Course " + (i+1));
        }

        listView = v.findViewById(R.id.list_view);

        AdapterForCourses adapterForCourses = new AdapterForCourses(getActivity(), R.layout.courses_style, courses_list);
        listView.setAdapter(adapterForCourses);

        button_home = v.findViewById(R.id.imageButton2);
        button_homeworks = v.findViewById(R.id.button4);


        button_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment_Start fragment_start = new Fragment_Start();
                setNewFragment(fragment_start);
            }
        });

        button_homeworks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment_Homework fragment_homeworks = new Fragment_Homework();
                setNewFragment(fragment_homeworks);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("MyLog", "ListView element " + (i + 1));
                Toast.makeText(getActivity(), "ListView element " + (i + 1), Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }
    private void setNewFragment(Fragment fragment){
        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.frame_layout, fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

}







