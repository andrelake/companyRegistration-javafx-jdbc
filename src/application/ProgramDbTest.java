package application;

import java.util.List;

import model.dao.CompanyDao;
import model.dao.DaoFactory;
import model.entities.Company;

public class ProgramDbTest {

	public static void main(String[] args) {

		//Test1 - Company findall
		CompanyDao companyDao = DaoFactory.createcompanyDao();
		
//		List<Company> list = companyDao.findAll();
//		for(Company company : list) {
//			System.out.println(company);
//		}
		
		//Test2 - Company findById
		Company company = companyDao.findById(1);
		System.out.println(company);
	}
}
