package com.te.project.common.dao;

import java.util.List;

import com.te.project.common.dto.Employeebean;

public interface EmployeeDao {
	public Employeebean authenticate(int id,String password);
	public Employeebean getEmployee(int id);
	public boolean getDeleteEmp(int id);
	public List<Employeebean> getAllEmployee();
	public boolean getAddEmployee(Employeebean employeebean);
	public boolean updateEmployee(Employeebean employeebean);

}
