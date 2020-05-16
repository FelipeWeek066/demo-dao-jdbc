package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.impl.DepartmentDaoJDBC;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("\n=== teste 1: department insert ===");
		Department newDepartment = new Department(7, "Foods");

        
        System.out.println("Insert Complete!");
        
		System.out.println("\n=== teste 2: department update ===");
		Department newUpdateDepartment = new Department(6, "Marketing");
        departmentDao.update(newUpdateDepartment);
        System.out.println("Done!! update complete");
	}

}
