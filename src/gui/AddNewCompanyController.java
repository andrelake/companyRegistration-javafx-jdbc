package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.entities.Company;
import model.entities.Contract;
import model.services.CompanyService;
import model.services.ContractService;

public class AddNewCompanyController implements Initializable{

	ObservableList<String> typeList = FXCollections.observableArrayList("Semiannual", "Yearly");
	ObservableList<String> legalStatusList = FXCollections.observableArrayList("Active", "Inactive");
	
	private Contract cont;
	
	private Company entity;
	
	private CompanyService service;
	
	private ContractService servicecont;
	
	// Basic Info
	@FXML
	private TextField txtFieldType;
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
	
	// Company info
	@FXML
	private TextField txtFieldId;
	@FXML
	private TextField txtFieldFantasyName;
	@FXML
	private TextField txtFieldMainCategory;
	@FXML
	private TextField txtFieldNationalId;
	@FXML
	private ComboBox<String> comboBoxLegalStatus;
	@FXML
	private TextField txtFieldTotalEmployees;
	@FXML
	private TextField txtFieldAdministratorName;
	
	@FXML
	private Button btnOk;
	@FXML
	private Button btnCancel;
	
	public Contract getCont() {
		return cont;
	}

	public void setContract(Contract cont) {
		this.cont = cont;
	}

	public Company getEntity() {
		return entity;
	}

	public void setCompany(Company entity) {
		this.entity = entity;
	}

	public void setCompanyService(CompanyService service) {
		this.service = service;
	}
	
	public void setContractService(ContractService service) {
		this.servicecont = service;
	}
	@FXML
	public void onBtnOkAction(ActionEvent event) {
		entity = getFormDataCompany();
		cont = getFormDataContract();
		service.saveOrUpdate(entity);
		servicecont.saveOrUpdate(cont);
		Utils.currentStage(event).close();
	}
	
	private Contract getFormDataContract() {
		Contract contract = new Contract();
		contract.setDate(Utils.tryLocalDateToDate(datePickerContract));
		contract.setDuration(txtFieldDuration.getText());
		contract.setRenewalType(choiceBoxType.getValue());
		contract.setCompany(entity);
		return contract;
	}

	private Company getFormDataCompany() {
		Company obj = new Company();
		obj.setId(Utils.tryParseToInt(txtFieldId.getText()));
		obj.setType(Utils.tryParseToInt(txtFieldType.getText()));
		obj.setName(txtFieldName.getText());
		obj.setAdress(txtFieldAdress.getText());
		obj.setCity(txtFieldCity.getText());
		obj.setPhone(txtFieldPhone.getText());
		obj.setEmail(txtFieldEmail.getText());
		obj.setFantasyName(txtFieldFantasyName.getText());
		obj.setMainCategory(txtFieldMainCategory.getText());
		obj.setNationalId(txtFieldNationalId.getText());
		obj.setLegalStatus(comboBoxLegalStatus.getValue());
		obj.setTotalEmployees(Utils.tryParseToInt(txtFieldTotalEmployees.getText()));
		obj.setAdmName(txtFieldAdministratorName.getText());
		return obj;
	}

	@FXML
	public void onBtnCancelAction(ActionEvent event) {
		Utils.currentStage(event).close();
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		choiceBoxType.setItems(typeList);
		comboBoxLegalStatus.setItems(legalStatusList);
		initializeNodes();
	}

	private void initializeNodes() {
		Utils.formatDatePicker(datePickerContract, "dd/MM/yyyy");
		
	}
}
