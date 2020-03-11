package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DbException;
import model.dao.ContractDao;
import model.entities.Company;
import model.entities.Contract;

public class ContractDaoJDBC implements ContractDao{

	private Connection conn;
	
	public ContractDaoJDBC(Connection conn) {
		this.conn = conn; 
	}
	
	@Override
	public void insert(Contract contract) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Contract contract) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Contract findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contract> findAll(){
		
		List<Contract> list = new ArrayList<>();
		
		String sql = "SELECT * FROM contractinfo ORDER BY CompanyId";
		
		try(PreparedStatement st = conn.prepareStatement(sql)){
			st.execute();
			
			try(ResultSet rs = st.getResultSet()){
				while(rs.next()) {
					Company company = new Company(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), 
							rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), 
							rs.getString(11), rs.getInt(12), rs.getString(13));
					Contract contract = new Contract(rs.getInt(1), rs.getDate(2), 
							rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
					
					list.add(contract);
				}
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		return list;
	}

	@Override
	public List<Contract> findByCompany(Company company) {
		// TODO Auto-generated method stub
		return null;
	}
}
