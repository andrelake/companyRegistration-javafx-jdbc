package model.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.Statement;

import db.DbException;
import gui.util.Utils;
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
		
		String sql = "INSERT INTO contractinfo "
				+ "(Date, Duration, RenewalType, CompanyId, CompanyType) VALUES "
				+ "(?, ?, ?, ?, ?)";
		
		try(PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			
			setStatement(contract, st);
			
			int rowsAffected = st.executeUpdate();
			if(rowsAffected > 0) {
				try(ResultSet rs = st.getGeneratedKeys()) {
					if(rs.next()) {
						int id = rs.getInt(1);
						contract.setId(id);
					}
				}
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public void update(Contract contract) {
		
		String sql = "UPDATE contractinfo SET "
				+ "Date = ?, Duration = ?, RenewalType = ?, CompanyId = ?, CompanyType = ? "
				+ "WHERE Id = ?";
		
		try(PreparedStatement st = conn.prepareStatement(sql)) {
			
			setStatement(contract, st);
			st.setInt(6, contract.getId());
			st.executeUpdate();
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public void deleteById(Integer id) {
		
		String sql = "DELETE FROM contractinfo WHERE Id = ?";
		
		try(PreparedStatement st = conn.prepareStatement(sql)) {
			
			st.setInt(1, id);
			
			int rowsAffected = st.executeUpdate();
			if(rowsAffected == 0) {
				throw new DbException("Id not found");
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public Contract findById(Integer id) {
		
		String sql = "SELECT contractinfo.*,company.Name as CompanyName "
				+ "FROM contractinfo INNER JOIN company "
				+ "ON contractinfo.CompanyId = company.Id "
				+ "WHERE contractinfo.Id = ?";
				
		try(PreparedStatement st = conn.prepareStatement(sql)) {
			st.setInt(1, id);
			st.executeQuery();
			
			try(ResultSet rs = st.getResultSet()) {
				
				if(rs.next()) {
					Company comp = instantiateCompany(rs);
					Contract cont = instantiateContract(rs, comp);
					return cont;
				}
				else {
					throw new DbException("Id not found.");
				}
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
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
		
		String sql = "SELECT contractinfo.*, company.Name as CompName "
				+ "FROM contractinfo INNER JOIN company "
				+ "ON contractinfo.CompanyId = company.Id "
				+ "WHERE CompanyId = ?";
		
		try(PreparedStatement st = conn.prepareStatement(sql)){
			st.setInt(1, company.getId());
			st.executeQuery();
			
			List<Contract> list = new ArrayList<>();
			Map<Integer, Company> map = new HashMap<>();
			
			try(ResultSet rs = st.getResultSet()){
				
				while(rs.next()) {
					
					Company comp = map.get(rs.getInt("CompanyId"));
					
					if(comp == null) {
						comp = instantiateCompany(rs);
						map.put(rs.getInt("CompanyId"), comp);
					}
					
					Contract cont = instantiateContract(rs, comp); 
					list.add(cont);
				}
			}
			return list;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	private Contract instantiateContract(ResultSet rs, Company comp) throws SQLException {
		Contract contract = new Contract();
		contract.setId(rs.getInt("Id"));
		contract.setDate(new java.util.Date(rs.getTimestamp("Date").getTime()));
		contract.setDuration(rs.getString("Duration"));
		contract.setRenewalType(rs.getString("RenewalType"));
		contract.setCompany(comp);
		return contract;
	}
	
	private Company instantiateCompany(ResultSet rs) throws SQLException {
		
		Company company = new Company(rs.getInt(5), rs.getInt(6), rs.getString(7));
		
		return company;
	}
	

	private void setStatement(Contract contract, PreparedStatement st) throws SQLException {
		st.setDate(1, (new java.sql.Date(contract.getDate().getTime())));
		st.setString(2, contract.getDuration());
		st.setString(3, contract.getRenewalType());
		st.setInt(4, contract.getCompany().getId());
		st.setInt(5, contract.getCompany().getType());
	}
}
