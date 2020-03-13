package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	public void insert(Company company) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Company company) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

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
					Company company = new Company(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getString(11), rs.getInt(12), rs.getString(13));
					
					list.add(company);
				}
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		return list;
	}
	
	public Company instantiateCompany(ResultSet rs) throws SQLException {
		
		Company company = new Company(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
				rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
				rs.getString(10), rs.getString(11), rs.getInt(12), rs.getString(13));
		
		return company;
	}
}
