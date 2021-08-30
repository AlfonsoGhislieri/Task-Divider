package com.example.afinal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.text.InputType;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;

public class Fragment1 extends Fragment implements View.OnClickListener {

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @org.jetbrains.annotations.NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);

        // Initialized all buttons
        Button btnContinue = view.findViewById(R.id.buttonContinue);
        Button btnTask = view.findViewById(R.id.buttonAddTask);
        Button btnUser = view.findViewById(R.id.buttonAddUser);
        btnTask.setOnClickListener(this);
        btnUser.setOnClickListener(this);
        btnContinue.setOnClickListener(this);

        // Auto capitalize both edit fields
        EditText edtTask = view.findViewById(R.id.addTask);
        edtTask.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
        EditText edtUser = view.findViewById(R.id.addUser);
        edtUser.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);

        return view; }

    // Create empty lists to store inputted tasks and users
    ArrayList<String> tasks = new ArrayList<>();
    ArrayList<String> users = new ArrayList<>();

    @Override
    // On click methods for buttons
    public void onClick(View v) {
        EditText addTask = getView().findViewById(R.id.addTask);
        EditText addUser = getView().findViewById(R.id.addUser);

        // If continue clicked move to next fragment
        if (v.getId() == R.id.buttonContinue) {
            // return errors if not enough users or tasks submitted
            if (tasks.size() < 1){
                addTask.setError("Enter at least 1 task!");}

            else if (users.size() < 2){
                addUser.setError("Enter at least 2 users!"); }

            else {
                // Send array list data over to second fragment
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("tasks", tasks);
                bundle.putStringArrayList("users", users);

                // Transition view to other fragment
                Fragment2 fragment2 = new Fragment2();
                fragment2.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment2).commit(); }}

        // add task to tasks list on button click
        else if (v.getId() == R.id.buttonAddTask) {
            // get text from field and convert to text
            String strAddTask = addTask.getText().toString();

            // if text field is empty return error
            if (TextUtils.isEmpty(strAddTask)){
                addTask.setError("Enter task!");}

            //if not empty add task to array
            else {
                tasks.add(strAddTask);
                addTask.setText(""); }}

        // add user to users list on button click
        else if (v.getId() == R.id.buttonAddUser) {
            String strAddUser = addUser.getText().toString();

            // if text field is empty return error
            if (TextUtils.isEmpty(strAddUser)) {
                addUser.setError("Enter a user!");}

            // if not empty add task to array
            else {
            users.add(strAddUser);
            addUser.setText(""); } }
    }
}