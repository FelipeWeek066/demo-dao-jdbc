package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("\n=== teste 1: department insert ===");
		Department newDepartment = new Department(6, "Foods");

        
        System.out.println("Insert Complete!");
        
		System.out.println("\n=== teste 2: department update ===");
		Department newUpdateDepartment = new Department(6, "Marketing");
        
        System.out.println("Done!! update complete");
        
		System.out.println("\n=== teste 3: department delete ===");
		
		
		System.out.println("Done, deleted");
        
		
		System.out.println("\n=== teste 4: find department by id ===");
        
		System.out.println("\n=== teste 5: find all departments ===");
        
		List<Department> dep = departmentDao.findAll();
        
		for(Department obj : dep) {
			System.out.println(obj);
		}
	}

}
