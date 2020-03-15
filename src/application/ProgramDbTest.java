package application;

import java.util.List;

import model.dao.CompanyDao;
import model.dao.ContractDao;
import model.dao.DaoFactory;
import model.entities.Contract;

public class ProgramDbTest {

	public static void main(String[] args) {

//		CompanyDao companyDao = DaoFactory.createcompanyDao();
		ContractDao contractDao = DaoFactory.createcontractDao();
		
		//Test1 - Company findall		
//		List<Company> list = companyDao.findAll();
//		for(Company company : list) {
//			System.out.println(company);
//		}
		
		//Test2 - Company findById
//		Company company = companyDao.findById(1);
//		System.out.println(company);
		
		//Test3 - Company insert
//		Company comp = new Company(null, 0, "Prefeitura de Mimimi", "Rua mimimi 443", "Mimimi", "5512949596070", "prefmimimi@gmail.com", 
//				"Prefeitura Municipal de Mimimi", "Public agency", "02333258001109", "Active", 100, "Vandir Cunha");
//		
//		companyDao.insert(comp);
		
		//Test4 - Company update
//		Company comp = companyDao.findById(3);
//		comp.setCity("Chavantes");;
//		companyDao.update(comp);
		
		//Test5 - Company delete
//		companyDao.deleteById(3);
		
		//Contract Tests
		//Test1 - Contract findAll
		List<Contract> list = contractDao.findAll();
		for(Contract cont : list) {
			System.out.println(cont);
		}
		
	}
}
