package application;

import java.util.List;

import model.dao.CompanyDao;
import model.dao.DaoFactory;
import model.entities.Company;

public class ProgramDbTest {

	public static void main(String[] args) {

		CompanyDao companyDao = DaoFactory.createcompanyDao();
		
		//Test1 - Company findall		
//		List<Company> list = companyDao.findAll();
//		for(Company company : list) {
//			System.out.println(company);
//		}
		
		//Test2 - Company findById
//		Company company = companyDao.findById(1);
//		System.out.println(company);
		
		//Test3 - Company insert
		Company comp = new Company(null, 1, "Blabla Ltda", "Rua blablabla 123", "Ourinhos", "5514989890000", "blabla@gmail.com", 
				"Associacao Blablabla E cia Ltda", "Eletrodomésticos", "04234154009313", "Inactive", 54, "Nestor Silva");
		
		companyDao.insert(comp);
		
	}
}
