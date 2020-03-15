package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DbException;
import model.dao.CompanyDao;
import model.entities.Company;

public class CompanyDaoJDBC implements CompanyDao {

	private Connection conn;

	public CompanyDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Company obj) {
		
		String sql = "INSERT INTO company (Type, Name, Adress, City, Phone, Email, FantasyName, MainCategory, NationalId, "
				+ "LegalStatus, TotalEmployees, AdministratorName) VALUES "
				+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try(PreparedStatement st = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			
			setStatement(st, obj);
			
			int rowsAffected = st.executeUpdate();
			if(rowsAffected > 0) {
				try(ResultSet rs = st.getGeneratedKeys()) {
					if(rs.next()) {
						int id = rs.getInt(1);
						obj.setId(id);
					}
				}
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public void update(Company obj) {
		
		String sql = "UPDATE company SET "
				+ "Type = ?, Name = ?, Adress = ?, City = ?, Phone = ?, Email = ?, FantasyName = ?, MainCategory = ?, "
				+ "NationalId = ?, LegalStatus = ?, TotalEmployees = ?, AdministratorName = ? WHERE Id = ?";

		try(PreparedStatement st = conn.prepareStatement(sql)) {
			
			setStatement(st, obj);
			st.setInt(13, obj.getId());
			st.executeUpdate();
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public void deleteById(Integer id) {
		
		String sql = "DELETE FROM company WHERE Id = ?";
		
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
	public Company findById(Integer id) {
		
		String sql = "SELECT * FROM company WHERE Id = ?";
		Company company = null;
		
		try(PreparedStatement st = conn.prepareStatement(sql)) {
			st.setInt(1, id);
			st.execute();
			
			try(ResultSet rs = st.getResultSet()) {
				while (rs.next()) {
					company = instantiateCompany(rs);
				}
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		return company;
	}

	@Override
	public List<Company> findAll() {
		
		List<Company> list = new ArrayList<>();

		String sql = "SELECT * FROM company ORDER BY Name";

		try (PreparedStatement st = conn.prepareStatement(sql)) {
			st.execute();

			try (ResultSet rs = st.getResultSet()) {
				while (rs.next()) {
					Company company = instantiateCompany(rs);
					
					list.add(company);
				}
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		return list;
	}
	
	private Company instantiateCompany(ResultSet rs) throws SQLException {
		
		Company company = new Company(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
				rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
				rs.getString(10), rs.getString(11), rs.getInt(12), rs.getString(13));
		
		return company;
	}
	
	private void setStatement(PreparedStatement st, Company obj) throws SQLException {
		st.setInt(1, obj.getType());
		st.setString(2, obj.getName());
		st.setString(3, obj.getAdress());
		st.setString(4, obj.getCity());
		st.setString(5, obj.getPhone());
		st.setString(6, obj.getEmail());
		st.setString(7, obj.getFantasyName());
		st.setString(8, obj.getMainCategory());
		st.setString(9, obj.getNationalId());
		st.setString(10, obj.getLegalStatus());
		st.setInt(11, obj.getTotalEmployees());
		st.setString(12, obj.getAdmName());
	}
}
