package gui;

import java.io.IOException;

import application.Main;
import javafx.fxml.FXML;
import model.entities.Company;
import model.entities.Contract;

public class MainViewController {

	private Main main;
	
	@FXML
	private void onBtnHomeAction() throws IOException {
		main.showMainItems();
	}
	
	@FXML
	private void onBtnAddAction() throws IOException {
		Company company = new Company();
		Contract contract = new Contract();
		main.showAddStage(company, contract);
	}
	
}
