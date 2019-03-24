package com.riztech.firebasedemo.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.riztech.firebasedemo.R;
import com.riztech.firebasedemo.model.Employee;

import java.util.List;

public class EmployeeAdapter  extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>{

    List<Employee> employeeList;
    public EmployeeAdapter(List<Employee> employeeList){
        this.employeeList = employeeList;
    }


    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_employee, null);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder employeeViewHolder, int position) {

        Employee employee = employeeList.get(position);

        employeeViewHolder.txtAddress.setText(employee.address);
        employeeViewHolder.txtName.setText(employee.name);

    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    class EmployeeViewHolder extends RecyclerView.ViewHolder{

        TextView txtName, txtAddress;

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtAddress = itemView.findViewById(R.id.txtAddress);
        }
    }

}
