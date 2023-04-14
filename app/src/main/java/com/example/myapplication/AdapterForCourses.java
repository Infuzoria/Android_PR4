package com.example.myapplication;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterForCourses extends ArrayAdapter<String> {
    private LayoutInflater inflater;
    private int layout;
    private List<String> courses;

    public AdapterForCourses(Context context, int resource, List<String> courses) {
        super(context, resource, courses);
        this.courses = courses;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(this.layout, parent, false);

        TextView course_text = view.findViewById(R.id.courses_text);
        course_text.setText(courses.get(position));

        ImageView course_image = view.findViewById(R.id.courses_imagine);
        course_image.setImageResource(R.drawable.___2023_03_30_03_34_38);
        return view;
    }
}
