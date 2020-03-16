package model.services;

import java.util.ArrayList;
import java.util.List;

import model.entities.Company;

public class CompanyService {

	public List<Company> findAll(){
		
		//mock
		List<Company> list = new ArrayList<>();
		list.add(new Company(1, 0, "Vivo Empresas"));
		list.add(new Company(2, 0, "IBM Computers"));
		list.add(new Company(1, 0, "Samsung Electronics"));
		
		return list;
	}
}
