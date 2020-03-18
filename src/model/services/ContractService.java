package model.services;

import java.util.List;

import model.dao.ContractDao;
import model.dao.DaoFactory;
import model.entities.Contract;

public class ContractService {

	ContractDao dao = DaoFactory.createcontractDao();
	
	public List<Contract> findAll(){
		
		return dao.findAll();
	}
	
	public void saveOrUpdate(Contract obj) {
		if(obj.getId() == null) {
			dao.insert(obj);
		}
		else {
			dao.update(obj);
		}
	}
}
