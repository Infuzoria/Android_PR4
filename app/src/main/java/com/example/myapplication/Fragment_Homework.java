package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Fragment_Homework extends Fragment {

    View v;
    ArrayList<One_Homework> homeworks = new ArrayList<One_Homework>();
    Button button_courses;
    Button button_home;
    Button button_text;
    String text_from_log;

    // Создание списка из 200 записей
    private void setInitialData(){
        for(int i = 0; i < 200; i++){
            homeworks.add(new One_Homework ("Homework " + (i+1), R.drawable.___2023_03_30_05_26_44));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment__homework, container, false);

        AdapterForHomeworks.OnStateClickListener stateClickListener = new AdapterForHomeworks.OnStateClickListener() {
            @Override
            public void onStateClick(One_Homework homework, int position) {
                text_from_log = "RecyclerView Element " + (position+1);
                Log.d("MyLog", "RecyclerView Element " + (position + 1));
                Toast.makeText(getActivity(), "RecyclerView Element " + (position + 1), Toast.LENGTH_SHORT).show();
            }
        };

        setInitialData();
        RecyclerView recyclerView = v.findViewById(R.id.recycle_list);
        AdapterForHomeworks adapter = new AdapterForHomeworks(getActivity(), homeworks, stateClickListener);
        recyclerView.setAdapter(adapter);

        button_home = v.findViewById(R.id.imageButton3);
        button_courses = v.findViewById(R.id.button5);
        button_text = v.findViewById(R.id.btnHomqwork);

        // Переход на начальную страницу
        button_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.fragment_Start);
            }
        });

        // Переход на страницу с курсами + передача текста
        button_courses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data_transfer = text_from_log;
                Bundle bundle = new Bundle();
                bundle.putString("data", data_transfer);
                Navigation.findNavController(view).navigate(R.id.fragment_Courses, bundle);
            }
        });

        // Отображение переданной информации
        button_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String new_data = getArguments().getString("data");
                Toast.makeText(getActivity(), new_data, Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }
}











