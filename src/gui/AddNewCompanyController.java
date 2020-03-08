package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class AddNewCompanyController implements Initializable{

	ObservableList<String> typeList = FXCollections.observableArrayList("Public", "Private");
	
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
	private DatePicker datePickerContract;
	
	@FXML
	private TextField txtFieldDuration;
	
	@FXML
	private ChoiceBox<String> choiceBoxType;
	
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

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		choiceBoxType.setItems(typeList);
	}
}
