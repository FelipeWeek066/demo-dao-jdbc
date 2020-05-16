package application;

import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.impl.DepartmentDaoJDBC;
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
        System.out.print("enter with a id to find");
        int id = sc.nextInt();
        Department dep = departmentDao.findById(id);
        System.out.println(dep);
	}

}