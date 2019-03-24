package com.riztech.firebasedemo.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.riztech.firebasedemo.R;
import com.riztech.firebasedemo.model.Employee;

public class AddEmployeeActivity extends AppCompatActivity {

    EditText edtName, edtAddress, edtDesignation, edtDepartment;


    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("employee");

        edtName = findViewById(R.id.edtName);
        edtAddress = findViewById(R.id.edtAddress);
        edtDesignation = findViewById(R.id.edtDesignation);
        edtDepartment = findViewById(R.id.edtDepartment);
    }

    public void save(View view) {

        String name = edtName.getText().toString();
        String address = edtAddress.getText().toString();
        String department = edtDepartment.getText().toString();
        String designation = edtDesignation.getText().toString();

        Employee employee = new Employee(name, address, designation, department);

        myRef.child(myRef.push().getKey()).setValue(employee).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(getApplicationContext(),"Data Added success fully",Toast.LENGTH_LONG).show();
                edtAddress.setText("");
                edtName.setText("");
                edtDepartment.setText("");
                edtDesignation.setText("");
            }
        });
    }
}
