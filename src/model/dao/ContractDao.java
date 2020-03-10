package model.dao;

import java.util.List;

import model.entities.Company;
import model.entities.Contract;

public interface ContractDao {

	void insert(Contract contract);
	
	void update(Contract contract);
	
	void deleteById(Integer id);
	
	Contract findById(Integer id);
	
	List<Contract> findAll();
	
	List<Contract> findByCompany(Company company);
}
