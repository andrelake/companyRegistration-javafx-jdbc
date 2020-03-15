package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DbException;
import model.dao.ContractDao;
import model.entities.Company;
import model.entities.Contract;

public class ContractDaoJDBC implements ContractDao {

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
		
		String sql = "SELECT contractinfo.*, company.Name as CompName "
				+ "FROM contractinfo INNER JOIN company "
				+ "ON contractinfo.CompanyId = company.Id "
				+ "ORDER BY CompName";
		
		try(PreparedStatement st = conn.prepareStatement(sql)){
			st.executeQuery();
			
			List<Contract> list = new ArrayList<>();
			Map<Integer, Company> map = new HashMap<>();
			
			try(ResultSet rs = st.getResultSet()){
				
				while(rs.next()) {
					Company company = map.get(rs.getInt("CompanyId"));
					
					if(company == null) {
						company = instantiateCompany(rs);
						map.put(rs.getInt("CompanyId"), company);
					}
					
					Contract cont = instantiateContract(rs, company); 
					list.add(cont);
				}
			}
			return list;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public List<Contract> findByCompany(Company company) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Contract instantiateContract(ResultSet rs, Company comp) throws SQLException {
		Contract contract = new Contract();
		contract.setId(rs.getInt("Id"));
		contract.setDate(rs.getDate("Date"));
		contract.setDuration(rs.getString("Duration"));
		contract.setRenewalType(rs.getString("RenewalType"));
		contract.setCompany(comp);
		return contract;
	}
	
	private Company instantiateCompany(ResultSet rs) throws SQLException {
		
		Company company = new Company(rs.getInt(5), rs.getInt(6), rs.getString(7));
		
		return company;
	}
}
