package model.services;

import java.util.List;

import model.dao.CompanyDao;
import model.dao.DaoFactory;
import model.entities.Company;

public class CompanyService {

	private CompanyDao dao = DaoFactory.createcompanyDao();
	
	public List<Company> findAll(){
		
		return dao.findAll();
	}
}
