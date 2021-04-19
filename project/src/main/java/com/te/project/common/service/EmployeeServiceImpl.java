package com.te.project.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.project.common.dao.EmployeeDao;
import com.te.project.common.dto.Employeebean;
@Service

public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
  private EmployeeDao dao;
	@Override
	public Employeebean authenticate(int id, String password) {
		
		return dao.authenticate(id, password);
	}

	@Override
	public Employeebean getEmployee(int id) {
		
		return dao.getEmployee(id);
	}

	@Override
	public boolean getDeleteEmp(int id) {
		
		return dao.getDeleteEmp(id);
	}

	@Override
	public List<Employeebean> getAllEmployee() {
		return dao.getAllEmployee();
	}

	@Override
	public boolean getAddEmployee(Employeebean employeebean) {
		if (employeebean.getId() < 1) {

			return false;
		}

		return dao.getAddEmployee(employeebean);
	}

	@Override
	public boolean updateEmployee(Employeebean employeebean) {
		if (employeebean.getId() < 1) {
			return false;
		} else {

			if (dao.getEmployee(employeebean.getId()) != null) {
				return dao.updateEmployee(employeebean);
			} else {
				return false;
			}
		}

	}// end od update

}
