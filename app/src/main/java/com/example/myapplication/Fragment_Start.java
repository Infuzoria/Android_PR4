package com.example.myapplication;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Fragment_Start extends Fragment {

    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment__start, container, false);

        Button button_courses = v.findViewById(R.id.button1);
        Button button_homeworks = v.findViewById(R.id.button2);
        Button button_notification = v.findViewById(R.id.message);
        Button button_banner = v.findViewById(R.id.server);


        button_courses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.fragment_Courses);
            }
        });

        button_homeworks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.fragment_Homework);
            }
        });

        // Создание канала для уведомлений
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name_for_chanel = "new_chanel";
            String description = "Chanel for notifications about courses";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("CHANNEL", name_for_chanel, importance);
            channel.setDescription(description);
            NotificationManager notificationManager = requireContext().
                    getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        Intent notificationIntent = new Intent(getActivity(),  MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getActivity(), 0,
                notificationIntent, PendingIntent.FLAG_CANCEL_CURRENT);

        // Создание самого уведомления
        button_notification.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                NotificationCompat.Builder builder = new NotificationCompat.Builder(requireContext(),
                        "CHANNEL")
                        .setSmallIcon(R.drawable.___2023_03_30_00_50_42_photoroom_png_photoroom)
                        .setContentText("Появилось новое задание, пора приступать к решению!")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(requireContext());

                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.POST_NOTIFICATIONS)
                        != PackageManager.PERMISSION_GRANTED){
                    return;
                }

                notificationManager.notify(1, builder.build());
            }
        });

        button_banner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getActivity().getApplicationContext(), NewService.class);
                getActivity().startService(intent);
//                Toast.makeText(getActivity(), "MYAPP", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }
}















