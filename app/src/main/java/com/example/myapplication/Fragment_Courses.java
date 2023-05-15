package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

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
    Button button_text;
    String text_from_log;

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
        button_text = v.findViewById(R.id.btnCourse);

        // Переход на начальную страницу
        button_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.fragment_Start);
            }
        });

        // Переход на страницу с домашками + передача текста
        button_homeworks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data_transfer = text_from_log;
                Bundle bundle = new Bundle();
                bundle.putString("data", data_transfer);
                Navigation.findNavController(view).navigate(R.id.fragment_Homework, bundle);
            }
        });

        // Отображение переданного текста
        button_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String new_data = getArguments().getString("data");
                Toast.makeText(getActivity(), new_data, Toast.LENGTH_SHORT).show();
            }
        });

        // Создание списка на 200 элементов
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                text_from_log = "ListView element " + (i+1);
                Log.i("MyLog", "ListView element " + (i + 1));
                Toast.makeText(getActivity(), "ListView element " + (i + 1), Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }
}







