package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao{
	
	private Connection conn;

	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	@Override
	public void insert(Department obj) {
		PreparedStatement st = null;
		try {
		   st = conn.prepareStatement(
				   "INSERT INTO department "
				 + "(Id, Name)"
				 + "VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
				 
		   st.setInt(1, obj.getId());
		   st.setString(2, obj.getName());
		   
		   int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
		   
		    }
		}catch(SQLException e) {
		  throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
		
		
	}

	@Override
	public void update(Department obj) {
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
					"UPDATE department "
					+"Set Name = ? "
				    +"WHERE Id = ? "
            );
			st.setString(1, obj.getName());
			st.setInt(2, obj.getId());
			
			st.executeUpdate();
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
			
		}finally {
			DB.closeStatement(st);
		}
		
		
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM department WHERE ID = ?");
					
		    st.setInt(1, id);
		    
		    st.executeUpdate();
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public Department findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * From department WHERE Id = ?"); 
			st.setInt(1, id);
			
			rs = st.executeQuery();
			if(rs.next()) {
				Department obj = instantiateDepartment(rs);
				return obj;
			}
			return null;
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		
		}finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
	}

	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("Id"));
		dep.setName(rs.getString("Name"));
		return dep;
	}
	@Override
	public List<Department> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM department ORDER BY Name");
			rs = st.executeQuery();
			
			List<Department> list = new ArrayList<>();
			Map<Integer, Department> map = new HashMap();
			
			while (rs.next()) {
				Department dep = map.get(rs.getInt("Id"));
				
				if(dep == null) {
					dep = instantiateDepartment(rs);
					map.put(rs.getInt("Id"), dep);
				}
				list.add(dep);
			}
			return list;
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
			
		}
	   
	}

}
