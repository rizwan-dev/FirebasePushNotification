package com.riztech.firebasedemo.view;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.riztech.firebasedemo.R;
import com.riztech.firebasedemo.adapter.EmployeeAdapter;
import com.riztech.firebasedemo.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class ViewEmployeeActivity extends AppCompatActivity {

    DatabaseReference myRef;

    RecyclerView rvEmployee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_employee);

        rvEmployee = findViewById(R.id.rvEmployee);
        rvEmployee.setLayoutManager(new LinearLayoutManager(this));

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("employee");


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                Log.e("Count ", "" + snapshot.getChildrenCount());
                List<Employee> employeeList = new ArrayList<>();
                for (DataSnapshot employeeSnapshot : snapshot.getChildren()) {
                    Employee employee = employeeSnapshot.getValue(Employee.class);
                    Log.e("Get Data", employee.name);
                    employeeList.add(employee);
                }

                EmployeeAdapter adapter = new EmployeeAdapter(employeeList);
                rvEmployee.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError firebaseError) {
                Log.e("The read failed: ", firebaseError.getMessage());
            }

        });
    }
}
