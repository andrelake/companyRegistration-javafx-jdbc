package model.dao;

import java.util.List;

import model.entities.Company;

public interface CompanyDao {

	void insert(Company company);
	
	void update(Company company);
	
	void deleteById(Integer id);
	
	Company findById(Integer id);
	
	List<Company> findAll();
}
