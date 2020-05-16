package model.dao;

import java.util.List;

import model.dao.impl.SellerDaoJDBC;
import model.entities.Seller;

public class DaoFactory {
public static SellerDao createSellerDao() {
	return new SellerDaoJDBC() {
		
		@Override
		public void update(Seller obj) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void insert(Seller obj) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public Seller findById(Integer id) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public List<Seller> findAll() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public void deleteById(Integer id) {
			// TODO Auto-generated method stub
			
		}
	};
}
}
