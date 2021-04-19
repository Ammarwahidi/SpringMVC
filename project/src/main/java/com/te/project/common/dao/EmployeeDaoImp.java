package com.te.project.common.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.te.project.common.dto.Employeebean;

@Repository
public class EmployeeDaoImp implements EmployeeDao {

	@Override
	public Employeebean authenticate(int id, String password) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("springdb");
			entityManager = entityManagerFactory.createEntityManager();

			Employeebean bean = entityManager.find(Employeebean.class, id);

			if (bean != null) {
				if (bean.getPassword().equals(password)) {
					System.out.println("Login Successfull");
					return bean;
				} else {
					System.out.println("Invalid cretential");
					return null;
				}

			} else {
				System.out.println("User not found");
				return null;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}

	}// end of auth

	@Override
	public Employeebean getEmployee(int id) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		try {

			entityManagerFactory = Persistence.createEntityManagerFactory("springdb");
			entityManager = entityManagerFactory.createEntityManager();

			Employeebean bean = entityManager.find(Employeebean.class, id);
			return bean;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}// end of getEmployee

	@Override
	public boolean getDeleteEmp(int id) {
		try {

			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Springdb");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();

			entityTransaction.begin();
			Employeebean bean = entityManager.find(Employeebean.class, id);
			if (bean != null) {
				entityManager.remove(bean);
				entityTransaction.commit();
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}// end of getDeleteEmp

	@Override
	public List<Employeebean> getAllEmployee() {
		try {

			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Springdb");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();

			entityTransaction.begin();
			String query = "from employeebean";

			Query query2 = entityManager.createQuery(query);
			List<Employeebean> data = query2.getResultList();
			if (data != null) {
				return data;
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public  boolean getAddEmployee(Employeebean employeebean) {
		EntityManagerFactory managerFactory=null;
		EntityManager manager = managerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		boolean isAdded = false;
		try {
			transaction.begin();
			manager.persist(employeebean);
			transaction.commit();
			isAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();
		return isAdded;

		
	}// End of addEmployee()

	

	@Override
	public boolean updateEmployee(Employeebean employeebean) {
		boolean isUpdated = false;
		EntityManagerFactory entityManagerFactory = null;
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			Employeebean bean = manager.find(Employeebean.class, employeebean.getId());

			if (!employeebean.getName().isEmpty() && employeebean.getName() != null) {
				bean.setName(employeebean.getName());

			}
			if (employeebean.getDob() != null) {
				bean.setDob(employeebean.getDob());
			}
			if (!employeebean.getPassword().isEmpty() && employeebean.getPassword() != null) {
				bean.setPassword(employeebean.getPassword());
			}

			transaction.commit();

			isUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();

		}
		return isUpdated;

	}// end of updateEmployee
}
