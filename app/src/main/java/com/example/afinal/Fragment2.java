package com.example.afinal;

import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Fragment2 extends Fragment implements View.OnClickListener {
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @org.jetbrains.annotations.NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, container, false);

        // Implement Buttons
        Button btnBack = view.findViewById(R.id.buttonBack);
        btnBack.setOnClickListener(this);

        // Initialize list view
        ListView listView = view.findViewById(R.id.listView);

        // extract data from other fragment
        Bundle bundle = this.getArguments();
        ArrayList tasks = bundle.getStringArrayList("tasks");
        ArrayList users = bundle.getStringArrayList("users");

        // initialize variables as boundaries
        int sizeTasks = tasks.size();
        int sizeUsers = users.size();

        // use calculate method to get final list
        ArrayList results = calculate(sizeUsers, sizeTasks, tasks, users);

        // Display listview using custom XML "customtext" file
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(getContext(),R.layout.customtext, results);

        listView.setAdapter(arrayAdapter2);

        return view;
    }

    private ArrayList<String> calculate(int sizeUsers, int sizeTasks, ArrayList tasks, ArrayList users) {
        // create empty list that will contain divided task list
        ArrayList<ArrayList> dividedTasks = new ArrayList<ArrayList>();

        // create an array within divided tasks array for each user inputted
        for (int i = 0; i < sizeUsers; i++) {
            // create a temporary array
            ArrayList<String> temp = new ArrayList<String>();

            // get string from users array at position i
            String x = (String) users.get(i);
            // add user string to new temp array
            temp.add(x + ": ");

            // add temp array to main list
            dividedTasks.add(temp);}

        // iterate through each task and randomly assign to a user
        for (int j = 0; j < sizeTasks; j++) {
            // get string from tasks array at position i
            String y = (String) tasks.get(j);

            // get a random number with between 0 and total users - 1 (zero indexing considered)
            int random_int = (int) Math.floor(Math.random() * (sizeUsers - 0) + 0);

            // set task randomly to a user
            dividedTasks.get(random_int).add(y); }

        // create an empty ArrayList to store final results list
        ArrayList<String> results = new ArrayList<>();

        // iterate though each separate array in dividedTasks and 2d array
        for (int x = 0; x < dividedTasks.size(); x++){
            // create stringbuilder to store former list as a string
            StringBuilder sb = new StringBuilder();

            for (int y = 0; y < dividedTasks.get(x).size(); y++){
                sb.append(dividedTasks.get(x).get(y));
                sb.append(" - "); }

            // add former list to final list as a string
            results.add(String.valueOf(sb)); }
        return results;
    }

    @Override
        // On click method
        public void onClick (View v){
            // on button click return to first fragment
            if (v.getId() == R.id.buttonBack) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.fragment_container, new Fragment1());
                fr.commit();
            }
        }
}