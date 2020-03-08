package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddNewCompanyController {

	@FXML
	private TextField txtFieldName;
	
	@FXML
	private TextField txtFieldAdress;
	
	@FXML
	private TextField txtFieldCity;
	
	@FXML
	private TextField txtFieldPhone;
	
	@FXML
	private TextField txtFieldEmail;
	
	@FXML
	private Button btnOk;
	
	@FXML
	private Button btnCancel;
	
	@FXML
	public void onBtnOkAction() {
		System.out.println("onBtnOkAction");
	}
	
	@FXML
	public void onBtnCancelAction() {
		System.out.println("onBtnCancelAction");
	}
}
