package model.dao;

import db.DB;
import model.dao.impl.CompanyDaoJDBC;
import model.dao.impl.ContractDaoJDBC;

public class DaoFactory {

	public static CompanyDao createcompanyDao() {
		return new CompanyDaoJDBC(DB.getConnection());
	}
	
	public static ContractDao createcontractDao() {
		return new ContractDaoJDBC(DB.getConnection());
	}
}
